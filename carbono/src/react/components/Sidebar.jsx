import React from "react";
import ".././styles/Sidebar.css";
import { Advices } from "./Advices";

import { Home } from "./Home.jsx";
export const Sidebar = () => {
    return (
        <div className="container">
            <div className="sidebar">
                <ul>
                    {/* <!-- Rol de organizacion --> */}
                    <li>Registrar Mediciones</li>
                    <li>Gestionar Solicitudes</li>
                    <li>Calculadora HC</li>
                    <li>Reportes</li>
                    <li>Recomendaciones</li>

                    {/* <!-- Rol de Agente Sectorial --> */}
                    <li>Reportes</li>
                    <li>Recomendaciones</li>

                    {/* <!-- Rol de Miembro de Org --> */}
                    <li>Calculadora HC</li>
                    <li>Reportes</li>
                    <li>Gestionar Solicitudes</li>
                    <li>Registrar Trayectos</li>
                    <li>Recomendaciones</li>
                </ul>
            </div>
            <div className="contenido">
                <Home />
            </div>
        </div>
    );
};
