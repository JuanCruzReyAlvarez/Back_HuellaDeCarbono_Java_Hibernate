import React from "react";
import { Navbar } from "./components/Navbar.jsx";
import { Sidebar } from "./components/Sidebar.jsx";
import { Register } from "./components/Register.jsx";
import { Login } from "./components/Login.jsx";
import { Route, Routes } from "react-router-dom";

const App = () => {
    return (
        <div>
            <Routes>
                <Route path="/register" element={<Register />} />
                <Route path="/login" element={<Login />} />
                <Route
                    exact
                    path="/"
                    element={
                        <>
                            <Navbar />
                            <Sidebar />
                        </>
                    }
                />
            </Routes>
        </div>
    );
};

export default App;
