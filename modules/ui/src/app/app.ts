import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { MenuItem } from 'primeng/api';
import { LoginService } from './services/http/auth/LoginSerivce';

@Component({
    selector: 'app-root',
    templateUrl: './views/app.html',
    styles: []
})
export class AppComponent implements OnInit {

    isLogin: boolean = window.location.href.includes("login")
    
    userMenuItems: MenuItem[] = []
    sideMenuItems: MenuItem[] = []
    leftTooltipItems: MenuItem[] = []   
    user: any = undefined

    constructor(private service: LoginService, private router: Router) { }

    ngOnInit(): void {

        this.router.events.subscribe({
            next: (event: any) => {
                if (event instanceof NavigationEnd) {
                    
                    let wasLogin = this.isLogin
                    this.isLogin = window.location.href.includes("login")

                    if (wasLogin)
                        this.initializeUserData()
                }
            }
        })

        this.initializeUserData()
    }
    
    initializeUserData(): void {
        if (!this.isLogin)
            this.service.authorizedUser().subscribe({
                next: (data) => {
                    this.user = data
                    this.initializeSidebarMenu()
                }
            })
    }

    initializeSidebarMenu(): void {
        this.userMenuItems = [{
            label: 'LogOut',
            icon: 'pi pi-power-off',
            command: () => { this.logOut() }
        }]

        this.sideMenuItems = [
            {
                tooltipOptions: {
                    tooltipPosition: 'right',
                    tooltipLabel: "Ver Organizaciones"
                },
                icon: 'pi pi-eye',
                routerLink: '/ui/admin/organization'
            },
            {
                tooltipOptions: {
                    tooltipPosition: 'right',
                    tooltipLabel: "Crear Nueva Organizacion"
                },
                icon: 'pi pi-pencil',
                routerLink: '/ui/admin/organization/create'
            },
        ];

        // this.sideMenuItems = [{
        //     label: 'Organizaciones',
        //     items: [
        //         { label: 'Ver Todas', routerLink: '/ui/admin/organization' },
        //         { label: 'Crear Nueva', routerLink: '/ui/admin/organization/create' }
        //     ]
        // }]
    }

    logOut(): void {
        this.service.logout().subscribe({
            next: (resp) => window.location.href = "/login"
        })
    }
}
