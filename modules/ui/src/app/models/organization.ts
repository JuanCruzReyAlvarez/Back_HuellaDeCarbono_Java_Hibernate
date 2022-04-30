import { GeoLocation } from "./geoLocation"
import { Sector } from "./sector"

export enum OrganizationType {
    Gubernamental = "Gubernamental", 
    ONG           = "ONG", 
    Empresa       = "Empresa",
    Institucion   = "Institucion",
}

export interface Organization {
    id       : number | undefined
    name     : string | undefined
    type     : string | undefined
    sectors  : Sector[]
    location : GeoLocation | undefined
    classification : string | undefined
}