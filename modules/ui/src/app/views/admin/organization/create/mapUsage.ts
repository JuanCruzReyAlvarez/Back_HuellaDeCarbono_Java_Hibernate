import { Component, Input, OnInit } from "@angular/core";
import { Loader } from "@googlemaps/js-api-loader";
import { ReplaySubject } from "rxjs";
import { GeoLocation } from "src/app/models/geoLocation";
declare var google: any; 

@Component({
    selector: 'map-usage',
    templateUrl : './mapUsage.html'
})
export class MapUsage implements OnInit {

    @Input("geoLocationCallback")
    geoLocationCallback : ReplaySubject<GeoLocation> | undefined

    @Input("geoLocation")
    geoLocation : GeoLocation | undefined

    ready : boolean = false

    mapOptions : any = undefined

    overlays : any[] = []

    markerTitle: string | null= '';

    selectedPosition: any;

    infoWindow: any;

    ngOnInit() : void {

        const loader = new Loader({
            apiKey: "AIzaSyCnnZhCCkChnkoel1duuW0Qn5zRBAfLwkc",
            version: "weekly"
        });
          
        loader.load().then(() => 
        { 
            this.mapOptions = {
                center: {
                    lat: -34.60619, 
                    lng: -58.44330
                },
                zoom: 10
            }

            if (this.geoLocation)
            {
                this.selectedPosition = new google.maps.LatLng(this.geoLocation.lat, this.geoLocation.lon)
                this.markerTitle = this.geoLocation.address
                this.overlays.push(new google.maps.Marker({
                    title     : this.markerTitle, 
                    draggable : false,
                    position  : {
                        lat: this.selectedPosition.lat(), 
                        lng: this.selectedPosition.lng()
                    }
                }));
            }

            this.ready = true
        })
    }

    handleMapClick(event : any) : void {
        
        if (this.overlays.length === 0)
        {
            this.selectedPosition = event.latLng;
            this.overlays.push(new google.maps.Marker({
                title     : this.markerTitle, 
                draggable : false,
                position  : {
                    lat: this.selectedPosition.lat(), 
                    lng: this.selectedPosition.lng()
                }
            }));
        }
    }

    clear() : void {
        this.selectedPosition = null
        this.markerTitle = null
        this.overlays = []
    }

    saveLocation() : void {
        this.geoLocationCallback?.next({
            address : this.markerTitle ?? '',
            lat : this.selectedPosition.lat(),
            lon : this.selectedPosition.lng()
        })
    }
}