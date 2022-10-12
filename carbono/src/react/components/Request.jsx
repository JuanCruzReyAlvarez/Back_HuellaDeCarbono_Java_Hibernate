import React from "react";
import ".././styles/Request.css";
import _ from 'lodash';
import { Link, useNavigate } from "react-router-dom";
import { useState } from "react";
import axios from "axios";


export const Request = () => {
    const [usuario, setUser] = useState({});
    const navigate = useNavigate();

    function onSubmit(e) {
        e.preventDefault();
        axios.post("http://localhost:8080/request", )
     }

    return (
        
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
                        <div class="plan-select"><a href="">Rechazar Solicitud</a></div>

                        <div class="plan-select"><a href="">Aceptar Solicitud</a></div>
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
        
    );
};