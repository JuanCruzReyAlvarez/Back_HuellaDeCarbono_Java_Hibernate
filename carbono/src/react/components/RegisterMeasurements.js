import React from "react";
import ".././styles/RegisterMeasurements.css";
import $ from "jquery";
import axios from "axios";
import { useEffect, useState } from "react";
import * as XLSX from "xlsx";

export const RegisterMeasurements = () => {
  const [usuario, setUser] = useState({});
  const [eleccion, setEleccion] = useState({});
  const [archivo, setArchivo] = useState(null);

  useEffect(() => {
    const isUserLogg = window.localStorage.getItem("UserLoggedInfo");
    if (isUserLogg) {
      let user = JSON.parse(isUserLogg);
      setUser(user);
      setEleccion({
        rol: user.rol,
        userId: user.id,
      });
    }
  }, []);

  const readExcel = (file) => {
    const promise = new Promise((resolve, reject) => {
      const fileReader = new FileReader();

      fileReader.readAsArrayBuffer(file);

      fileReader.onload = (e) => {
        const bufferArray = e.target.result;

        const wb = XLSX.read(bufferArray, { type: "buffer" });

        const wsname = wb.SheetNames[0];

        const ws = wb.Sheets[wsname];
        const data = XLSX.utils.sheet_to_json(ws);
        resolve(data);
      };

      fileReader.onerror = (error) => {
        reject(error);
      };
    });


    //ACA TE ENVIO EL EXCEL, No estoy mandando ni el user ID ni el rol, avisenme si lo necesitamos
    promise.then((d) => {
      console.log("EXCEL DATOS", d);
      axios
        .get("http://localhost:8080/EXCEL", JSON.stringify(d))
        .then(({ data }) => {
          console.log("funcionaron la subida del excel ", data);
        })
        .catch((error) => {
          console.log("Error al enviar el excel", error);
        });
    });
  };

  return (
    <div className="RegistrarMediciones">
      <div className="bg-img">
        <div className="titulo">
          <h1>Registrar Mediciones</h1>
        </div>
        <div className="paragraph-mediciones">
          <p>
            Lorem ipsum dolor sit, amet consectetur adipisicing
            elit. Assumenda, laborum! Maiores voluptatem consequatur
            exercitationem magnam a consectetur corrupti
            voluptatibus ratione, molestias ullam harum quis laborum
            vitae tenetur, iste facilis vero.
          </p>
        </div>

        <div className="file-upload">
          <div className="image-upload-wrap">
            <input
              className="file-upload-input"
              name="files"
              type="file"
              onChange={(e) => {
                const file = e.target.files[0];
                readExcel(file);
              }}
            />
            <div className="drag-text">
              <h3>Haz click aquí o arrastra un archivo</h3>
            </div>
            <br />
            <br />
          </div>
          <div className="file-upload-content">
            <img
              className="file-upload-image"
              src="#"
              alt="your image"
            />
          </div>
        </div>
      </div>
    </div>
  );
};
