import { AfterContentInit, AfterViewInit, Component, DoCheck, OnInit } from '@angular/core';
import { Hud } from '../modelos/Hud';
import { DataService } from '../services/data.service';
import { PokerService } from '../services/poker.service';



@Component({
  selector: 'app-poker',
  templateUrl: './poker.component.html',
  styleUrls: ['./poker.component.css']
})
export class PokerComponent  implements OnInit{
huds:Hud[] = new Array();
aux:Hud= new Hud();
  constructor(public pokerService:PokerService,public dataService:DataService) { }

  ngOnInit(): void {
    
  
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
    
    this.huds=this.dataService.huds;
   
  
    //this.getHud()
    //this.timer()
    //this.getHud()
     }
    
  

}
