import React from 'react'
import { useEffect, useState } from "react";
import { Route, Routes, Link } from "react-router-dom"; // {libreia,libreria}
import ".././styles/Emissions.css";
import axios from "axios";

export const Emissions = () => {

    const [usuario, setUser] = useState({});
    const [form, setForm] = useState({});

    useEffect(() => {
        const isUserLogg = window.localStorage.getItem("UserLoggedInfo");
        if (isUserLogg) {
            setUser(JSON.parse(isUserLogg));
        }
    }, []);

    const handleChange = ({ target }) => {
        setForm((form) => {
            return {
                ...form,
                [target.name]: target.value,
            };
        });
    };


//JSON mandado asi:
/* {
"tipo_de_consumo" : "",
"tipo_de_actividad":"",
"valor":"",
"unidad":"",
} */

    const onSubmit = () => {
        axios.post("http://localhost:8080/emissions", JSON.stringify( form )).then(({ data }) => {
            console.log("Form mandado correctamente ", data)
        }).catch(error => {
            console.log("Error al cargar el form", error)
        })


    }


    return (
        <>

            <div class="Emission">
                <table class="table data">
                    <thead>
                        <tr>
                            <th> Tipo de consumo </th>
                            <th> Tipo de actividad </th>
                            <th> Valor </th>
                            <th> Unidad </th>
                            <th> EDITAR </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="data"><input type="text" name="tipo_de_consumo" onChange={handleChange} /></td>
                            <td class="data"><input type="text" name="tipo_de_actividad" onChange={handleChange} /></td>
                            <td class="data"><input type="text" name="valor" onChange={handleChange} /></td>
                            <td class="data"><input type="text" name="unidad" onChange={handleChange} /></td>
                            <td>
                                <button class="edit"> Editar </button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="add">
                <div class="addRow">
                    <button class="custom-btn btn-1" onClick={onSubmit}>Agregar fila</button>
                </div>
            </div>
        </>
    )
}
