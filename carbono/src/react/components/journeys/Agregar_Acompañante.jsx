import React from "react";
import { useEffect, useState } from "react";

export const Agregar_Acompañante = ({
    setAcompañante,
    selectDocumento,
    setAcompañantesTotales,
}) => {
    const [acompañanteNumber, setAcompañanteNumber] = useState();
    const [contadorAcompañante, setContadorAcompañante] = useState();
    const [cantidadTramos, setCantidadTramos] = useState();

    const [eleccionAcompañante, setEleccionAcompañante] = useState({});
    const [listaAcompañantes, setListaAcompañantes] = useState([]);

    const handleChange = ({ target }) => {
        // console.log(target.value);
        // console.log(target.name);
        setEleccionAcompañante((eleccion) => {
            return {
                ...eleccion,
                [target.name]: target.value,
            };
        });
    };

    const setNewEleccion = (e) => {
        e.preventDefault();
        setListaAcompañantes([...listaAcompañantes, eleccionAcompañante]);
        setEleccionAcompañante({});
        setContadorAcompañante(contadorAcompañante - 1);

        //Limpiar TODOS los inputs aca despues
    };

    const onSubmitFinal = (e) => {
        e.preventDefault();
        if (cantidadTramos !== 1) {
            listaAcompañantes.push(eleccionAcompañante);
        }
        console.log("ACOMPAÑANTES a mandar:", listaAcompañantes);
        setAcompañantesTotales(listaAcompañantes)
    };

    // const sumandoAcompañantes = (e) => {
    //     e.preventDefault();
    //     setAcompañanteAhora(acompañantesAhora + 1);
    // };

    const cantidadEleccionActual = (e) => {
        e.preventDefault();
        setAcompañanteNumber(e.target.value);
    };

    const selectCantidad = (e) => {
        e.preventDefault();
        setCantidadTramos(acompañanteNumber);
        setContadorAcompañante(acompañanteNumber);
    };

    return (
        <div>
            {!cantidadTramos ? (
                <>
                    <h1>¿Cuantos Acompañantes Tenes?</h1>
                    <input
                        type="number"
                        placeholder="Cantidad de Acompañantes"
                        name="cantidadDeAcompañantes"
                        onChange={cantidadEleccionActual}
                        required
                    />
                    <div id="CancelarAgregarAcompañante">
                        <input
                            type="button"
                            value="Guardar"
                            name="ACOMPAÑANTES"
                            class="btn btn-primaryacomp"
                            onClick={selectCantidad}
                        />
                        <br />
                        <br />
                    </div>
                </>
            ) : (
                <>
                    {console.log("ACOMPAÑANTES ", acompañanteNumber)}
                    <div id="AgregarMiembroAcompañante">
                        <h1>ACOMPAÑASTE TOTALES: {acompañanteNumber}</h1>
                        <input
                            type="text"
                            placeholder="Nombre"
                            name="nombre_Acompañante"
                            onChange={handleChange}
                            required
                        />
                        <input
                            type="text"
                            placeholder="Apellido"
                            name="apellido_Acompañante"
                            onChange={handleChange}
                            required
                        />
                        <select
                            id="TipoDocumento"
                            name="TipoDocumentoAcompañante"
                            onChange={selectDocumento}
                        >
                            <option value="">
                                Seleccionar Tipo de Documento
                            </option>
                            <option value="DNI">DNI</option>
                            <option value="PASAPORTE">PASAPORTE</option>
                            <option value="LIBRETA">LIBRETA</option>
                        </select>
                        <input
                            type="text"
                            placeholder="Numero"
                            name="numero_Acompañante"
                            onChange={handleChange}
                            AgregarMiembroAcompañante
                        />

                        {contadorAcompañante > 1 ? (
                            <>
                                <div id="CancelarAgregarAcompañante">
                                    <input
                                        type="button"
                                        value="Siguiente"
                                        name="CancelarAgregacionAcompañante"
                                        class="btn btn-primaryacomp"
                                        onClick={setNewEleccion}
                                    />
                                </div>
                            </>
                        ) : (
                            <>
                                <div id="CancelarAgregarAcompañante">
                                    <input
                                        type="button"
                                        value="Guardar"
                                        name="acompañante"
                                        class="btn btn-primaryacomp"
                                        onClick={onSubmitFinal}
                                    />
                                    <br />
                                    <br />
                                </div>
                            </>
                        )}
                    </div>
                </>
            )}
        </div>
    );
};
