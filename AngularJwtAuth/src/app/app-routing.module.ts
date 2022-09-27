import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormUploadComponent } from './upload/form-upload/form-upload.component';
import { PokerComponent } from './poker/poker.component';


const routes: Routes = [
    {
        path: 'upload',
        component: FormUploadComponent
    },
    {
        path: 'poker',
        component: PokerComponent
    },
    {
        path: '',
        redirectTo: 'upload',
        pathMatch: 'full',
        
    },
    {  path: '**', redirectTo: 'upload'}
    
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
