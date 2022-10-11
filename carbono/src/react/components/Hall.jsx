import React from "react";
import ".././styles/Hall.css";
import { Link, useNavigate } from "react-router-dom";
import { useState } from "react";
import axios from "axios";


export const Hall = () => {
    const [usuario, setUser] = useState({});
    const navigate = useNavigate();



    function onSubmit(e) {
        e.preventDefault();
        axios.post("http://localhost:8080/hall")
    
    }

    

    function handleChangeNombre(e) {
        setUser({ ...usuario, username: e.target.value });
    }

    function handleChangePassword(e) {
        setUser({ ...usuario, password: e.target.value });
    }


    return (
        <body>
            <div class="body"></div>
            <form method="POST" action="login" onSubmit={onSubmit}>
                <div class="grad"></div>
                <div class="header">
                    <div>
                        Calculador
                        <span>
                            <strong> Huella Ecologica</strong>
                        </span>
                    </div>
                </div>
                <br />
                <div class="login">
                    <input
                        id="username"
                        type="text"
                        placeholder="Username"
                        name="username"
                        autocomplete="off"
                        onChange={handleChangeNombre}
                    />
                    <input
                        id="password"
                        type="password"
                        placeholder="Password"
                        name="password"
                        autocomplete="off"
                        onChange={handleChangePassword}
                    />
                    <input type="submit" value="Login" />
                    <br />
                    <p class="hrefRegister">Si no estas registrado.</p>
                    <Link to="/register">
                        <strong> Registrate! </strong>
                    </Link>
                </div>
            </form>
        </body>
    );
};
