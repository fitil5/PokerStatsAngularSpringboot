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
var Usuario_models_1 = require("../../modelos/Usuario.models");
var adminstracion_service_1 = require("../../services/./../services/adminstracion.service");
var router_1 = require("@angular/router");
var data_service_1 = require("../../services/data.service");
var sweetalert2_1 = require("sweetalert2");
var EditUsuarioComponent = /** @class */ (function () {
    function EditUsuarioComponent(adminstracionService, route, dataService, router) {
        this.adminstracionService = adminstracionService;
        this.route = route;
        this.dataService = dataService;
        this.router = router;
        // usuario = new Usuario();
        //@Input() usuario:Usuario;// = { username: '', password: '', rol:'',enabled:null, visitado:null};
        this.usuario = new Usuario_models_1.Usuario();
    }
    EditUsuarioComponent.prototype.ngOnInit = function () {
        //this.usuario =this.route.snapshot.params['Usuario'];
        if (this.dataService.usuario == null) {
            this.router.navigate(['/']);
        }
        else {
            this.usuario = this.dataService.usuario;
            //this.usuario.role =this.dataService.usuario.role;
            //this.usuario.username =this.dataService.usuario.username;
            this.usuario.password = null;
        }
        // this.usuario =this.dataService.usuario;
    };
    EditUsuarioComponent.prototype.editUsuario = function () {
        var _this = this;
        sweetalert2_1.default.fire({
            title: '¿Estas Seguro?',
            text: "No podras volver atras",
            //type: 'question',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Si, Modificalo!'
        }).then(function (result) {
            if (result.value) {
                sweetalert2_1.default.fire('Modificado!', 'El registro ha sido modificado', 'success').then(function (result) {
                    if (result.value) {
                        if (_this.usuario.password == null) {
                            console.log("password is null");
                            _this.usuario.password = _this.dataService.usuario.password;
                        }
                        _this.adminstracionService.updateUsuario(_this.usuario).subscribe(function (usuario) {
                            console.log("Usuario modificado");
                        });
                        _this.redireccion();
                    }
                });
            }
            else {
                sweetalert2_1.default.fire('Cancelado', 'No se ha modificado el registro', 'error');
            }
        });
    };
    EditUsuarioComponent.prototype.redireccion = function () {
        this.router.navigate(['/usuario']);
    };
    EditUsuarioComponent = __decorate([
        core_1.Component({
            selector: 'app-edit-usuario',
            templateUrl: './edit-usuario.component.html',
            styleUrls: ['./edit-usuario.component.css']
        }),
        __metadata("design:paramtypes", [adminstracion_service_1.AdminstracionService, router_1.ActivatedRoute, data_service_1.DataService, router_1.Router])
    ], EditUsuarioComponent);
    return EditUsuarioComponent;
}());
exports.EditUsuarioComponent = EditUsuarioComponent;
//# sourceMappingURL=edit-usuario.component.js.map