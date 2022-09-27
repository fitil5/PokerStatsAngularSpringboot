import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs';
import { timer, of } from 'rxjs';
import { switchMap, catchError } from 'rxjs/operators';
import { Hud } from '../modelos/Hud';

@Injectable({
  providedIn: 'root'
})
export class PokerService {
  private endpoint:string = 'http://192.168.1.67:8080/api/';
  constructor(private http: HttpClient) { }

  getHud(): Observable<Hud> {    
    return this.http.get<Hud>(this.endpoint+'hud');
  }
 
  
 

}
