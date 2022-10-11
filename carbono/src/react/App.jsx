import React from "react";
import { Navbar } from "./components/Navbar.jsx";
import { Sidebar } from "./components/Sidebar.jsx";
import { Register } from "./components/Register.jsx";
import { Login } from "./components/Login.jsx";
import { Hall } from "./components/Hall.jsx";
import { Route, Routes } from "react-router-dom"; // {libreia,libreria}
import { Advices } from "./components/Advices.jsx";

const App = () => {
    return (
        <div>
            <Routes>
                <Route path="/register" element={<Register />} />
                <Route path="/login" element={<Login />} />
                <Route path="/hall" element={<Hall />} />
                <Route path="/advices" element={<Advices />} />
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
