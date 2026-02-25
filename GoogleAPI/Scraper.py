import requests
import psycopg2
import time

# Project ID: spine-487303 on google
# Spine-GoogleAPIKey name
# API Key: AIzaSyAa6YTCGc4oSK49p3TKlBXaC8E5P1L4FKI

DB_CONFIG = {
    "dbname": "spine",
    "user": "postgres",
    "password": "Soccer!1028",
    "host": "localhost",
    "port": "5432"
}
API_KEY = "AIzaSyAa6YTCGc4oSK49p3TKlBXaC8E5P1L4FKI"


def setup_database():
    """Connects to Postgres and creates the books table."""
    conn = psycopg2.connect(**DB_CONFIG)
    cur = conn.cursor()
    cur.execute('''
        CREATE TABLE IF NOT EXISTS books (
            id SERIAL PRIMARY KEY,
            google_id TEXT UNIQUE NOT NULL,
            title TEXT,
            authors TEXT,
            isbn TEXT,
            description TEXT,
            image_url TEXT
        )
    ''')
    conn.commit()
    return conn, cur


def fetch_books_paginated(query, total_to_fetch=100):
    """Fetches books in batches of 40 (the max Google allows per request)."""
    all_items = []
    # Google allows max 40 per single request
    batch_size = 40

    for start_index in range(0, total_to_fetch, batch_size):
        print(f"Fetching books {start_index} to {start_index + batch_size}...")

        url = "https://www.googleapis.com/books/v1/volumes"
        params = {
            'q': query,
            'key': API_KEY,
            'maxResults': batch_size,
            'startIndex': start_index  # This is the "Page Turner"
        }

        try:
            response = requests.get(url, params=params)
            response.raise_for_status()  # Check for HTTP errors
            items = response.json().get('items', [])

            if not items:
                break  # No more books left for this search

            all_items.extend(items)

            # Pause for a split second to be polite to Google's servers
            time.sleep(0.5)

        except Exception as e:
            print(f"Error fetching batch: {e}")
            break

    return all_items


def save_to_postgres(conn, cur, book_items):
    for item in book_items:
        v_info = item.get('volumeInfo', {})

        google_id = item.get('id')
        title = v_info.get('title', 'Unknown')
        authors = ", ".join(v_info.get('authors', ['Unknown']))
        description = v_info.get('description', '')

        image_links = v_info.get('imageLinks', {})
        image_url = image_links.get('thumbnail') or image_links.get('smallThumbnail')

        isbns = v_info.get('industryIdentifiers', [])
        isbn = next((i['identifier'] for i in isbns if i['type'] == 'ISBN_13'), "N/A")

        query = """
            INSERT INTO books (google_id, title, authors, isbn, description, image_url)
            VALUES (%s, %s, %s, %s, %s, %s)
            ON CONFLICT (google_id) DO NOTHING;
        """
        cur.execute(query, (google_id, title, authors, isbn, description, image_url))

    conn.commit()
    print(f"Processed {len(book_items)} items into PostgreSQL.")


if __name__ == "__main__":
    connection, cursor = setup_database()
    search = input("Search for books to add to Postgres: ")
    results = fetch_books_paginated(search)

    if results:
        save_to_postgres(connection, cursor, results)

    cursor.close()
    connection.close()
