import React from "react";
import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import ".././styles/Hall.css";

export const Hall = () => {
    const navigate = useNavigate();

    const [usuario, setRegister] = useState({}); 
    

                   

    function onSubmit(e) {
        e.preventDefault();
        axios.post("http://localhost:8080/register", JSON.stringify(usuario)).then((data) => { 
             console.log("funciono", data)
            navigate("/login")
        }).catch(error => {
            console.log(error)
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
            
            <div class="body-content-hall"></div>

            <div class="module">

                    {/* ------------Rol organizacion------------- */}
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
                        name="Razon social"                   
                        onChange={handleChangeNombre}  //cambiar
                        required 
                    />
                    <input
                        type="text"
                        placeholder="Clasificacion"
                        name="Clasificacion"
                        autocomplete="off"
                        onChange={handleChangePassword}//cambiar
                    />
                                                           
                    <input
                        type="text"
                        placeholder="Ubicacion"
                        name="Ubiacion"                        
                        onChange={handleChangeRol} //cambiar
                        required
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
                    {/* ------------Rol Miembro------------- */}                  
                    <h1>Registra tus datos</h1>
                    
                    <input
                        type="text"
                        placeholder="Nombre"
                        name="Nombre"                
                        onChange={handleChangeNombre}  
                        required 
                    />
                                                                           
                    <input
                        type="text"
                        placeholder="Apellido"
                        name="Apellido"                        
                        onChange={handleChangeRol} //cambiar
                        required
                    />
                    <input
                        type="text"
                        placeholder="DESPLEGABLE CON ORGANIZACIONES "
                        name="Lista organizaciones"                        
                        onChange={handleChangeRol} //cambiar
                        required
                    />
                   <input
                        type="text"
                        placeholder="DESPLEGABLE CON SECTORES "
                        name="Lista sectores"                        
                        onChange={handleChangeRol} //cambiar
                        required
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
                        onChange={handleChangeRol} //cambiar
                        required
                    />

                    <label>
                        <input type="checkbox" id="cbox1" value="first_checkbox"/> Enviar mi solicitud de vinculacion a mi organizacion automaticamente </label><br/>

                    <input
                        type="submit"
                        value="Registrar"             
                        name="Siguiente"
                        class="btn btn-block btn-primary"/>
                        </form>
                    {/* ------------Rol Admin------------- */}                  
                    
                    <h1>Registra tus datos</h1>
                    
                    <h2>Elegir Tipo de Sector a cargo</h2> 
                    {<select id="Tipo" name="Tipo">
                   
                        <option>Provincia</option>
                        <option>Municipio</option>                        
                    </select>}
                                                                           
                    <input
                        type="text"
                        placeholder="DESPLEGABLE CON MUNICIPIOS/PRIVINCIAS "
                        name="Lista organizaciones"                        
                        onChange={handleChangeRol} //cambiar
                        required
                    />
                    <input
                        type="submit"
                        value="Registrar"             
                        name="Siguiente"
                        class="btn btn-block btn-primary" />


                    
                
            </div>
        </div>
    );
};