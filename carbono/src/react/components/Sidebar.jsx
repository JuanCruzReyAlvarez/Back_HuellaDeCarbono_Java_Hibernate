import React from "react";
import { useEffect, useState } from "react";
import ".././styles/Sidebar.css";
import { Advices } from "./Advices.jsx";
import { Request } from "./Request.jsx";

import { Home } from "./Home.jsx";
import { Register } from "./Register";
import { Hall } from "./Hall";
import { Contacts } from "./AddContacts";
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
            <input type="checkbox" class="openSidebarMenu" id="openSidebarMenu"></input>
            <label for="openSidebarMenu" class="sidebarIconToggle">
                <div class="spinner diagonal part-1"></div>
                <div class="spinner horizontal"></div>
                <div class="spinner diagonal part-2"></div>
            </label>
            <div id="sidebarMenu">
                <ul class="sidebarMenuInner">
                    <li>Pagina Principal <span>[nombre de nuestra pagina?]</span></li>

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
                <Contacts />
            </div>
        </div>
    );
};
