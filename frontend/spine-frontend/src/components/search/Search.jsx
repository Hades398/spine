import React, { useState } from 'react';

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
                <input type="text" placeholder="Search by title..." value={query} onChange={(e) => setQuery(e.target.value)} />
                <button type="submit">Search</button>
            </form>

            <ul>
                {books.map(book => (
                    <li key={book.id}>
                        <img
                            src={book.imageUrl}
                            alt={book.title}
                        />
                        <p>{book.title}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default BookSearch;

























































































