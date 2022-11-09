import React from "react";
import ".././styles/Contacts.css";


import $ from 'jquery'
import { useEffect, useState } from "react";
import axios from "axios";


export const Contacts = () => {
    const [usuario, setUser] = useState({});
    const [eleccion, setEleccion] = useState({});
    const [inputs, setInputs] = useState("");
    const [contacts, setContacts] = useState("");

    useEffect(() => {
        const isUserLogg = window.localStorage.getItem("UserLoggedInfo");
        if (isUserLogg) {
            let user = JSON.parse(isUserLogg)
            setUser(user);
            setEleccion({
                rol: user.rol,
                userId: user.id
            })
        }
    }, []);

    $(document).ready(function () {
        $("#listita").hide();

        $("input[name='botonShowContacts']").on("click", function(){
            $("#listita").show();
        }).change();

    });

    /* 
    document.addEventListener("DOMContentLoaded", function() {
        "use strict"
        var style = ""
          + "<style>" + ".filter .hidden {" + "opacity: 0;" + "}" + 
            ".filter > * {" + "position: absolute;" + 
            "transition: .5s ease-in-out;"  +  "}" + "</style>";
        document.head.insertAdjacentHTML("beforeend", style);
        
        var list = document.querySelectorAll(".filter > *");
        var h = list[0].offsetHeight, arr = [], i = -1, l = list.length;
        var anim = "transform" in document.body.style ? "transform" : "webkitTransform";
        
        while (++i < l) {
          arr.push(list[i].textContent.trim());
          list[i].style[anim] = "translateY(" + i*h +"px)";
        }
        
          document.querySelector("input.filter").addEventListener("input", function() {
            var rgx = new RegExp(this.value, "i");
                arr.forEach(function(el, idx) {
                  if (rgx.test(el)) list[idx].classList.remove("hidden");
                  else list[idx].classList.add("hidden");
                  var i = -1;
                  var p = 0;
                  while (++i < l) {
                    if (list[i].className != "hidden")
                      list[i].style[anim] = "translateY(" + p++ * h + "px)";
                  }
              })
          })
      })

      */


    


    const handleChange = ({ target }) => {
        setEleccion((eleccion) => {
            return {
                ...eleccion,
                [target.name]: target.value,
            };
        });
    };

    function forEach(collection, action, scope) {
        for (var i = 0; i < collection.length; i++) {
          action.call(scope, collection[i], i);
        }
      }
      

    const onSubmit = (e) => {
        e.preventDefault();
        axios
            .post("http://localhost:8080/addContacts", JSON.stringify(eleccion))
            .then(({ data }) => {
                console.log("funciono addContact", data);

                if (document.getElementById("inputName").value) document.getElementById("inputName").value = ""
                if (document.getElementById("inputEmail").value) document.getElementById("inputEmail").value = ""
                if (document.getElementById("inputCelu").value) document.getElementById("inputCelu").value = ""
                setInputs("")
            })
            .catch((error) => {
                console.log("No funciono! AddContact", error);
                console.log(error);
            });
    }

    const showContacts = (e) => {
        e.preventDefault();
        //NO ESTOY MANDANDO NADA ASI QUE FIJENSE QUE HAY QUE MANDAR EN ESTA RUTA
        axios
            .get("http://localhost:8080/contacts")
            .then(({ data }) => {
                console.log("funciono al traer contacts", data);
                setContacts(data)
            })
            .catch((error) => {
                console.log("No funciono! al traer los contacts", error);
                console.log(error);
            });
    }


    return (
        <>
        <div class="aa">
            <link href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet"></link>
            <div id="formularito">

                <form method="POST" action="addContacts" class="ccform">
                    <h1>AÑADIR NUEVOS CONTACTOS</h1>



                    <div class="ccfield-prepend">
                        <span class="ccform-addon"><i class="fa fa-user fa-2x"></i></span>
                        <input class="ccformfield" name="nombre" type="text" placeholder="Nombre" id="inputName" required onChange={handleChange} />
                    </div>



                    <div class="ccfield-prepend">
                        <span class="ccform-addon"><i class="fa fa-envelope fa-2x"></i></span>
                        <input class="ccformfield" name="email" type="text" placeholder="Email" required id="inputEmail" onChange={handleChange} />
                    </div>

                    <div class="ccfield-prepend">
                        <span class="ccform-addon">
                            <i class="fa fa-mobile-phone fa-2x"></i>
                        </span>
                        <input class="ccformfield" name="celular" type="text" placeholder="Celular" id="inputCelu" onChange={handleChange} />
                    </div>



                    <div className="buttons">
                        <div id="botonsito">
                            <div class="ccfield-prepend">
                                <input name="botonShowContacts" class="ccbtn" type="button" value="Ver Lista de Contactos"  />
                            </div>
                        </div>

                        <div class="ccfield-prepend">
                            <input class="ccbtn" type="submit" value="Guardar" onClick={onSubmit} />
                        </div>

                    </div>
                </form>

            </div>

        </div >

            <section id = "listita" className="sectioncontacts">
                <header>
                    <h4>
                        <span>Log</span>
                        <span>Favorites</span>
                        <span class='c'>Contacts</span>
                    </h4>
                    <input type='search' placeholder="🔍 Search" autofocus class="filter" />
                </header>
                <ul class="filter">
                    <li><span class='img'>👦</span><span class='name'>John</span> <span class='ph'>609-579-1254</span></li>
                    <li><span class='img'>👧</span><span class='name'>Diane</span> <span class='ph'>908-240-2297</span></li>
                    <li><span class='img'>👦</span><span class='name'>Mike</span> <span class='ph'>303-539-1425</span></li>
                    <li><span class='img'>👧</span><span class='name'>Mary</span> <span class='ph'>424-308-9976</span></li>
                    <li><span class='img'>👦</span><span class='name'>Adam</span> <span class='ph'>509-998-0025</span></li>
                    <li><span class='img'>👦</span><span class='name'>Billy</span> <span class='ph'>609-898-3325</span></li>
                </ul>
            </section>
        
            </>
    )
}