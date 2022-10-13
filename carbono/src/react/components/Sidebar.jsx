import React from "react";
import { useEffect, useState } from "react";
import ".././styles/Sidebar.css";
import { Advices } from "./Advices.jsx";
import { Request } from "./Request.jsx";

import { Home } from "./Home.jsx";
import { Register } from "./Register";
export const Sidebar = () => {
    const [usuario, setUser] = useState({});

    useEffect(() => {
        const isUserLogg = window.localStorage.getItem("UserLoggedInfo");
        if (isUserLogg) {
            setUser(JSON.parse(isUserLogg));
        }
    }, []);

    console.log("USUARIO LOG", usuario);

    //MIEMBRO,AGENTESECTORIAL,ORGANIZACION,ADMINISTRADOR

    return (
        <div className="container">
            <div className="sidebar">
                <ul>
                    {/* <!-- Rol de organizacion --> */}
                    {usuario ? (
                        usuario.token && usuario.rol === "ORGANIZACION" ? (
                            <>
                                <li>Calculadora HC</li>
                                <li>Gestionar Solicitudes</li>
                                <li>Registrar Mediciones</li>
                                <li>Recomendaciones</li>
                                <li>Reportes</li>
                            </>
                        ) : (
                            <></>
                        )
                    ) : (
                        <></>
                    )}

                    {/* <!-- Rol de Agente Sectorial --> */}
                    {usuario ? (
                        usuario.token && usuario.rol === "AGENTESECTORIAL" ? (
                            <>
                                <li>Reportes</li>
                                <li>Recomendaciones</li>
                            </>
                        ) : (
                            <></>
                        )
                    ) : (
                        <></>
                    )}
                    {/* <!-- Rol de Miembro de Org --> */}
                    {usuario ? (
                        usuario.token && usuario.rol === "MIEMBRO" ? (
                            <>
                                <li>Calculadora HC</li>
                                <li>Gestionar Solicitudes</li>
                                <li>Registrar Trayectos</li>
                                <li>Recomendaciones</li>
                                <li>Reportes</li>
                            </>
                        ) : (
                            <></>
                        )
                    ) : (
                        <></>
                    )}
                </ul>
            </div>
            <div className="contenido">
                <Request />
            </div>
        </div>
    );
};
