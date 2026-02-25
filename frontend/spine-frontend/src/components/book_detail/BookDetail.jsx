// Handles redirects to a books page, displays reviews, author, description, etc

import React, { useEffect, useState} from 'react';
import {useParams} from "react-router";

const BookDetail = () => {
    const { id } = useParams();
    const [book, setBook] = useState(null);
    const [dataIsLoaded, setDataIsLoaded] = useState(false);

    useEffect(() => {
        fetch(`http://localhost:8080/api/books/${id}`)
            .then((res) => res.json())
            .then((json) => {
                setBook(json);
                setDataIsLoaded(true)
            });
    }, [id]);

    if (!dataIsLoaded) {
        return (
            <div>
                <h1>
                    Please wait...
                </h1>
            </div>
        );
    }

    return (
        <div className="bookdetails">
            <h1>
                {book.title}
            </h1>
            <img src={book.imageUrl} alt={book.title} style={{width: '300px'}}/>
            <p>
                {book.description}
            </p>
        </div>


    )
}

export default BookDetail;