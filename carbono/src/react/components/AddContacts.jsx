import React from "react";
import ".././styles/AddContacts.css";
import ".././styles/contactsList.css";
export const Contacts = () => {

    
    return (
        <div className="container">
            <link href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet"></link>

        
        
        <div class="wrapper">
            <header class="ccheader">
            <h1>AÑADIR NUEVOS CONTACTOS</h1>	
        </header>
            <form method="post" action="" class="ccform">
            <div class="ccfield-prepend">
                <span class="ccform-addon"><i class="fa fa-user fa-2x"></i></span>
                <input class="ccformfield" type="text" placeholder="Nombre Completo" required/>
            </div>
            <div class="ccfield-prepend">
                <span class="ccform-addon"><i class="fa fa-envelope fa-2x"></i></span>
                <input class="ccformfield" type="text" placeholder="Email" required/>
            </div>
            <div class="ccfield-prepend">
                <span class="ccform-addon">
                    <i class="fa fa-mobile-phone fa-2x"></i>
                    
                </span>
                <input class="ccformfield" type="text" placeholder="Celular"/>
            </div>
            
            <div class="ccfield-prepend">
                <input class="ccbtnL" type="submit" value="Ver Lista de Contactos"/>
            </div>

            <div class="ccfield-prepend">
                <input class="ccbtnR" type="submit" value="Guardar"/>
            </div>
            </form>
                   
             </div>
            
        </div >
        
        
        
    )
  }