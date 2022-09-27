import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public roles: string[];
  public authority: string;
  constructor(private router: Router) { }

  ngOnInit() {
    
  }

 
  redireccion(){
    this.router.navigate(['/'])
  }
}