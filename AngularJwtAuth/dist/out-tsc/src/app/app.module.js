"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var platform_browser_1 = require("@angular/platform-browser");
var core_1 = require("@angular/core");
var app_routing_module_1 = require("./app-routing.module");
var http_1 = require("@angular/common/http");
var forms_1 = require("@angular/forms");
var app_component_1 = require("./app.component");
var login_component_1 = require("./login/login.component");
var user_component_1 = require("./user/user.component");
var register_component_1 = require("./register/register.component");
var home_component_1 = require("./home/home.component");
var admin_component_1 = require("./admin/admin.component");
var pm_component_1 = require("./pm/pm.component");
var auth_interceptor_1 = require("./auth/auth-interceptor");
var administracion_component_1 = require("./administracion/administracion.component");
var edit_usuario_component_1 = require("./administracion/edit-usuario/edit-usuario.component");
var data_service_1 = require("./services/data.service");
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        core_1.NgModule({
            declarations: [
                app_component_1.AppComponent,
                login_component_1.LoginComponent,
                user_component_1.UserComponent,
                register_component_1.RegisterComponent,
                home_component_1.HomeComponent,
                admin_component_1.AdminComponent,
                pm_component_1.PmComponent,
                administracion_component_1.AdministracionComponent,
                edit_usuario_component_1.EditUsuarioComponent
            ],
            imports: [
                platform_browser_1.BrowserModule,
                app_routing_module_1.AppRoutingModule,
                forms_1.FormsModule,
                http_1.HttpClientModule
            ],
            providers: [auth_interceptor_1.httpInterceptorProviders, data_service_1.DataService],
            bootstrap: [app_component_1.AppComponent]
        })
    ], AppModule);
    return AppModule;
}());
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map