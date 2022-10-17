import React from "react";
import { Navbar } from "./components/Navbar.jsx";
import { Sidebar } from "./components/Sidebar.jsx";
import { Register } from "./components/Register.jsx";
import { Login } from "./components/Login.jsx";
import { Hall } from "./components/Hall.jsx";
import { Request } from "./components/Request.jsx";
import { Route, Routes } from "react-router-dom"; // {libreia,libreria}
import { Advices } from "./components/Advices.jsx";
import { RegisterMeasurements } from "./components/RegisterMeasurements.jsx";
import { ContactsList } from "./components/ContactsList.jsx";
import { Contacts } from "./components/AddContacts.jsx";
import { Report } from "./components/Report.jsx";
import { Calculator } from "./components/calculators.jsx";
import { Footer } from "./components/Footer.jsx";
import { Aplications } from "./components/Aplications.jsx";

const App = () => {
    return (
        <div>
            <Routes>
                <Route path="/register" element={<Register />} />
                <Route path="/login" element={<Login />} />
                <Route path="/hall" element={<Hall />} />
                <Route path="/advices" element={<Advices />} />
                <Route path="/request" element={<Request />} />
                <Route path="/registerMeasurements" element={<RegisterMeasurements />} />
                <Route path="/contactsList" element={<ContactsList />} />
                <Route path="/addContacts" element={<Contacts />} />
                <Route path="/report" element={<Report />} />
                <Route path="/calculators" element={<Calculator />} />
                <Route path="/solMiembro" element={<Aplications />} />
                
                
                
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
