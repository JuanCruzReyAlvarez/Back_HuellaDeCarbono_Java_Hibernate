import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { LoginService } from "src/app/services/http/auth/LoginSerivce";

@Component({
    selector: 'login-view',
    templateUrl: './login.html',
    styleUrls: ["./login.css"]
})
export class LoginView {

    username : string = ''
    password : string = ''

    constructor(private service: LoginService, private router : Router) {}

    login() : void {
        this.service.login(this.username, this.password).subscribe({
            next: (response) => {
                this.router.navigate(['/ui'])
            }
        })
    }
}