import React from "react";
import ".././styles/Request.css";
import _ from 'lodash';
import { Link, useNavigate } from "react-router-dom";
import { useState } from "react";
import { useEffect } from "react";
import axios from "axios";


export const Request = () => {
    const [usuario, setUser] = useState({});
    const [request, setRequest] = useState([]);
    const [estadoDeSolicitudActual, setSolicitudActual] = useState("")
    const navigate = useNavigate();

    useEffect(() => {
        const isUserLogg = window.localStorage.getItem("UserLoggedInfo");
        if (isUserLogg) {
            setUser(JSON.parse(isUserLogg));
            axios.get("http://localhost:8080/request", JSON.stringify(usuario)).then(({ data }) => {
                console.log("Solicitudes traidas correctamente:", data)
                setRequest(data);
            }).catch(error => {
                console.log("Error al traer las solicitudes:", error)
            })
        }
    }, [estadoDeSolicitudActual]);



/*
id solicitud
nombre chabon
appelido chabon
id chabon (id_miembro)---------------
nombre sector 
id_sector-------------
*/
// id usuario logeado----------

const aceptarSolicitud = () => {
       
    axios.post("http://localhost:8080/request", JSON.stringify({
        estado : "ACEPTADO"
    })).then((data) => {
        console.log("Se acepto la solicitud correctamente", data)
    }).catch(error => {
    console.log(error)
    })
}


const rechazarSolicitud = () => {
    
    axios.post("http://localhost:8080/request", JSON.stringify({
        estado : "RECHAZADO"
    })).then((data) => {
        console.log("Se rechazo la solicitud correctamente", data)
    }).catch(error => {
    console.log(error)
    })
}
    return (/*

        <div className="body-contentreq">
            <div className="titlesitos">
                <h1 class='elegantshadow'>No son los individuos</h1>
                <h1 class='insetshadow'> los que hacen las empresas exitosas, </h1>
                <h1 class='elegantshadow'>sino  </h1>
                <h1 class='insetshadow'>los grandes equipos</h1>
                <h1 class='monserrat'>SOLICITUDES</h1>
            </div>

            <h2 class="titReq">Elegir Organizacion</h2>

            <div class="snip1265">

                {
                    request.length ? (
                        request.map((solicitud) => {
                            return (
                                
                                <div className="plan">
                                    <header><i className="ion-ios-people"></i>
                                        <h4 className="plan-title">{solicitud.nombre} {solicitud.apellido}</h4>
                                        <div className="plan-cost"><span className="plan-price">Developer </span><span className="plan-type"> - utn</span></div>
                                    </header>
                                    <ul className="plan-features">
                                        <li>{solicitud.sector}</li>
                                    </ul>
                                    <div className="plan-select-main">
                                        <div className="plan-select"><a onClick={() => {
                                            setSolicitudActual({
                                                tipo: "Rechazada",
                                                id: solicitud.id_miembro,
                                            })
                                            axios.post("http://localhost:8080/modrequest", JSON.stringify({
                                                estado: "RECHAZADO",
                                                id_Sector: solicitud.id_sector,
                                                id_Miembro: solicitud.id_miembro,
                                                //id del user log
                                                id_usuario: usuario.id
                                            })).then((data) => {
                                                console.log("Se rechazo la solicitud correctamente", data)
                                            }).catch(error => {
                                                console.log(error)
                                            })
                                        }} href="">Rechazar Solicitud</a></div>

                                        <div className="plan-select"><a onClick={() => {
                                              setSolicitudActual({
                                                tipo: "Aceptada",
                                                id: solicitud.id_miembro,
                                            })
                                            axios.post("http://localhost:8080/modrequest", JSON.stringify({
                                                estado: "ACEPTADO",
                                                id_Sector: solicitud.id_sector,
                                                id_Miembro: solicitud.id_miembro,
                                                //id del user log
                                                id_usuario: usuario.id
                                            })).then((data) => {
                                                console.log("Se acepto la solicitud correctamente", data)
                                            }).catch(error => {
                                                console.log(error)
                                            })
                                        }} href="">Aceptar Solicitud</a></div>
                                    </div>
                                </div>
                            )
                        })
                    ) : console.log("Todavia no hay solicitudes")
                }

            </div>
        </div>

        */

<div className = "body-contentreq">
                <div className ="titlesitos">
                <h1 class='elegantshadow'>No son los individuos</h1>
                <h1 class='insetshadow'> los que hacen las empresas exitosas, </h1>
                <h1 class='elegantshadow'>sino  </h1>
                <h1 class='insetshadow'>los grandes equipos</h1>  
                <h1 class = 'monserrat'>SOLICITUDES</h1>
                </div>      
                <div class="snip1265">
                    <div class="plan">
                        <header><i class="ion-ios-people"></i>
                        <h4 class="plan-title">Stephy</h4>
                        <div class="plan-cost"><span class="plan-price">Developer </span><span class="plan-type"> - utn</span></div>
                        </header>
                        <ul class="plan-features">
                        <li>Desarrollador Web</li>
                        <li>MySQL Databases</li>
                        <li>BLABLA</li>
                        <li>BLABLA</li>
                        <li>BLABLA</li>
                        <li>BLABLA</li>
                        </ul>
                        <div className="plan-select-main">
                        <div class="plan-select"><a  onClick={rechazarSolicitud} href="">Rechazar Solicitud</a></div>

                        <div class="plan-select"><a  onClick={aceptarSolicitud} href="">Aceptar Solicitud</a></div>
                        </div>
                    </div>
                    <div class="plan">
                        <header><i class="ion-ios-people"></i>
                        <h4 class="plan-title">Juan Cruz Rey</h4>
                        <div class="plan-cost"><span class="plan-price">Engeener</span><span class="plan-type"> - utn</span></div>
                        </header>
                        <ul class="plan-features">
                        <li>Desarrollador Web</li>
                        <li>MySQL Databases</li>
                        <li>BLABLA</li>
                        <li>BLABLA</li>
                        <li>BLABLA</li>
                        <li>BLABLA</li>
                        </ul>
                        <div className="plan-select-main">
                        <div class="plan-select"><a href="">Rechazar Solicitud</a></div>

                        <div class="plan-select"><a href="">Aceptar Solicitud</a></div>
                        </div>
                    </div>
                    <div class="plan">
                        <header><i class="ion-ios-people"></i>
                        <h4 class="plan-title">
                            Professional
                        </h4>
                        <div class="plan-cost"><span class="plan-price">Diego Titano</span><span class="plan-type"> -UADE</span></div>
                        </header>
                        <ul class="plan-features">
                        <li>Desarrollador Web</li>
                        <li>MySQL Databases</li>
                        <li>BLABLA</li>
                        <li>BLABLA</li>
                        <li>BLABLA</li>
                        <li>BLABLA</li>
                        </ul>
                        <div className="plan-select-main">
                        <div class="plan-select"><a href="">Rechazar Solicitud</a></div>

                        <div class="plan-select"><a href="">Aceptar Solicitud</a></div>
                        </div>
                    </div>
                    <div class="plan">
                        <header><i class="ion-ios-people"></i>
                        <h4 class="plan-title">Camila vallejos</h4>
                        <div class="plan-cost"><span class="plan-price">RRHH</span><span class="plan-type">-UADE</span></div>
                        </header>
                        <ul class="plan-features">
                        <li>Desarrollador Web</li>
                        <li>MySQL Databases</li>
                        <li>BLABLA</li>
                        <li>BLABLA</li>
                        <li>BLABLA</li>
                        <li>BLABLA</li>
                        </ul>
                        <div className="plan-select-main">
                        <div class="plan-select"><a href="">Rechazar Solicitud</a></div>

                        <div class="plan-select"><a href="">Aceptar Solicitud</a></div>     
                        </div>
                    </div>
                </div>
            </div>

        

    )
};