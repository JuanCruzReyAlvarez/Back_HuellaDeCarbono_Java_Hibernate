import { Component } from "@angular/core";
import { MessageService } from 'primeng/api';
import { ReplaySubject } from "rxjs";
import { GeoLocation } from "src/app/models/geoLocation";
import { Organization, OrganizationType } from "src/app/models/organization";
import { Sector } from "src/app/models/sector";
import { OrganizationService } from "src/app/services/http/admin/organizationService";

@Component({
    selector: 'organization-create-view',
    templateUrl: './organizationCreate.html',
    providers: [ MessageService ]
})
export class OrganizationCreateView {

    orgTypes : any[] = [
        { name: OrganizationType.Gubernamental.toString() }, 
        { name: OrganizationType.ONG.toString() }, 
        { name: OrganizationType.Empresa.toString() },
        { name: OrganizationType.Institucion.toString() },
    ]

    categories : any[] = [
        { label : "Ministerio", value : "Ministerio" },
        { label : "Universidad", value : "Universidad" },
        { label : "Escuela", value : "Escuela" },
        { label : "Empresa_sector_primario", value : "Empresa_sector_primario" },
        { label : "Empresa_sector_secundario", value : "Empresa_sector_secundario" },
        { label : "otro", value : "otro" },
    ]

    mapDialog : boolean = false
    loading : boolean = false
    disableButton : boolean = false

    geoLocationCallback : ReplaySubject<GeoLocation> | undefined

    organization : Organization = {
        id : undefined,
        type : undefined,
        name : undefined,
        classification : undefined,
        sectors : [],
        location : undefined
    }

    constructor(private msg : MessageService, private service : OrganizationService) {}

    ngOnInit() : void {
        this.geoLocationCallback = new ReplaySubject<GeoLocation>(1)
        this.geoLocationCallback.subscribe({
            next: (data : GeoLocation) => {
                this.mapDialog = false
                this.organization.location = data
            }
        })
    }

    removeSector(sector : Sector) : void {
        this.organization.sectors =  this.organization.sectors.filter(x => x.name != sector.name)
    }

    addSector(sectorName : string) : void {
        this.organization.sectors.push({ name: sectorName });
    }

    save() : void {

        this.loading = this.disableButton = true
        
        console.log(this.organization)
        
        this.service.create(this.organization).subscribe({
            next: (response : any) => {
                this.loading = false

                if (response.status != 200)
                    this.disableButton = false

                this.msg.add({
                    severity : response.status == 200 ? 'success' : 'error',
                    summary  : response.message
                })
            }
        })
    }
}