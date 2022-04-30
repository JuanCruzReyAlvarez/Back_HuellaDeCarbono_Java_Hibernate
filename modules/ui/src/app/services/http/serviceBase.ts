import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';

export class ServiceBase
{
    protected mockByUrl : { [id : string] : Function; } = {};
    protected cookie : string = ''

    constructor (protected http : HttpClient, protected cookieService: CookieService) {}

    protected debug = true//location.host == 'localhost:4200' 
    dev     = location.host == 'ddstp.carbono.com'
    testing = location.host == 'ddstp.carbono.com'

    mocked : boolean = true
    
    protected uris = 
    {
        ApiProdURL              : 'http://ddstp.carbono.com/',
        ApiTestingURL           : 'http://ddstp.carbono.com/', 
        ApiDevelopmentURL       : 'http://ddstp.carbono.com/', 

        Api : 
        {
            admin :  {
                organizations : 'api/admin/organizations',
                createOrganization : 'api/admin/organization',
            },

            auth : {
                authorized : 'api/auth/user',
                signin : 'api/auth/signin',
                signout : 'api/auth/signout'
            }
        } 
    }

    public options = 
    { 
        headers : (this.debug) ? new HttpHeaders() 
                               : new HttpHeaders({ "ddscarbono" : this.cookieService.get('ddscarbono') })
    }

    private serverURL() : string
    {
        if (this.debug || this.dev)
            return this.uris.ApiDevelopmentURL
        if (this.testing)
            return this.uris.ApiTestingURL
        else
            return this.uris.ApiProdURL;
    }

    protected mock(url : string) : Observable<any>
    {
        let callback = this.mockByUrl[url]

        if (callback)
            return callback()
        
        return of(null)
    }

    protected get(url: string) : Observable<any>
    {
        if (this.debug && this.mocked)
            return this.mock(url)

        return this.http.get(this.serverURL() + url, this.options)
    }

    protected put(url: string, data: any = {}) : Observable<any>
    {
        if (this.debug && this.mocked)
            return this.mock(url)

        return this.http.put(this.serverURL() + url, data, this.options)
    }

    protected post(url: string, data: any = {}) : Observable<any>
    {
        if (this.debug && this.mocked)
            return this.mock(url)

        return this.http.post(this.serverURL() + url, data, this.options)
    }

    protected postLogin(url: string, data: any = {}) : Observable<any>
    {
        if (this.debug && this.mocked)
            return this.mock(url)

        let options = { headers :  new HttpHeaders({'Content-Type' : 'application/json'}), withCredentials : true }

        return this.http.post(this.serverURL() + url, data, options)
    }

    protected delete(url: string) : Observable<any>
    {
        if (this.debug && this.mocked)
            return this.mock(url)

        return this.http.delete(this.serverURL() + url, this.options)
    }
}