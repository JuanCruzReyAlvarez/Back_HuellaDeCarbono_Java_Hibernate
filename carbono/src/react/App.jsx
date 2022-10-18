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
import { RegisterSector } from "./components/RegisterSector";
import { Aplications } from "./components/Aplications.jsx";
import { Transports } from "./components/Transports.jsx";
import { Footer } from "./components/Footer.jsx";
import { Emissions } from "./components/Emissions.jsx";

const App = () => {
    return (
        <div>
            <Routes>
                <Route path="/register" element={<Register />} />
                <Route path="/login" element={<Login />} />

                <Route path="/advices" element={
                    <>
                        <Sidebar />
                        <Advices />

                    </>
                } />
                <Route path="/registerSector" element={<> <Navbar /> <Sidebar /> <RegisterSector /> <Footer /></>} />
                <Route path="/calculators" element={<> <Navbar /> <Sidebar /><Calculator /> <Footer /> </>} />
                <Route path="/registerMeasurements" element={<> <Navbar /> <Sidebar /> <RegisterMeasurements /><Footer /> </>} />
                <Route path="/request" element={<><Navbar /> <Sidebar /> <Request /><Footer /> </>} />
                <Route path="/addContacts" element={<> <Navbar /><Sidebar /> <Contacts /> </>} />
                <Route path="/contactsList" element={<><Navbar /><Sidebar /> <ContactsList /> </>} />
                <Route path="/report" element={<> <Navbar /><Sidebar /> <Report /> <Footer /></>} />
                <Route path="/solMiembro" element={<><Navbar /><Sidebar /><Aplications /> <Footer /></>} />
                <Route path="/transports" element={<><Navbar /><Sidebar /><Transports /><Footer /> </>} />
                <Route path="/emissions" element={<><Navbar /><Sidebar /><Emissions /><Footer /> </>} />

                <Route path="/hall" element={<Hall />} />

                <Route
                    exact
                    path="/"
                    element={
                        <>
                            <Sidebar/>
                            <Advices/>
                        </>
                    }
                />
            </Routes>
        </div>
    );
};

export default App;
