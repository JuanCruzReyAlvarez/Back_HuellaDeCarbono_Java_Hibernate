import React from 'react'
import ".././styles/Aplications.css";

export const Aplications = () => {
/*     var alertRedInput = "#8C1010";
var defaultInput = "rgba(10, 180, 180, 1)";

function userNameValidation(usernameInput) {
    var username = document.getElementById("username");
    var issueArr = [];
    if (/[-!@#$%^&*()_+|~=`{}\[\]:";'<>?,.\/]/.test(usernameInput)) {
        issueArr.push("No special characters!");
    }
    if (issueArr.length > 0) {
        username.setCustomValidity(issueArr);
        username.style.borderColor = alertRedInput;
    } else {
        username.setCustomValidity("");
        username.style.borderColor = defaultInput;
    }
}

function passwordValidation(passwordInput) {
    var password = document.getElementById("password");
    var issueArr = [];
    if (!/^.{7,15}$/.test(passwordInput)) {
        issueArr.push("Password must be between 7-15 characters.");
    }
    if (!/\d/.test(passwordInput)) {
        issueArr.push("Must contain at least one number.");
    }
    if (!/[a-z]/.test(passwordInput)) {
        issueArr.push("Must contain a lowercase letter.");
    }
    if (!/[A-Z]/.test(passwordInput)) {
        issueArr.push("Must contain an uppercase letter.");
    }
    if (issueArr.length > 0) {
        password.setCustomValidity(issueArr.join("\n"));
        password.style.borderColor = alertRedInput;
    } else {
        password.setCustomValidity("");
        password.style.borderColor = defaultInput;
    }
} */

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
                    <form action="/action_page.php"/>
                    <div className="form-form-1">
                        <input type="text" id="fname" name="firstname" placeholder="DESPLEGABLE ORRGANIZAZION"/>
                    </div>
                    <div className="form-form-2">
                        <input type="text" id="lname" name="lastname" placeholder="Apellido/s"/>
                    </div>
                    <div className="form-form-3">
                    <div className="form-form-3-1">
                        <select name="DocType" id="">
                            <option value="DNI">DNI</option>
                            <option value=""></option>
                            <option value=""></option>
                        </select>
                        </div>
                        <div className="form-form-3-2">
                        <input type="text" placeholder="Número" />
                        </div>
                        </div>
                    
                    <div className="form-form-4">
                        <button>Enviar Solicitud</button>
                    </div>
                    </div>
                </div>
            </div>
        </div>
)
}
