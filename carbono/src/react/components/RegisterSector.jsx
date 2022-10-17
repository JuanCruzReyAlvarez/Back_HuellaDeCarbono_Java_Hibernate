import React from 'react'
import ".././styles/RegisterSector.css";
import $ from 'jquery';
import { Link, useNavigate } from "react-router-dom";
import { useState } from "react";
import axios from "axios";

export const RegisterSector = () => {

    const [sector, setUser] = useState({});
    const navigate = useNavigate();

    /*
    document.querySelector('#SectorAg').addEventListener('click', newElement);

    function newElement() {
        var inputValue = document.getElementById("textBox").value;
        var theText = document.createTextNode(inputValue);
        var liEl = document.createElement('li');

        liEl.appendChild(theText);
        if (inputValue !== '') {
            document.getElementById('list').appendChild(liEl);
        }
    }
    */
   
    function onSubmit(e) {
        e.preventDefault();
        axios
            .post("http://localhost:8080//addsector", JSON.stringify(sector))
            .then(({data}) => {
                console.log("funciono login", data);
                window.localStorage.setItem(
                    "UserLoggedInfo",
                    JSON.stringify({
                        id: data.user.id,
                        username: data.user.username, 
                        rol: data.user.rol,
                        token: data.token
                    })
                );
                navigate("/");
            })
            .catch((error) => {
                console.log(error);
            });
    }
    



    return (
        <div class="Formu">
            <div className = "FormuPrinc">
                <form method="POST" onSubmit={onSubmit}>
                                        <h1 class="PrimTit">Agregar Organización</h1>
                                        <h3>Lorem ipsum dolor sit amet consectetur adipi.</h3>
                                        <div class="form_uno">
                                            <div class="uno">
                                                <div>
                                                    <label for="RazSoc">Razón social</label>
                                                </div>
                                                <div>
                                                    <input type="text" name="RazSoc" placeholder="Especificar razón social"/>
                                                </div>
                                            </div>
                                            <div class="dos">
                                                <div class="col-25">
                                                    <label for="TipOrg">Tipo de organización</label>
                                                </div>
                                                <div>
                                                    <select name="TipOrg">
                                                        <option value="ubernamental">GUBERNAMENTAL</option>
                                                        <option value="ong">ONG</option>
                                                        <option value="empresa">EMPRESA</option>
                                                        <option value="institucion">INSTITUCIÓN</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form_dos">
                                            <div class="tres">
                                                <div>
                                                    <h2>Punto Geográfico</h2>
                                                </div>
                                                <div class="tres_uno">
                                                    

                                                    <div class="tres_uno_uno">
                                                        <label for="cal">Calle</label>
                                                        <input type="text" name="cal" placeholder="Calle..." />
                                                    </div>
                                                    <div class="tres_uno_dos">
                                                        <label for="alt">Altura</label>
                                                        <input type="text" name="alt" placeholder="Altura..." />
                                                    </div>
                                                    <div class="tres_uno_tres">
                                                        <label for="loc">Localidad</label>
                                                        <input type="text" name="loc" placeholder="Localidad..." />
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                                    <div class="cuatro">
                                                            <div class="sector">
                                                                <h1>Sectores</h1>
                                                                <input type="text" name="sect" placeholder="Agregar sector..." id="textBox" />
                                                                <input type="button" value="Agregar" id="SectorAg"/>
                                                            </div>
                                                                <section id="main">
                                                                <h2>Sectores:</h2>
                                                                <ul id="list">
                                                                </ul>
                                                                </section>
                                                    </div>
                                                    <div class="cinco">
                                                        <input type="submit" value="Agregar organización" />
                                                    </div>
            </form >
            
        </div>    
    </div >
  )
}