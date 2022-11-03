import React from "react";
import { useEffect, useState } from "react";
import axios from "axios";
import "../.././styles/calculators.css";
import $ from 'jquery'

export const Sector_Territorial = () => {
  const [usuario, setUser] = useState({});
    const [organizaciones, setOrganizaciones] = useState([]);
    const [miembros, setMiembros] = useState([]);
    const [sector, setSectores] = useState([]);
    const [calculo, setCalculo] = useState({});

    useEffect(() => {
        const isUserLogg = window.localStorage.getItem("UserLoggedInfo");
        if (isUserLogg) {
            setUser(JSON.parse(isUserLogg));
            axios
                .get(
                    "http://localhost:8080/organizacion",
                    JSON.stringify(usuario)
                )
                .then(({ data }) => {
                    console.log("Organizaciones traidas correctamente:", data);
                    setOrganizaciones(data);
                })
                .catch((error) => {
                    console.log(error);
                });
        }
    }, []);

    $(document).ready(function () {
        $("#cartelito").hide();
        $("#botonsito").click(function () {
          $("#formularito").hide()
          $("#botonsito").hide()
          $("#cartelito").show();
        });
    
        $("#crucecita").click(function () {
          $("#cartelito").hide();
          $("#formularito").show()
          $("#botonsito").show()
        });
       
    });
    
    return (
        <div className="main-container">
            {" "}
            {/* CALCULADOR DE ORGANIZACION, ROL ORG */}
            <h1>impacto de la huella de carbono</h1>
            <div className="calculator-container">
                <div className="calculator-title-containter">
                    <h2>Calculo segun sector territorial</h2>

                    <div id="botonsito">
                        <p class="pop-up-button">Calcular</p>
                    </div>
                </div>
            </div>
            <div id="formularito">
                <form class="formulario" action="index.html" method="post">
                    <div id="calculitoOrgItems1">
                        <div class="grid-item">
                            <label for="">Organizacion</label>
                            <input
                                type="text"
                                name=""
                                value="ferrari"
                                class="text-input"
                            />
                        </div>
                    </div>
                    <div id="calculitoItems2">
                        <div class="grid-item">
                            <label for="">Inicio del periodo</label>
                            <input
                                type="text"
                                placeholder="formato : DD/MM/AAAA"
                                name=""
                                value=""
                                class="text-input"
                            />
                        </div>

                        <div class="grid-item">
                            <label for="">Forma de calculo</label>
                            <select className="text-input">
                                <option value="MENSUAL">Mensual</option>
                                <option value="ANUAL">Anual</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="pop-up" id="cartelito">
                <div id="crucecita">
                    <span>x</span>
                </div>
                <div class="pop-up-text">
                    <h1>RESULTADO = 123 kgms</h1>
                    <p>[GRAFICOS]</p>
                </div>
            </div>
        </div>
    );
}
