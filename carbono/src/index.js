//Este archivo es el corazon para que funcione Reactt
import React from "react";
import {createRoot} from "react-dom/client";
import App from "./react/App.jsx";
// importt { Provider } from "react-redux";
import { BrowserRouter } from "react-router-dom";


const root = createRoot(document.getElementById("root"));
root.render(
  <BrowserRouter>
        <App />
  </BrowserRouter>,
);
