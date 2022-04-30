import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { CookieService } from "ngx-cookie-service";
import { Observable, of } from "rxjs";
import { ServiceBase } from "../serviceBase";

@Injectable({ providedIn: 'root' })
export class LoginService extends ServiceBase {

    constructor(protected override http: HttpClient, protected override cookieService: CookieService) {
        super(http, cookieService)

        this.mockByUrl[this.uris.Api.auth.authorized] = () => of({
            username: 'admin',
            authorities : [
                { authority: "ROLE_ADMIN" }
            ]
        })
    }

    login(username : String, password: String) : Observable<any> {
        return this.postLogin(this.uris.Api.auth.signin, { username : username, password : password })
    }

    logout() : Observable<any> {
        return this.post(this.uris.Api.auth.signout, { })
    }

    authorizedUser() : Observable<any>
    {
        return this.get(this.uris.Api.auth.authorized)
    }
}