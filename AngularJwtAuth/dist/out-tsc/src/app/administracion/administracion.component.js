"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var adminstracion_service_1 = require("../services/adminstracion.service");
var router_1 = require("@angular/router");
var data_service_1 = require("../services/data.service");
var AdministracionComponent = /** @class */ (function () {
    function AdministracionComponent(adminstracionService, router, dataService) {
        this.adminstracionService = adminstracionService;
        this.router = router;
        this.dataService = dataService;
    }
    AdministracionComponent.prototype.ngOnInit = function () {
        this.getUsuarios();
    };
    AdministracionComponent.prototype.getUsuarios = function () {
        var _this = this;
        this.adminstracionService.getUsuarios().subscribe((function (usuarios) {
            _this.usuarios = usuarios;
            console.log(_this.usuarios);
        }));
    };
    AdministracionComponent.prototype.update = function (usuario) {
        this.dataService.usuario = usuario;
        this.router.navigate(['/editUsuario']);
    };
    AdministracionComponent = __decorate([
        core_1.Component({
            selector: 'app-administracion',
            templateUrl: './administracion.component.html',
            styleUrls: ['./administracion.component.css']
        }),
        __metadata("design:paramtypes", [adminstracion_service_1.AdminstracionService, router_1.Router, data_service_1.DataService])
    ], AdministracionComponent);
    return AdministracionComponent;
}());
exports.AdministracionComponent = AdministracionComponent;
//# sourceMappingURL=administracion.component.js.map