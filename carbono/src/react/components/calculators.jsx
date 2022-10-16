import React from "react";
import ".././styles/calculators.css";
import $ from 'jquery'
export const Calculator = () => {


  $(document).ready(function () {
    $("#cartelito").hide();

    $("#calculitoSectorItems1").hide()
    

    $("#calculitoOrgItems1").hide()
    $("#calculitoItems2").hide()

    $("#calculitoMiembroItems1").hide()
    

    $("#botonsito").click(function () {
      $("#formularito").hide()
      $("#botonsito").hide()
      $("#cartelito").show();
    });

    $("#crucecita").click(function () {
      $("#cartelito").hide();
      $("#formularito").show()
      $("#botonsito").show()
    });
    $("#calculitoOrg").click(function () {



      $("#calculitoSectorItems1").hide()
      
      
      $("#calculitoMiembroItems1").hide()
      

      $("#calculitoOrgItems1").show()
      $("#calculitoItems2").show()

    });

    $("#calculitoSector").click(function () {
      $("#calculitoOrgItems1").hide()
      $("#calculitoMiembroItems1").hide()


      $("#calculitoSectorItems1").show()
      $("#calculitoItems2").show()

      
      

    });

    $("#calculitoMiembro").click(function () {

      $("#calculitoMiembroItems1").show()
      $("#calculitoItems2").show()
      
      $("#calculitoOrgItems1").hide()
      
      $("#calculitoSectorItems1").hide()
      

    });






  });


  return (

    <div className="wrapper">

    <div className="main-container"> {/* CALCULADOR DE ORGANIZACION, ROL ORG */}
      <h1>impacto de la huella de carbono</h1>

      <div className="calculator-container">

        <div className="calculator-title-containter">
          <h2>Calculador de HC para la organizacion</h2>

          <div id="botonsito">
            <p class="pop-up-button">Calcular</p>
          </div>
        </div>

      </div>
      <div id="formularito">
        <form class="" action="index.html" method="post">

          <div className="radio-buttons">

            <div id="calculitoOrg">
              <div class="radio-item">
                <input type="radio" name="tipo-calculo" value="" />
                <label for="">HC de la organizacion</label>
              </div>
            </div>

            <div id="calculitoSector">
              <div class="radio-item">
                <input type="radio" name="tipo-calculo" value="" />
                <label for="">Calculo sobre un sector</label>
              </div>
            </div>
            <div id="calculitoMiembro">
              <div class="radio-item">
                <input type="radio" name="tipo-calculo" value="" />
                <label for="">Calculo sobre un miembro</label>
              </div>
            </div>

          </div>

          <div id="calculitoOrgItems1">

            <div class="grid-item">
              <label for="">Organizacion</label>
              <input type="text" name="" value="" class="text-input" />
            </div>

            <div class="grid-item">
              <label for="">Solicitante</label>
              <input type="text" name="" value="" class="text-input" />
            </div>

          </div>

          <div id="calculitoSectorItems1">

            <div class="grid-item">
              <label for="">Organizacion</label>
              <input type="text" name="" value="" class="text-input" />
            </div>

            <div class="grid-item">
              <label for="">Sector</label>
              <input type="text" name="" value="" class="text-input" />
            </div>

            <div class="grid-item">
              <label for="">Solicitante</label>
              <input type="text" name="" value="" class="text-input" />
            </div>

          </div>


          <div id="calculitoMiembroItems1">

            <div class="grid-item">
              <label for="">Organizacion</label>
              <input type="text" name="" value="" class="text-input" />
            </div>

            <div class="grid-item">
              <label for="">Miembro</label>
              <input type="text" name="" value="" class="text-input" />
            </div>

            <div class="grid-item">
              <label for="">Solicitante</label>
              <input type="text" name="" value="" class="text-input" />
            </div>

          </div>



          <div id="calculitoItems2">

            <div class="grid-item">
              <label for="">Inicio del periodo</label>
              <input type="text" name="" value="" class="text-input" />
            </div>

            <div class="grid-item">
              <label for="">Forma de calculo</label>
              <select className="text-input">
                <option>Mensual</option>
                <option>Anual</option>
              </select>
            </div>

          </div>


        </form>
      </div>

      <div class="pop-up" id="cartelito" >
        <div id="crucecita">
          <span>x</span>
        </div>
        <div class="pop-up-text">
          <h1>RESULTADO = 123 kgms</h1>
          <p>[GRAFICOS]</p>

          
        </div>
      </div>


    </div>

    </div>
  )
}