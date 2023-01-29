"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var testing_1 = require("@angular/core/testing");
var token_storage_service_1 = require("./token-storage.service");
describe('TokenStorageService', function () {
    beforeEach(function () {
        testing_1.TestBed.configureTestingModule({
            providers: [token_storage_service_1.TokenStorageService]
        });
    });
    it('should be created', testing_1.inject([token_storage_service_1.TokenStorageService], function (service) {
        expect(service).toBeTruthy();
    }));
});
//# sourceMappingURL=token-storage.service.spec.js.map