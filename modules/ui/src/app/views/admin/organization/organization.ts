import { Component, OnInit } from "@angular/core";
import { OrganizationService } from "src/app/services/http/admin/organizationService";
import { Organization } from "src/app/models/organization";

@Component({
    selector: 'organization-view',
    templateUrl: './organization.html'
})
export class OrganizationView implements OnInit {

    organizations : Organization[] = []

    constructor (private service : OrganizationService) {}

    ngOnInit(): void {
        this.service.getAll().subscribe({
            next: (response) => {
                if (response.organizations)
                    this.organizations = response.organizations
            }
        })
    }

}