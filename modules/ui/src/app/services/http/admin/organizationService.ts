import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { CookieService } from "ngx-cookie-service";
import { Observable, of } from "rxjs";
import { Organization } from "src/app/models/organization";
import { ServiceBase } from "../serviceBase";

@Injectable({ providedIn: 'root' })
export class OrganizationService extends ServiceBase {

    constructor(protected override http: HttpClient, protected override cookieService: CookieService) {
        super(http, cookieService)

        this.mockByUrl[this.uris.Api.admin.organizations] = () => of({
            organizations: [
                { id : 1, name: 'Organization 1', classification: "Inasdas", type: "Universidad"},
                { id : 2, name: 'Organization 2', classification: 2 },
                { id : 3, name: 'Organization 3', classification: 3 },
            ]
        })

        this.mockByUrl[this.uris.Api.admin.createOrganization] = () => of({
            message: "Razon social existente",
            status : 400
        })
    }

    getAll() : Observable<any> {
        return this.get(this.uris.Api.admin.organizations)
    }

    create(organization : Organization) : Observable<any> {
        return this.post(this.uris.Api.admin.createOrganization, organization)
    }
}