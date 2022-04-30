import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { LoginService } from "./LoginSerivce";

@Component({
    selector: 'authenticated-user-dispatcher',
    template: ''
})
export class AuthenticatedUserDispatcher implements OnInit {

    constructor(private service : LoginService, private router : Router) {}

    ngOnInit() : void {
        
        this.service.authorizedUser().subscribe({
            next : (data) => {
                let roles = data.authorities.map((x : any) => x.authority)

                if (roles.includes("ROLE_ADMIN"))
                    this.router.navigate(["admin"])
                else if (roles.includes("ROLE_ORGANIZATION"))
                    this.router.navigate(["org"])
                else if (roles.includes("ROLE_MEMBER"))
                    this.router.navigate(["member"])
                else
                    window.location.href = "/login"
            }
        })
    }
}