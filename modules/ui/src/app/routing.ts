import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthenticatedUserDispatcher } from './services/http/auth/AuthenticatedUserDispatcher';
import { OrganizationCreateView } from './views/admin/organization/create/organizationCreate';
import { OrganizationView } from './views/admin/organization/organization';
import { LoginView } from './views/auth/login';
import { Home } from './views/home/home';

const routes: Routes =
    [
        { path: 'login', component: LoginView },

        {
            path: 'ui', children: [
                { path: '', component: AuthenticatedUserDispatcher },
                {
                    path: 'admin', children: [
                        { path: 'organization', component: OrganizationView },
                        { path: 'organization/create', component: OrganizationCreateView },
                    ]
                },
                {
                    path: 'org', children: [
                        { path: '', component: Home },
                    ]
                },
                {
                    path: 'member', children: [
                        { path: '', component: Home },
                    ]
                },
            ]
        },

        { path: '**', redirectTo: 'ui', pathMatch: 'full' }
    ];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
