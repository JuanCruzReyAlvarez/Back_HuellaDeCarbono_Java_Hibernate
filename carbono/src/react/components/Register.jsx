import React from "react";
import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import ".././styles/Register.css";

export const Register = () => {
    const navigate = useNavigate();

    const [usuario, setRegister] = useState({});

    function onSubmit(e) {
      e.preventDefault();
      axios.post("http://localhost:8080/register",  JSON.stringify(usuario)).then(() => { console.log("funciono")}).catch((err)=>{
        console.log(err)
      })
    }

    function handleChangeNombre(e) {
        setRegister({ ...usuario, username: e.target.value });
    }

    function handleChangePassword(e) {
     setRegister({ ...usuario, password: e.target.value });
    }

    function handleChangeRol(e) {
       setRegister({ ...usuario, rol: e.target.value });
    }

    return (
        <div>
            {/* <link
                href="//db.onlinewebfonts.com/c/a4e256ed67403c6ad5d43937ed48a77b?family=Core+Sans+N+W01+35+Light"
                rel="stylesheet"
                type="text/css"
            />
            <link rel="stylesheet" href="form.css" type="text/css" /> */}

            <div class="body-content"></div>

            <div class="module">
                <h1>Crear una cuenta</h1>
                <form
                    class="form"
                    action="form.php"
                    method="post"
                    enctype="multipart/form-data"
                    autocomplete="off"
                    onSubmit={onSubmit}
                >
                    <div class="alert alert-error"></div>
                    <input
                        type="text"
                        placeholder="Usuario"
                        name="username"
                        onChange={handleChangeNombre}
                        required
                    />
                    <input
                        type="password"
                        placeholder="Constraseña"
                        name="password"
                        autocomplete="off"
                        onChange={handleChangePassword}
                    />

                    <input
                        type="text"
                        placeholder="Usuario"
                        name="rol"
                        onChange={handleChangeRol}
                        required
                    />
                    {/* <input
                        type="password"
                        placeholder="Confirmar Contraseña"
                        name="confirmpassword"
                        autocomplete="off"
                    /> */}

                    <h2>Elegir rol</h2>
                    {/* <select id="rol" name="rol">
                        <option>Administrador</option>
                        <option>Miembro</option>
                        <option>Organizacion</option>
                        <option>Agente Sectorial</option>
                    </select> */}

                    <input
                        type="submit"
                        value="Registrar"
                        name="register"
                        class="btn btn-block btn-primary"
                    />
                </form>
            </div>
        </div>
    );
};
