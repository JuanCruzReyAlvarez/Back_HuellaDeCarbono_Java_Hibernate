import React from "react";
import ".././styles/Navbar.css";

export const Navbar = () => {
    return (
        <div>
            <nav>

                <div className="Logo">
                    <img
                        src="https://img.icons8.com/fluency/48/000000/natural-food.png"
                        alt="LOGO"
                    />
                </div>
                <div className="nav">
                    <ul>
                        {/* si el user esta log */}
                        <li>Cerrar Session</li>
                    </ul>
                </div>
            </nav>
        </div>
    );
};
