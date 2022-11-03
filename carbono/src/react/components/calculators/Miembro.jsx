import React from "react";
import { useEffect, useState } from "react";
import axios from "axios";
import "../.././styles/calculators.css";
import $ from "jquery";
import { Resultado } from "./Resultado.jsx";

export const Miembro = () => {
    const [usuario, setUser] = useState({});
    const [organizaciones, setOrganizaciones] = useState([]);
    const [miembros, setMiembros] = useState({});
    const [calculo, setCalculo] = useState({});
    const [valor, setValor] = useState({});

    useEffect(() => {
        const isUserLogg = window.localStorage.getItem("UserLoggedInfo");
        if (isUserLogg) {
            let user = JSON.parse(isUserLogg);
            console.log("User log", user);
            setUser(user);
            axios
                .get(
                    "http://localhost:8080/organizacion",
                    JSON.stringify(usuario)
                )
                .then(({ data }) => {
                    console.log("Organizacion traida correctamente:", data);
                    //Mandenme las organizacion como "name"
                    setOrganizaciones({ name: "ferrari", id: "19" });
                    //TENGO QUE PEDIR EL MIEMBRO (no se la ruta pero dejo esto para "setear el estado mientras (HARDCODEADO)")
                    axios
                        .get(
                            "http://localhost:8080/miembro",
                            JSON.stringify(usuario)
                        )
                        .then(({ dataMiembro }) => {
                            console.log("Miembro traido correctamente:", data);
                            //Mandenme el miembro como "name"
                            setMiembros(dataMiembro);
                            setCalculo({
                                ...calculo,
                                rol: user.rol,
                                userId: user.id,
                                idOrganizacion: data.id,
                                iDmiembro: dataMiembro.id,
                            });
                        })
                        .catch((error) => {
                            //ESTE SETCALCULO BORRAR DESPUES.
                            setMiembros({ name: "juanjuaun" });
                            setCalculo({
                                ...calculo,
                                rol: user.rol,
                                userId: user.id,
                                idOrganizacion: "14",
                                iDmiembro: "13",
                            });
                            //
                            console.log("Error al traer al miembro", error);
                        });
                })
                .catch((error) => {
                    //ESTOS SETS BORRAR DESPUES.
                    setOrganizaciones({ name: "ferrari" });
                    setCalculo({
                        ...calculo,
                        rol: user.rol,
                        userId: user.id,
                        idOrganizacion: "14",
                    });
                    console.log("Error al traer a la organizacion", error);
                });
        }
    }, []);

    $(document).ready(function() {
        $("#cartelito").hide();
        $("#botonsito").click(function() {
            $("#formularito").hide();
            $("#botonsito").hide();
            $("#cartelito").show();
        });

        $("#crucecita").click(function() {
            $("#cartelito").hide();
            $("#formularito").show();
            $("#botonsito").show();
        });
    });

    const selectFecha = (e) => {
        if (e.target.value === "") return;
        console.log("fecha seleccionada:", e.target.value);
        setCalculo({ ...calculo, fecha: e.target.value });
    };

    const selectForma = (e) => {
        if (e.target.value === "") return;
        console.log("Forma seleccionada: ", e.target.value);
        setCalculo({ ...calculo, forma: e.target.value });
    };

    const onSubmit = (e) => {
        console.log("CALCULO A MANDAR:", calculo);
        axios
            .post("http://localhost:8080/calculators", JSON.stringify(calculo))
            .then(({ data }) => {
                console.log(
                    "Calculo realizado correctamente, valor obtenido:",
                    data
                );
                //Chequear como me mandan el numero y la unidad desde el back.(ACA ESTA Hardcodeado el valor)
                setValor({
                    numero: "123",
                    unidad: "kgms",
                });
            })
            .catch((error) => {
                console.log("Error al tratar de hacer el calculo", error);
            });
    };

    return (
        <div className="main-container">
            {valor.numero && valor.unidad ? (
                <>
                    <Resultado valor={valor} setValor={setValor} />
                </>
            ) : (
                <>
                    {/* CALCULADOR DE ORGANIZACION, ROL ORG */}
                    <h1>impacto de la huella de carbono</h1>
                    <div className="calculator-container">
                        <div className="calculator-title-containter">
                            <h2>Calculo sobre un miembro</h2>

                            <div id="botonsito" onClick={onSubmit}>
                                <p class="pop-up-button">Calcular</p>
                            </div>
                        </div>
                    </div>
                    <div id="formularito">
                        <form
                            class="formulario"
                            action="index.html"
                            method="post"
                        >
                            <div id="calculitoOrgItems1">
                                <div class="grid-item">
                                    <label for="">Organizacion</label>
                                    <input
                                        type="text"
                                        name=""
                                        value={organizaciones.name}
                                        class="text-input"
                                    />
                                </div>

                                <div class="grid-item">
                                    <label for="">Miembro</label>
                                    <input
                                        type="text"
                                        name=""
                                        value={miembros.name}
                                        class="text-input"
                                    />
                                </div>
                            </div>
                            <div id="calculitoItems2">
                                <div class="grid-item">
                                    <label for="">Inicio del periodo</label>
                                    <input
                                        type="date"
                                        placeholder="formato : DD/MM/AAAA"
                                        name=""
                                        class="text-input"
                                        onChange={selectFecha}
                                    />
                                </div>

                                <div class="grid-item">
                                    <label for="">Forma de calculo</label>
                                    <select
                                        className="text-input"
                                        onChange={selectForma}
                                    >
                                        <option value="">Seleccionar</option>
                                        <option value="MENSUAL">Mensual</option>
                                        <option value="ANUAL">Anual</option>
                                    </select>
                                </div>
                            </div>
                        </form>
                    </div>
                </>
            )}
        </div>
    );
};
