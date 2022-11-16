import React from "react";

export const Transporte_Publico = ({ handleChange, selectVehiculo }) => {
    return (
        <div id="LineaYTipoDeTransporte">
            <h2>TIPO DE TRANSPORTE</h2>

            <select
                id="Tipo"
                name="tipo_transporte_publico"
                onChange={selectVehiculo}
            >
                <option value="">Seleccionar</option>
                <option value="COLECTIVO">COLECTIVO</option>
                <option value="TREN">TREN</option>
                <option value="SUBTE">SUBTE</option>
            </select>

            <h2>LINEA</h2>

            <input
                type="text"
                placeholder="Linea"
                name="linea_transporte_publico"
                onChange={handleChange}
                required
            />
        </div>
    );
};
