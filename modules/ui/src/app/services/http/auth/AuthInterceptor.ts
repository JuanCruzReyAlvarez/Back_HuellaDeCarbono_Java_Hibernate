import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { LoginService } from './LoginSerivce';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

    constructor (private service : LoginService) {}

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(req).pipe(catchError(this.interceptError()))
    }
    interceptError() {
        return (res : any, obs : Observable<any>) => {
            if (res.status === 401 || res.status === 419)
            {
                window.location.href = "/login"
                return throwError("Unexpected problem occurred");
            }

            if (res.status === 403)
            {
                return this.service.logout()
            }
            
            return obs
        }
    }
}