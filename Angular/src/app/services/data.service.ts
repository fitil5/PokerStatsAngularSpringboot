import { Injectable, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Hud } from '../modelos/Hud';

@Injectable() 
export class DataService{ 
  huds:Hud[] =new Array();
 allow:boolean=true;
 
} 
