import React from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import ".././styles/Hall.css";

export const Hall = () => {

    //HAY QUE PEGARLE A LA API

    const navigate = useNavigate();

    // DECLARACION DE ESTADOS

    const [usuario, setUser] = useState({});

    const [miembro, setMiembro] = useState({});

    const [organizacion, setOrganizacion] = useState({});

    const [agenteSectorial, setAgenteSectorial] = useState({});


    // ACCESO A STORAGE

    useEffect(() => {
        const isUserLogg = window.localStorage.getItem("UserLoggedInfo");
        if (isUserLogg) {
            setUser(JSON.parse(isUserLogg));
        }
    }, []);




    // TRAEMOS DESDE LA BASE 

    function dataOrg(e) {
        e.preventDefault();
        axios.get("http://localhost:8080/organizaciones").then((data) => {
            console.log("funciono", data)
        }).catch(error => {
            console.log(error)
        })
    }


    function dataOrg(e) {
        e.preventDefault();
        axios.get("http://localhost:8080/sectores", JSON.stringify(organizacion)).then((data) => {
            console.log("funciono", data)
        }).catch(error => {
            console.log(error)
        })
    }



    // FUNCIONES js ENVIO FORMS HALL    -> Le devuelvo objeto con mensajito que slaio todo bien.


    function onSubmitMiembro(e) {
        e.preventDefault();
        axios.post("http://localhost:8080/hall", JSON.stringify(miembro)).then((data) => {
            console.log("funciono", data)
            navigate("/home")
        }).catch(error => {
            console.log(error)
        })
    }
    function onSubmitOrganizacion(e) {
        e.preventDefault();
        axios.post("http://localhost:8080/hall", JSON.stringify(organizacion)).then((data) => {
            console.log("funciono", data)
            navigate("/home")
        }).catch(error => {
            console.log(error)
        })
    }
    function onSubmitAgenteSectorial(e) {
        e.preventDefault();
        axios.post("http://localhost:8080/hall", JSON.stringify(agenteSectorial)).then((data) => {
            console.log("funciono", data)
            navigate("/home")
        }).catch(error => {
            console.log(error)
        })
    }


    /*
        function handleChangeNombre(e) {
            setRegister({ ...usuario, username: e.target.value });
        }
    
    
        function handleChangePassword(e) {
            setRegister({ ...usuario, password: e.target.value });
        }
    
        function handleChangeRol(e) {
            setRegister({ ...usuario, rol: e.target.value });
        }
    */
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
                {usuario ? (
                    usuario.token && usuario.rol === "ORGANIZACION" ? (
                        <>
                            <h1>Registra tus datos</h1>
                            <h3>Paso 2</h3>
                            <form
                                class="form"
                                action="form.php"
                                method="post"
                                enctype="multipart/form-data"
                                autocomplete="off"
                                onSubmit={onSubmitOrganizacion}
                            >
                                <div class="alert alert-error"></div>
                                <input
                                    type="text"
                                    placeholder="Razon social"
                                    name="Razon social"


                                />
                                <input
                                    type="text"
                                    placeholder="Clasificacion"
                                    name="Clasificacion"
                                    autocomplete="off"

                                />
                                <h2>Indique su domicilio</h2>

                                <input
                                    type="text"
                                    placeholder="calle"
                                    name="calle"

                                />
                                <input
                                    type="text"
                                    placeholder="altura"
                                    name="altura"

                                />
                                {/* --------UBI SON DESPLEGABLES: localidad,muni,prov PAIS NO -------- */}

                                <input
                                    type="text"
                                    placeholder="localidad"
                                    name="localidad"

                                />
                                <input
                                    type="text"
                                    placeholder="municipio"
                                    name="municipio"

                                />
                                <input
                                    type="text"
                                    placeholder="provincia"
                                    name="provincia"

                                />
                                <input
                                    type="text"
                                    placeholder="pais"
                                    name="pais"

                                />

                                <h2>Elegir Tipo</h2>
                                {<select id="Tipo" name="Tipo">

                                    <option>Gubernamental</option>
                                    <option>ONG</option>
                                    <option>Empresa</option>
                                    <option>Institucion</option>
                                </select>}

                                <input
                                    type="submit"
                                    value="Siguiente"
                                    name="Siguiente"
                                    class="btn btn-block btn-primary"
                                />
                            </form>
                        </>
                    ) : (
                        <></>
                    )
                ) : (
                    <></>
                )}


                {/* ------------Rol Miembro------------- */}
                {usuario ? (
                    usuario.token && usuario.rol === "MIEMBRO" ? (
                        <>
                            <h1>Registra tus datos</h1>
                            <form
                                class="form"
                                action="form.php"
                                method="post"
                                enctype="multipart/form-data"
                                autocomplete="off"
                                onSubmit={onSubmitMiembro}
                            >

                                <input
                                    type="text"
                                    placeholder="Nombre"
                                    name="Nombre"

                                />

                                <input
                                    type="text"
                                    placeholder="Apellido"
                                    name="Apellido"

                                />
                                <input
                                    type="text"
                                    placeholder="DESPLEGABLE CON ORGANIZACIONES "
                                    name="Lista organizaciones"


                                />
                                <input
                                    type="text"
                                    placeholder="DESPLEGABLE CON SECTORES "
                                    name="Lista sectores"


                                />


                                <h2>Elegir Tipo de Documento</h2>
                                {<select id="Tipo" name="Tipo">

                                    <option>DNI</option>
                                    <option>Pasaporte</option>
                                    <option>Libreta</option>

                                </select>}
                                <input
                                    type="text"
                                    placeholder="Nro documento"
                                    name="Nro documento"

                                />

                                <label className="salvadora"><input type="checkbox" id="cbox1" value="first_checkbox" />
                                    Enviar mi solicitud de vinculacion a mi organizacion automaticamente</label><br />



                                <input
                                    type="submit"
                                    value="Registrar"
                                    name="Siguiente"
                                    class="btn btn-block btn-primary" />

                            </form>
                        </>
                    ) : (
                        <></>
                    )
                ) : (
                    <></>
                )}

                {/* ------------Rol Agente sectorial------------- */}
                {usuario ? (
                    usuario.token && usuario.rol === "AGENTESECTORIAL" ? (
                        <>
                            <h1>Registra tus datos</h1>

                        <form
                                class="form"
                                action="form.php"
                                method="post"
                                enctype="multipart/form-data"
                                autocomplete="off"
                                onSubmit={onSubmitAgenteSectorial}
                        >


                            <h2>Elegir Tipo de Sector a cargo</h2>
                           

                                {
                                    <select id="Tipo" name="Tipo">
                                        <option>Provincia</option>
                                        <option>Municipio</option>
                                    </select>
                                }

                                <input
                                    type="text"
                                    placeholder="DESPLEGABLE CON MUNICIPIOS/PRIVINCIAS "
                                    name="Lista organizaciones"

                                />
                                <input
                                    type="submit"
                                    value="Registrar"
                                    name="Siguiente"
                                    class="btn btn-block btn-primary" />

                        </form>
                            </>

                            ) : (
                            <></>
                            )
                            ) : (
                            <></>
                )}


                        </div>
        </div>
            );
};