import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { UploadFileService } from '../../services/upload-file.service';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import swal from 'sweetalert2'
import { Router } from '@angular/router';
import { DataService } from '../../services/data.service';
import { Hud } from 'src/app/modelos/Hud';


@Component({
  selector: 'form-upload',
  templateUrl: './form-upload.component.html',
  styleUrls: ['./form-upload.component.css']
})
export class FormUploadComponent implements OnInit {
  selectedFiles: FileList;
  currentFileUpload: File;
  progress: { percentage: number } = { percentage: 0 };
  excelResponse:any;
 
  constructor(private uploadService: UploadFileService, private router: Router, public dataService: DataService) { }
 
  ngOnInit() {
    if (!localStorage.getItem('foo')) { 
      localStorage.setItem('foo', 'no reload') 
      window.location.reload()
    } else {
      localStorage.removeItem('foo') 
    }
  
   
  }
 
  selectFile(event) {
    this.selectedFiles = event.target.files;
   this.upload()
  }
 
  upload() {
    this.progress.percentage = 0; 
    this.currentFileUpload = this.selectedFiles.item(0);
     this.uploadService.pushFileToStorage(this.currentFileUpload).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } 
      else  if (event.type === HttpEventType.Response) {
       
      let hud: Hud
      hud =event.body as Hud
for (let i =0; i<this.dataService.huds.length; i++ ){
  if (this.dataService.huds[i].nombre_mesa===hud.nombre_mesa){
    this.dataService.huds.splice(i,1)
  }
}
 this.dataService.huds.push(event.body as Hud)
this.redireccionPoker()


    
      }       
    });
    
    this.selectedFiles = undefined;
  }

  redireccionPoker(){
    this.router.navigate(['/poker'])
  }
  
  

}
