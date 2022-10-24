import React from "react";
import ".././styles/Contacts.css";
import $ from 'jquery'
export const Contacts = () => {
    $(document).ready(function () {
        $("#listita").hide();



        $("#botonsito").click(function () {

            $("#formularito").show();
            $("#listita").show();
        });
    });


    return (
        <div class="aa">
            <link href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet"></link>




            <div id="formularito">
                
                <form method="POST" action="addContacts" class="ccform">
                    <h1>AÑADIR NUEVOS CONTACTOS</h1>
                    <div class="ccfield-prepend">
                        <span class="ccform-addon"><i class="fa fa-user fa-2x"></i></span>
                        <input class="ccformfield" type="text" placeholder="Nombre Completo" required />
                    </div>
                    <div class="ccfield-prepend">
                        <span class="ccform-addon"><i class="fa fa-envelope fa-2x"></i></span>
                        <input class="ccformfield" type="text" placeholder="Email" required />
                    </div>
                    <div class="ccfield-prepend">
                        <span class="ccform-addon">
                            <i class="fa fa-mobile-phone fa-2x"></i>

                        </span>
                        <input class="ccformfield" type="text" placeholder="Celular" />
                    </div>

                    <div className="buttons">

                        <div id="botonsito">

                            <div class="ccfield-prepend">
                                <input class="ccbtn" type="submit" value="Ver Lista de Contactos" />
                            </div></div>

                        <div class="ccfield-prepend">
                            <input class="ccbtn" type="submit" value="Guardar" />
                        </div>

                    </div>
                </form>

            </div>



            <div id="listita">


                <div class="contacts">
                    <h1 class="contacts__title">My contacts</h1>

                    <section class="contacts__section">
                        <h2 class="contacts__subtitle">A</h2>
                        <ul class="contacts__list">
                            <li class="contacts__item">Ty Adamson</li>
                            <a href="#" class="boton rojo">X</a>
                            <a href="#" class="boton verde">Edit</a>

                            <li class="contacts__item">Elyse Andrews</li>
                            <a href="#" class="boton rojo">X</a>
                            <a href="#" class="boton verde">Edit</a>

                            <li class="contacts__item">Judith Aronson</li>
                            <a href="#" class="boton rojo">X</a>
                            <a href="#" class="boton verde">Edit</a>

                            <li class="contacts__item">Liv Assimos</li>
                            <a href="#" class="boton rojo">X</a>
                            <a href="#" class="boton verde">Edit</a>

                        </ul>
                    </section>

                    <section class="contacts__section">
                        <h2 class="contacts__subtitle">B</h2>
                        <ul class="contacts__list">
                            <li class="contacts__item">Aaron Bacon</li>
                            <li class="contacts__item">Eric Bailey</li>
                            <li class="contacts__item">Jordan Beyer</li>
                            <li class="contacts__item">Aditi Bhandari</li>
                            <li class="contacts__item">Judy Blomquist</li>
                            <li class="contacts__item">Mike Borsare</li>
                        </ul>
                    </section>

                    <section class="contacts__section">
                        <h2 class="contacts__subtitle">C</h2>
                        <ul class="contacts__list">
                            <li class="contacts__item">Lindsay Cardinale</li>
                            <li class="contacts__item">Alvin Chang</li>
                            <li class="contacts__item">Marlene Chow</li>
                            <li class="contacts__item">Lindsey Christensen</li>
                            <li class="contacts__item">Tiffany Chu</li>
                            <li class="contacts__item">Chris Ciocca</li>
                        </ul>
                    </section>


                </div>
            </div>
        </div >




    )
}