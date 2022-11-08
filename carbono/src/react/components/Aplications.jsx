import React from 'react'
import ".././styles/Aplications.css";
import axios from "axios";
import { useEffect, useState } from "react";
import ".././styles/Hall.css";
import $ from 'jquery'


export const Aplications = () => {
    const [usuario, setUser] = useState({});
    const [eleccion, setEleccion] = useState({});
    const [organizaciones, setOrganizaciones] = useState([]);
    const [sectores, setSectores] = useState([]);


    useEffect(() => {
        const isUserLogg = window.localStorage.getItem("UserLoggedInfo");
        if (isUserLogg) {
            let user = JSON.parse(isUserLogg)
            setUser(user);
            setEleccion({
                rol: user.rol,
                userId: user.id
            })
            axios.get("http://localhost:8080/organizacion", JSON.stringify(usuario)).then(({ data }) => {
                console.log("funciono el get a organizaciones", data)
                data.unshift({ id: "", razonSocial: "Seleccionar" })
                setOrganizaciones(data)
            }).catch(error => {
                console.log(error)
            })



        }
    }, []);
  
    const selectorDeOrganizacion = (e) => {
        e.preventDefault();
        let organizacionID = e.target.value
        if (!organizacionID) return
        console.log("organizacion ID", organizacionID)
        setOrganizaciones([])
        setEleccion({ ...eleccion, idOrganizacion: organizacionID })
        axios.post("http://localhost:8080/sectores", JSON.stringify({ id: organizacionID })).then(({ data }) => {
            console.log("sectores traidos de la base: ", data)
            data.unshift({ id: "", nombre: "Seleccionar" })
            setSectores(data);
        }).catch(error => {
            console.log("Error al traer a los sectores", error)
        })
    }



    const SelectorSectores = (e) => {
        e.preventDefault();
        let idSector = e.target.value
        if (!idSector) return
        setEleccion({ ...eleccion, idSector: idSector });

    }



    const handleChange = ({ target }) => {
        setEleccion((eleccion) => {
            return {
                ...eleccion,
                [target.name]: target.value,
            };
        });
    };


    const onSubmit = (e) => {
        e.preventDefault();
        axios.post("http://localhost:8080/solMiembro", JSON.stringify(eleccion)).then((data) => { //mando este usuario creado a ese esa url mediando un post obviamente (a mi back), lo mando en tipo json, (por eso json.usuario), (acordarce que este usuario es lo que comenzo como un estado local vacio y se fue haciendo en los inputs y las funciones), y acordarce juan que con el .then estoy haciendo una promesa, es decir hay algo que me va a devolver mi back luego de que yo le mande el usuario y lo tengo que atajar. Si sale todo bien me cae en el then.Esto quiere decir que va a estar en mi data lo que me haya mandado mi back. Acordarce que data es una palabra reservada que puse yo y que va a lamacenar cualquier cosa que yo le mand edel back.
            //. Si hay problema me va al catch.ya sea problemas de comunicacion de servidor del cliente o nuestro. O tambien puede pasar que no cumpla logica necesaria como que la contraseña no sea correcta, enotnces esto se mando el usuario en json JSON.stringify(usuario)) , ahi se ejecuta un wait() hasta que el back procesa y manda un signal() para que se termine de ejecutar la promesa en el then(), si todo bien too ok, sino cumplio logica como deciamos mi back catghea ese error y le dispara el error a este servidor.
            console.log("funciono el solMiembro", data)
        }).catch(error => {
            console.log("No funciono el solMiembro", error)
        })
    }

    return (
        <div className="aplications_rocio">
            <div className="form">

                <div className="form-text">
                    <div className="form-text-tit">
                        <h1>Formá parte!</h1>
                    </div>
                    <div className="form-text-tex">
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Aspernatur distinctio, perspiciatis repudiandae dolorem provident repellat a optio dolores dolorum reprehenderit voluptatem sit, quos placeat? Nihil in cum labore atque aspernatur?</p>
                    </div>
                    <div className="form-form">
                        <div className="form-form-tit">
                            <h1>Formulario de inscripción</h1>
                        </div>
                        <form action="/action_page.php" />
                        <div className="form-form-1">
                            <select id="ElegirOrganizacion" name="rol" onChange={selectorDeOrganizacion}>
                                {
                                    organizaciones.length ? (
                                        organizaciones.map((item, i) => {
                                            return (
                                                <option key={i} value={item.id}>{item.name}</option>

                                            )
                                        })
                                    ) : <option>No hay Organizaciones</option>
                                }

                            </select>
                        </div>

                        <div className="form-form-2">

                            <select id="ElegirSector" name="sect" onChange={SelectorSectores}>
                                {
                                    sectores.length ? (
                                        sectores.map((item, i) => {

                                            return (
                                                <option key={i} value={item.idSector}>{item.nombre}</option>
                                            )
                                        })
                                    ) : <option>Aun no hay Sectores</option>
                                }

                            </select>
                        </div>



                        <div className="form-form-2">
                            <input type="text" id="lname" name="apellido" placeholder="Apellido" onChange={handleChange} />
                        </div>
                        <div className="form-form-2">
                            <input type="text" id="lname" name="name" placeholder="Nombre" onChange={handleChange} />
                        </div>
                        <div className="form-form-3">
                            {/* <div className="form-form-3-1">
                                <select name="DocType" id="">
                                    <option value="DNI">DNI</option>
                                    <option value=""></option>
                                    <option value=""></option>
                                </select>
                            </div> */}
                            {/* <div className="form-form-3-2">
                                <input type="text" placeholder="Número" />
                            </div> */}
                        </div>

                        <div className="form-form-4" onClick={onSubmit}>
                            <button>Enviar Solicitud</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
