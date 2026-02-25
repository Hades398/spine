import {NavLink} from "react-router";
import React from "react";
import "./Navbar.css"

function Navbar() {
    return (
        <nav>
            <NavLink to="/">
                Home
            </NavLink>

            <NavLink to="/library">
                My Library
            </NavLink>

            <NavLink to="/explore">
                Explore
            </NavLink>

            <NavLink to="/friends">
                Friends
            </NavLink>
        </nav>
    );
}

export default Navbar;