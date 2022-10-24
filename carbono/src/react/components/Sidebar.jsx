import React from "react";
import { useEffect, useState } from "react";
import { Route, Routes, Link } from "react-router-dom"; // {libreia,libreria}

import ".././styles/Sidebar.css";

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
            <input type="checkbox" className="openSidebarMenu , Ondeta" id="openSidebarMenu"></input>
            <label for="openSidebarMenu" className="sidebarIconToggle">
                <div className="spinner diagonal part-1"></div>
                <div className="spinner horizontal"></div>
                <div className="spinner diagonal part-2"></div>
            </label>
            <div id="sidebarMenu">
                <ul class="sidebarMenuInner">
                    <li></li>

                    {/* <Link to="/"><li>Pagina Principal</li></Link> */}

                    {/* <!-- Rol de organizacion --> */}
                    {usuario ? (
                        usuario.token && usuario.rol === "ORGANIZACION" ? (
                            <>
                                <Link to="/advices"><li>Recomendaciones</li></Link> 
                                <Link to="/addcontacts"><li>AddConacts</li></Link>
                                {/* <Link to="/contactsList"><li>Contactos</li></Link> */}
                                <Link to="/request"><li>Gestionar Solicitudes</li></Link>
                                <Link to="/registerMeasurements"><li>Registrar Mediciones</li></Link>
                                <Link to="/report"><li>Reportes</li></Link>
                                <Link to="/calculators"><li>Calculadora HC</li></Link>
                                <Link to="/registerSector"><li>Registrar Sectores</li></Link>

                            </>
                        ) : (
                            <></>
                        )
                    ) : (
                        <></>
                    )}

                    {/* <!-- Rol de Agente Sectorial --> */}
                    {usuario ? (
                        usuario.token && usuario.rol === "AGENTE_SECTORIAL" ? (
                            <>
                                <Link to="/report"><li>Reportes</li></Link>
                                {/* <Link to="/advices"><li>Recomendaciones</li></Link> */}
                                <Link to="/calculators"><li>Calculadora HC</li></Link>
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
                                <Link to="/calculators"><li>Calculadora HC</li></Link>
                                {/* <Link to="/advices"><li>Recomendaciones</li></Link> */}
                                <Link to="/report"><li>Reportes</li></Link>
                                <Link to="/solMiembro"><li>Crear Solicitud</li></Link>
                                {/* <Link to="/registrarTrayecto"><li>Registrar Trayecto</li></Link> */}
                            </>
                        ) : (
                            <></>
                        )
                    ) : (
                        <></>
                    )}
                    {/* <!-- Rol Administrados AGREGAR LAS DOS DE CALCULO  --> */}
                    {usuario ? (
                        usuario.token && usuario.rol === "ADMINISTRADOR" ? (
                            <>

                                <Link to="/emissions"><li>factores de emision</li></Link>
                                <Link to="/transports"><li>Agregar Transporte</li></Link>
                                <Link to="/advices"><li>Recomendaciones</li></Link>
                                <Link to="/addcontacts"><li>AddConacts</li></Link>
                                <Link to="/request"><li>Gestionar Solicitudes</li></Link>
                                <Link to="/registerMeasurements"><li>Registrar Mediciones</li></Link>
                                <Link to="/registerSector"><li>Registrar Sectores</li></Link>
                                <Link to="/report"><li>Reportes</li></Link>
                                <Link to="/calculators"><li>Calculadora HC</li></Link>
                                {/* <Link to="/registrarTrayecto"><li>Registrar Trayecto</li></Link> */}

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

            </div>
        </div>
    );
};
