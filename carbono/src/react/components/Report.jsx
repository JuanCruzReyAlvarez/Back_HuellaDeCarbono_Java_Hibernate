import React from "react";
import axios from "axios";
import { useState } from "react";
import ".././styles/Report.css";
import { Link, useNavigate } from "react-router-dom";
import $ from 'jquery'

export const Report = () => {
    const navigate = useNavigate();

    const [report, setRegister] = useState({});




    function onSubmit(e) {
        e.preventDefault();
        axios.post("http://localhost:8080/report", JSON.stringify(report)).then((data) => {
            console.log("funciono", data)
            navigate("/login")
        }).catch(error => {
            console.log(error)
        })
    }





    function handleChangeNombre(e) {
        setRegister({ ...report, username: e.target.value });
    }


    function handleChangePassword(e) {
        setRegister({ ...report, password: e.target.value });
    }

    function handleChangeRol(e) {
        setRegister({ ...report, rol: e.target.value });
    }

    $(function () {
        $('#buttonSectorTerritorial').click(function () {
            $('#sectorTerritorial').toggle();
        });
    })

    $(document).ready(function () {
        $("#btn").click(function () {
            $("#Create").toggle();
        });
    });

    $(document).ready(function () {

        $("#espera").hide();
        $("#sectorTerritorial").hide();
        $("#provomuni").hide();
        $("#elmun").hide();
        $("#elsec").hide();

        $("#org").click(function () {
            $("#sectorTerritorial").hide();
            $("#provomuni").hide();
            $("#espera").show();
        });

        $("#sect").click(function () {
            $("#espera").hide();
            $("#sectorTerritorial").show();
            $("#provomuni").show();

        });

        $("#mun").click(function () {
            $("#elsec").hide();
            $("#elmun").show();
        });

        $("#prov").click(function () {
            $("#elmun").hide();
            $("#elsec").show();
        });

    });








    return (



        <div>
            {/* <link
                href="//db.onlinewebfonts.com/c/a4e256ed67403c6ad5d43937ed48a77b?family=Core+Sans+N+W01+35+Light"
                rel="stylesheet"
                type="text/css"
            />
            <link rel="stylesheet" href="form.css" type="text/css" /> */}

            <div class="body-content-hall"></div>

            <div class="module">

                {/* ------------Rol organizacion------------- */}
                <h1>PERSONALIZA TU REPORTE</h1>
                <h3>Indica sus Caracteristicas</h3>
                <form
                    class="form"
                    action="form.php"
                    method="post"
                    enctype="multipart/form-data"
                    autocomplete="off"
                    onSubmit={onSubmit}
                >
                    <div class="alert alert-error"></div>

                    <label for="start">Periodicidad:</label>
                    <select id="Periodicidad" name="Periodicidad">
                        <option>Anual</option>
                        <option>Mensual</option>
                    </select>

                    <label for="start">Fecha Inicio:</label>
                    <div class="clasefechita">
                        <input type="date" id="start" name="trip-start"
                            value="aaaa-mm-dd"
                            min="2022-01-01" max="2030-12-31"></input>
                    </div>
                    <label for="finish">Fecha Final:</label>
                    <div class="clasefechita">
                        <input type="date" id="start" name="trip-start"
                            value="aaaa-mm-dd"
                            min="2022-01-01" max="2030-12-31"></input>
                    </div>

                    <label for="typeReport">Tipo de Reporte:</label>
                    <select id="Tipo" name="Tipo">
                        <option>Evolucion Individual</option>
                        <option>Composicion Grupal</option>
                    </select>

                    <label for="sector">Sector:</label>

                    <div class="row">

                        <div class="app-button">
                            <button id="org" class="palabrita">Organizacion</button>
                        </div>
                        <div class="app-button">
                            <button id="sect" class="palabrita">Sector Territorial</button>
                        </div>
                    </div>

                    <div class="module">


                        <label for="sector" id="sectorTerritorial">Elija un tipo de Sector Territorial:</label>

                        <div class="row" id="provomuni">

                            <div class="app-button">
                                <button id="prov" class="palabrita">Provincial</button>
                            </div>

                            <div class="app-button">
                                <button id="mun" class="palabrita">Municipal</button>
                            </div>

                            <div id="elsec">
                                <label for="start">Elije una Provincia:</label>
                                <select id="Periodicidad" name="Periodicidad">
                                    <option>BLABLABA</option>
                                    <option>BLABLABA</option>
                                    <option>BLABLABA</option>
                                    <option>BLABLABA</option>
                                    <option>BLABLABA</option>
                                    <option>BLABLABA</option>
                                    <option>BLABLABA</option>
                                </select>
                            </div>

                            <div id="elmun">
                                <label for="start">Elije un Municipio:</label>
                                <select id="Periodicidad" name="Periodicidad">
                                    <option>BLABLABA</option>
                                    <option>BLABLABA</option>
                                    <option>BLABLABA</option>
                                    <option>BLABLABA</option>
                                    <option>BLABLABA</option>
                                    <option>BLABLABA</option>
                                    <option>BLABLABA</option>
                                </select>
                            </div>

                        </div>

                    </div>

                    <div id="espera">
                        <h1 >LO ESTAMOS CALCULANDO! </h1>
                    </div>

                </form>

            </div>
        </div>
   

    );
};
