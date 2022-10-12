import React from "react";
import ".././styles/Hall.css";
import { useLocation } from 'react-router-dom';






export const Hall = () => {

const slidePage = document.querySelector(".slide-page");
//const nextBtnFirst = document.querySelector(".firstNext");
const prevBtnSec = document.querySelector(".prev-1");
const nextBtnSec = document.querySelector(".next-1");
const prevBtnThird = document.querySelector(".prev-2");
const nextBtnThird = document.querySelector(".next-2");
const prevBtnFourth = document.querySelector(".prev-3");
const submitBtn = document.querySelector(".submit");
const progressText = document.querySelectorAll(".step p");
const progressCheck = document.querySelectorAll(".step .check");
const bullet = document.querySelectorAll(".step .bullet");
const location = useLocation();


let current = 1;

const nextBtnFirst = (event) =>{
  event.preventDefault();
  slidePage.style.marginLeft = "-25%";
  bullet[current - 1].classList.add("active");
  progressCheck[current - 1].classList.add("active");
  progressText[current - 1].classList.add("active");
  current += 1;
};
nextBtnSec.addEventListener("click", function(event){
  event.preventDefault();
  slidePage.style.marginLeft = "-50%";
  bullet[current - 1].classList.add("active");
  progressCheck[current - 1].classList.add("active");
  progressText[current - 1].classList.add("active");
  current += 1;
});
nextBtnThird.addEventListener("click", function(event){
  event.preventDefault();
  slidePage.style.marginLeft = "-75%";
  bullet[current - 1].classList.add("active");
  progressCheck[current - 1].classList.add("active");
  progressText[current - 1].classList.add("active");
  current += 1;
});

submitBtn.addEventListener("click", function(){
  bullet[current - 1].classList.add("active");
  progressCheck[current - 1].classList.add("active");
  progressText[current - 1].classList.add("active");
  current += 1;
  
  setTimeout(function(){
    alert("Your Form Successfully Signed up");
    location.pathname.reload();
  },800);
});

prevBtnSec.addEventListener("click", function(event){
  event.preventDefault();
  slidePage.style.marginLeft = "0%";
  bullet[current - 2].classList.remove("active");
  progressCheck[current - 2].classList.remove("active");
  progressText[current - 2].classList.remove("active");
  current -= 1;
});

prevBtnThird.addEventListener("click", function(event){
  event.preventDefault();
  slidePage.style.marginLeft = "-25%";
  bullet[current - 2].classList.remove("active");
  progressCheck[current - 2].classList.remove("active");
  progressText[current - 2].classList.remove("active");
  current -= 1;
});

prevBtnFourth.addEventListener("click", function(event){
  event.preventDefault();
  slidePage.style.marginLeft = "-50%";
  bullet[current - 2].classList.remove("active");
  progressCheck[current - 2].classList.remove("active");
  progressText[current - 2].classList.remove("active");
  current -= 1;
});

    return (

        <html lang="en" dir="ltr">
        <head>
            <meta charset="utf-8"/>
            <title>Multi Step Form with Step Progress Bar || Learningrobo</title>
            <link rel="stylesheet" href="style.css"/>
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
            <link rel="stylesheet" href="style.css"/>
        </head>
        <body>
            <div class="container">
                <header>Signup Form</header>
                <div class="progress-bar">
                    <div class="step">
                    <p>
                        Name
                    </p>
                    <div class="bullet">
                        <span>1</span>
                    </div>
                    <div class="check fas fa-check"></div>
                    </div>
                    <div class="step">
                    <p>
                        Contact
                    </p>
                    <div class="bullet">
                        <span>2</span>
                    </div>
                    <div class="check fas fa-check"></div>
                    </div>
                    <div class="step">
                    <p>
                        Birth
                    </p>
                    <div class="bullet">
                        <span>3</span>
                    </div>
                    <div class="check fas fa-check"></div>
                    </div>
                    <div class="step">
                    <p>
                        Submit
                    </p>
                    <div class="bullet">
                        <span>4</span>
                    </div>
                    <div class="check fas fa-check"></div>
                    </div>
                </div>
                <div class="form-outer">
                    <form action="#">
                    <div class="page slide-page">
                        <div class="title">
                            Name :
                        </div>
                        <div class="field">
                            <div class="label">
                                First Name
                            </div>
                            <input type="text"/>
                        </div>
                        <div class="field">
                            <div class="label">
                                Last Name
                            </div>
                            <input type="text"/>
                        </div>
                        <div class="field">
                            <button onClick={nextBtnFirst} class="firstNext next">Next</button>
                        </div>
                    </div>
                    <div class="page">
                        <div class="title">
                            Contact :
                        </div>
                        <div class="field">
                            <div class="label">
                                Email Address
                            </div>
                            <input type="text"/>
                        </div>
                        <div class="field">
                            <div class="label">
                                Phone Number
                            </div>
                            <input type="Number"/>
                        </div>
                        <div class="field btns">
                            <button class="prev-1 prev">Previous</button>
                            <button class="next-1 next">Next</button>
                        </div>
                    </div>
                    <div class="page">
                        <div class="title">
                            Date of Birth :
                        </div>
                        <div class="field">
                            <div class="label">
                                Date
                            </div>
                            <input type="text"/>
                        </div>
                        <div class="field">
                            <div class="label">
                                Gender
                            </div>
                            <select>
                                <option>Male</option>
                                <option>Female</option>
                                <option>Other</option>
                            </select>
                        </div>
                        <div class="field btns">
                            <button class="prev-2 prev">Previous</button>
                            <button class="next-2 next">Next</button>
                        </div>
                    </div>
                    <div class="page">
                        <div class="title">
                            Login Details :
                        </div>
                        <div class="field">
                            <div class="label">
                                Username
                            </div>
                            <input type="text"/>
                        </div>
                        <div class="field">
                            <div class="label">
                                Password
                            </div>
                            <input type="password"/>
                        </div>
                        <div class="field btns">
                            <button class="prev-3 prev">Previous</button>
                            <button class="submit">Submit</button>
                        </div>
                    </div>
                    </form>
                </div>
                
            </div>
            <script src="script.js"></script>
        </body>
        </html>
    )
}
