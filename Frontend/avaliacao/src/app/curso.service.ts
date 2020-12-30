import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Curso } from './curso';
import { HttpErrorResponse } from '@angular/common/http';
import { catchError, retry } from 'rxjs/operators'
import { throwError } from 'rxjs';




@Injectable({
  providedIn: 'root'
})
export class CursoService {

  private baseURL = "http://localhost:8080/api/cursos";

  constructor(private httpClient: HttpClient ) { }


  // Metodos para mapeamento das apis

  getCursosList(): Observable<Curso[]>{
    return this.httpClient.get<Curso[]>(`${this.baseURL}`);
  }

  createCurso(curso: Curso): Observable <Object>{
    return this.httpClient.post(`${this.baseURL}`,curso ).pipe(
      catchError(error => {   
          this.handleError(error);
          return throwError(error);
      })
  );
  
  }

  
  getCursoById(cod_curso: number): Observable<Curso>{
    return this.httpClient.get<Curso>(`${this.baseURL}/${cod_curso}`);
  }

  updateCurso (cod_curso: number, curso: Curso): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}`, curso).pipe(
      catchError(error => {   
          this.handleError(error);
          return throwError(error);
      })
  );
    
  }

  deleteCurso(cod_curso:number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${cod_curso}`);
  }
  

   //Mapeando o erro para trazer do back as datas invalidas

  private handleError(error: HttpErrorResponse): string{
     
    switch (error.status) {
      
      case 404: {
           alert(error.error);
      }
      default: {
      }
    }
    return error.message;    
  }

}
