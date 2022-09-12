import React from 'react'
import ".././styles/Login.css";

export const Login = () => {
  return (
    <body>
    <div class="body">
    </div>
    <form method="POST" action="login">
            <div class="grad"></div>
            <div class="header">
                <div>Calculador<span><strong> Huella Ecologica</strong></span></div>
            </div>
            <br/>
            <div class="login">
                    <input id="username" type="text" placeholder="Username" name="username" autocomplete="off"/>
                    <input id="password" type="password" placeholder="Password" name="password" autocomplete="off"/>
                    <input type="submit" value="Login"/> 
                    <br/>
                    <p class="hrefRegister" >Si no estas registrado.</p>
                    <a href="register" class="textLogin" style={{float: "right"}}> <strong> Registrate! </strong> </a>
            </div>
    </form>
    
    </body>
    
  )
}
