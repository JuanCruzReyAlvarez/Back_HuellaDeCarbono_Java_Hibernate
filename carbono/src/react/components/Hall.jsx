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
    const [eleccion, setEleccion] = useState({});
    const [organizaciones, setOrganizaciones] = useState([]);
    const [provincias, setProvincias] = useState([]);
    const [municipios, setMunicipios] = useState([]);
    const [localidades, setLocalidades] = useState([]);
    const [sectores, setSectores] = useState([]);


    // {
    // id: 1,
    // nombre: ""

    // }



    let organizacionElegida;
    let provinciaElegida;
    let municipioElegido;



    // ACCESO A STORAGE

    useEffect(() => {
        const isUserLogg = window.localStorage.getItem("UserLoggedInfo");
        if (isUserLogg) {
            let user = JSON.parse(isUserLogg)
            setUser(user);
            setEleccion({
                rol: user.rol,
                userId: user.id
            })
            axios.get("http://localhost:8080/provinciasss", JSON.stringify(usuario)).then(({ data }) => {
                console.log("funcionaron las provincias ", data)
                data.unshift({ id: "", name: "Seleccionar" })
                setProvincias(data);
            }).catch(error => {
                console.log(error)
            })

            // deberia hacer un switch o algo creo 
            axios.get("http://localhost:8080/organizacion").then(([data]) => {
                console.log("funciono el get a organizaciones", data)
                setOrganizaciones(data)
            }).catch(error => {
                console.log(error)
            })
            
            
        }
    }, []);

    //EL JSON QUE TE VA A MANDAR ES ASI:

    /*
    {   "rol":"",
        "razon_social":"",
        "clasificacion":"",
        "calle":"",
        "altura":"",
        "provinciaID":"",
        "municipioID":"",
        "localidadId":"",
        "tipo":"",
    } 
    
    */

    // console.log("USUARIO", usuario)
    const onSubmit = (e) => {
        e.preventDefault();
        axios.post("http://localhost:8080/hall", JSON.stringify(eleccion)).then((data) => { //mando este usuario creado a ese esa url mediando un post obviamente (a mi back), lo mando en tipo json, (por eso json.usuario), (acordarce que este usuario es lo que comenzo como un estado local vacio y se fue haciendo en los inputs y las funciones), y acordarce juan que con el .then estoy haciendo una promesa, es decir hay algo que me va a devolver mi back luego de que yo le mande el usuario y lo tengo que atajar. Si sale todo bien me cae en el then.Esto quiere decir que va a estar en mi data lo que me haya mandado mi back. Acordarce que data es una palabra reservada que puse yo y que va a lamacenar cualquier cosa que yo le mand edel back.
            //. Si hay problema me va al catch.ya sea problemas de comunicacion de servidor del cliente o nuestro. O tambien puede pasar que no cumpla logica necesaria como que la contraseña no sea correcta, enotnces esto se mando el usuario en json JSON.stringify(usuario)) , ahi se ejecuta un wait() hasta que el back procesa y manda un signal() para que se termine de ejecutar la promesa en el then(), si todo bien too ok, sino cumplio logica como deciamos mi back catghea ese error y le dispara el error a este servidor.
            console.log("funciono el hall", data)
            navigate("/advices")
        }).catch(error => {
            console.log("No funciono el Hall", error)
        })
    }

    // TRAEMOS DESDE LA BASE 



    /*
        function dataOrg(e) {
            e.preventDefault();
            axios.get("http://localhost:8080/sectores", JSON.stringify(organizacion)).then((data) => {
                console.log("funciono", data)
            }).catch(error => {
                console.log(error)
            })
        }
    
        
        }*/

    // FUNCIONES js ENVIO FORMS HALL    -> Le devuelvo objeto con mensajito que slaio todo bien.

    const handleChange = ({ target }) => {
        setEleccion((eleccion) => {
            return {
                ...eleccion,
                [target.name]: target.value,
            };
        });
    };
    const SelectorProvincia = (e) => {
        e.preventDefault();
        let provinciaID = e.target.value
        if (!provinciaID) return
        console.log("Provincia Id", provinciaID)
        setLocalidades([])
        setEleccion({ ...eleccion, idProvincia: provinciaID })
        axios.post("http://localhost:8080/municipio", JSON.stringify({ id: provinciaID })).then(({ data }) => {
            console.log("Municipios traidos de la base: ", data)
            data.unshift({ id: "", name: "Seleccionar" })
            setMunicipios(data);
        }).catch(error => {
            console.log("Error al traer a los municipios", error)
        })
    }

    const SelectorMunicipio = (e) => {
        e.preventDefault();
        let idMunicipio = e.target.value
        if (!idMunicipio) return
        setEleccion({ ...eleccion, idMunicipio: idMunicipio });
        axios.post("http://localhost:8080/localidad", JSON.stringify({ id: idMunicipio })).then(({ data }) => {
            console.log("Localidades traidas de la base: ", data)
            data.unshift({ id: "", name: "Seleccionar" })
            setLocalidades(data);
        }).catch(error => {
            console.log("Error al traer a las localidades", error)
        })
    }

    const SelectorLocalidad = (e) => {
        e.preventDefault();
        let idlocalidad = e.target.value
        if (!idlocalidad) return
        setEleccion({ ...eleccion, idlocalidad: idlocalidad });

    }

    const SelectorTipo = (e) => {
        e.preventDefault();
        let tipo_nombre = e.target.value
        if (!tipo_nombre) return
        setEleccion({ ...eleccion, tipoOrganizacion: tipo_nombre });
    }







