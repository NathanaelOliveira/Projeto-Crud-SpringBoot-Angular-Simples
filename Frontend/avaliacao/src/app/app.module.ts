import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CursoListComponent } from './curso-list/curso-list.component';
import { CreateCursoComponent } from './create-curso/create-curso.component';
import {FormsModule} from '@angular/forms';
import { UpdateCursoComponent } from './update-curso/update-curso.component'

@NgModule({
  declarations: [
    AppComponent,
    CursoListComponent,
    CreateCursoComponent,
    UpdateCursoComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
