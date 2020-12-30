import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Curso } from '../curso';
import { CursoService } from '../curso.service';

@Component({
  selector: 'app-create-curso',
  templateUrl: './create-curso.component.html',
  styleUrls: ['./create-curso.component.css']
})
export class CreateCursoComponent implements OnInit {

 
  curso: Curso = new Curso();

  constructor(private cursoService: CursoService, 
      private router: Router) { }


  ngOnInit(): void {
  }

  // Método para salvar um novo curso validando se todos os valores foram preechidos
  saveCurso(){

   // let resultado: boolean

   // if ((this.curso.descricao = "" ) || (this.curso.data_inicio = "") || (this.curso.data_termino = "") || (this.curso.quantidade_pessoas= null) ||(this.curso.categoria= null)) {
   //   resultado = true;
    //}

   // if (!resultado){

    this.cursoService.createCurso(this.curso).subscribe( data =>{
      console.log(data);
      this.goToCursoList();
      },
      error =>console.error(error));
   // } else{
    //  alert("Preencha todos os campos")
   // }
      
    }


  goToCursoList(){
    this.router.navigate(['/cursos']);
  }

  onSubmit(){
    console.log(this.curso);
    this.saveCurso();
  }

}
