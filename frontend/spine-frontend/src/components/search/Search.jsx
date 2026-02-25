import React, { useState } from 'react';
import {Link} from "react-router-dom";

const BookSearch = () => {
    const [query, setQuery] = useState('');
    const [books, setBooks] = useState([]);

    const handleSearch = async (e) => {
        e.preventDefault();
        if (!query) return;
        try {
            const response = await fetch(`http://localhost:8080/api/books/search?query=${query}`);
            const data = await response.json();
            setBooks(data);
        }
        catch (error) {
            console.error("Error fetching books:", error);
        }
    };

    return (
        <div>
            <form onSubmit={handleSearch}>
                <input type="text" value={query} onChange={(e) => setQuery(e.target.value)} />
                <button type="submit">Search</button>
            </form>

            {books.length > 0 ? (
                books.map(book => (
                    <Link to={`/books/${book.id}`} key={book.id}>
                        <div className="book-card">
                            <img src={book.imageUrl} alt={book.title} />
                            <h3>{book.title}</h3>
                        </div>
                    </Link>
                ))
            ) : (
                <p>No books found.</p>
            )}
        </div>
    );
};

export default BookSearch;
