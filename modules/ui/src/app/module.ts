import { ScrollingModule } from '@angular/cdk/scrolling';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CookieService } from 'ngx-cookie-service';
import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';
import { DialogModule } from 'primeng/dialog';
import { DividerModule } from 'primeng/divider';
import { DropdownModule } from 'primeng/dropdown';
import { GMapModule } from 'primeng/gmap';
import { InputTextModule } from 'primeng/inputtext';
import { MenuModule } from 'primeng/menu';
import { ProgressSpinnerModule } from 'primeng/progressspinner';
import { RippleModule } from 'primeng/ripple';
import { SelectButtonModule } from 'primeng/selectbutton';
import { SidebarModule } from 'primeng/sidebar';
import { SpeedDialModule } from 'primeng/speeddial';
import { TableModule } from 'primeng/table';
import { ToastModule } from 'primeng/toast';
import { ToolbarModule } from 'primeng/toolbar';
import { TooltipModule } from 'primeng/tooltip';
import { AppComponent as App } from './app';
import { AppRoutingModule } from './routing';
import { AuthenticatedUserDispatcher } from './services/http/auth/AuthenticatedUserDispatcher';
import { AuthInterceptor } from './services/http/auth/AuthInterceptor';
import { MapUsage } from './views/admin/organization/create/mapUsage';
import { OrganizationCreateView } from './views/admin/organization/create/organizationCreate';
import { OrganizationView } from './views/admin/organization/organization';
import { LoginView } from './views/auth/login';


@NgModule({
  declarations: [
    App, LoginView, AuthenticatedUserDispatcher,

    //admin
    OrganizationView, OrganizationCreateView, MapUsage
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
		HttpClientModule,
    ScrollingModule,

    //primeng
    CardModule, InputTextModule, ButtonModule,
    ToolbarModule, MenuModule, SidebarModule,
    TableModule, ProgressSpinnerModule,
    SelectButtonModule, DropdownModule,
    SpeedDialModule, TooltipModule, RippleModule,
    DividerModule, GMapModule, DialogModule,
    ToastModule
  ],
  providers: [ 
    CookieService,
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true } 
  ],
  bootstrap: [ App ],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],

})
export class AppModule { }
