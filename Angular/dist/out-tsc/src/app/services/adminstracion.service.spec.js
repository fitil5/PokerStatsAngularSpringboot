"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var testing_1 = require("@angular/core/testing");
var adminstracion_service_1 = require("./adminstracion.service");
describe('AdminstracionService', function () {
    beforeEach(function () {
        testing_1.TestBed.configureTestingModule({
            providers: [adminstracion_service_1.AdminstracionService]
        });
    });
    it('should be created', testing_1.inject([adminstracion_service_1.AdminstracionService], function (service) {
        expect(service).toBeTruthy();
    }));
});
//# sourceMappingURL=adminstracion.service.spec.js.map