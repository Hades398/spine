import React from 'react';
import { BrowserRouter, Routes, Route} from 'react-router-dom';
import './App.css';
import Navbar from './components/navbar/Navbar';
import Header from "./components/header/Header";
import Home from "./pages/home/Home";
import Library from "./pages/library/Library";
import Explore from "./pages/explore/Explore";
import Friends from "./pages/friends/Friends";
import BookDetail from './components/book_detail/BookDetail';



function App() {
  return (
      <BrowserRouter>
        <Header />
        <Navbar />

        <main>
          <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/library" element={<Library />} />
              <Route path="/explore" element={<Explore />} />
              <Route path="/friends" element={<Friends />} />
              <Route path="/books/:id" element = {<BookDetail />} />
          </Routes>
        </main>
      </BrowserRouter>
  );
}
export default App;