/*
    const SelectorDeSelector = (e) => {
        axios.get("http://localhost:8080/sector", JSON.stringify(e.target.value)).then((data) => {
            console.log("funciono", data)
        }).catch(error => {
            console.log(error)
        })
        e.preventDefault();
    }
*/




    function selectorDeOrganizacion(e) {
        e.preventDefault();
        let organizacionID = e.target.value
        if (!organizacionID) return
        console.log("organizacion ID", organizacionID)
        setOrganizaciones([])
        setEleccion({ ...eleccion, idOrganizacion: organizacionID })
        axios.post("http://localhost:8080/organizacion", JSON.stringify({ id: organizacionID })).then(({ data }) => {
            console.log("Organizaciones traidas de la base: ", data)
            data.unshift({ id: "", name: "Seleccionar" })
            setSectores(data);
        }).catch(error => {
            console.log("Error al traer a los municipios", error)
        })
    }

    const SelectorSectores = (e) => {
        e.preventDefault();
        let idSector = e.target.value
        if (!idSector) return
        setEleccion({ ...eleccion, idSector: idSector });

    }


    
   

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
                                onSubmit={onSubmit}
                            >
                                <div class="alert alert-error"></div>
                                <input
                                    type="text"
                                    placeholder="Razon social"
                                    name="razonSocial"
                                    onChange={handleChange}
                                    required
                                />
                                <input
                                    type="text"
                                    placeholder="Clasificacion"
                                    name="clasificacion"
                                    autocomplete="off"
                                    onChange={handleChange}
                                    required

                                />
                                <h2>Indique su domicilio</h2>

                                <input
                                    type="text"
                                    placeholder="calle"
                                    name="calle"
                                    onChange={handleChange}
                                    required

                                />
                                <input
                                    type="text"
                                    placeholder="altura"
                                    name="altura"
                                    onChange={handleChange}
                                    required

                                />
                                {/* --------UBI SON DESPLEGABLES: localidad,muni,prov PAIS NO -------- */}


                                <select id="ElegirProvincia" name="prov" onChange={SelectorProvincia}>
                                    {
                                        provincias.length ? (
                                            provincias.map((item, i) => {
                                                // if (i === 0) {
                                                //     return (
                                                //         <option key={i} >select</option>
                                                //     )
                                                // }

                                                return (
                                                    <option key={i} value={item.id}>{item.name}</option>
                                                )
                                            })
                                        ) : <option>Aun no hay Provincias</option>
                                    }

                                </select>



                                <select id="ElegirMunicipio" name="muni" onChange={SelectorMunicipio}>
                                    {
                                        municipios.length ? (
                                            municipios.map((item, i) => {
                                                return (
                                                    <option key={i} value={item.id}>{item.name}</option>
                                                )
                                            })
                                        ) : <option>Aun no hay Municipios</option>
                                    }

                                </select>

                                <select id="ElegirLocalidad" name="loc" onChange={SelectorLocalidad}>
                                    {
                                        localidades.length ? (
                                            localidades.map((item, i) => {
                                                return (
                                                    <option key={i} value={item.id}>{item.name}</option>
                                                )
                                            })
                                        ) : <option>Aun no hay Localidades</option>
                                    }

                                </select>

                                <h2>Elegir Tipo</h2>
                                <select id="Tipo" name="Tipo" onChange={SelectorTipo}>
                                    <option value="">Seleccionar</option>
                                    <option value="gubernamental">Gubernamental</option>
                                    <option value="ong">ONG</option>
                                    <option value="empresa">Empresa</option>
                                    <option value="institucion">Institucion</option>
                                </select>

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
                                onSubmit={onSubmit}
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

                                <h2>Elegir Organizacion</h2>
                                <select id="ElegirOrganizacion" name="rol" onChange={selectorDeOrganizacion}>
                                    {
                                        organizaciones.length ? (
                                            organizaciones.map((item,i) => {
                                                return (
                                                    <option key={i} value={item.id}>{item.name}</option>
                                                    
                                                )
                                            })
                                        ) : <option>No hay Organizaciones</option>
                                    }

                                </select>

                                <select id="ElegirSector" name="sect" onChange={SelectorSectores}>
                                    {
                                        provincias.length ? (
                                            provincias.map((item, i) => {
                                                
                                                return (
                                                    <option key={i} value={item.id}>{item.name}</option>
                                                )
                                            })
                                        ) : <option>Aun no hay Sectores</option>
                                    }

                                </select>





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
                                onSubmit={onSubmit}
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