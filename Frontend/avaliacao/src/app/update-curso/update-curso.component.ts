import { Component, OnInit } from '@angular/core';
import { Curso } from '../curso';
import {CursoService} from '../curso.service'
import {ActivatedRoute, Router} from '@angular/router'

@Component({
  selector: 'app-update-curso',
  templateUrl: './update-curso.component.html',
  styleUrls: ['./update-curso.component.css']
})
export class UpdateCursoComponent implements OnInit {

  cod_curso: number;
  curso: Curso = new Curso();
  constructor(private cursoService: CursoService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.cod_curso = this.route.snapshot.params['cod_curso'];

    this.cursoService.getCursoById(this.cod_curso).subscribe(data => {
      this.curso = data;

    }, error => console.log(error) );
  }

  onSubmit(){
    this.cursoService.updateCurso(this.cod_curso, this.curso).subscribe( data =>{
      this.goToCursoList();

    }, error => console.log(error));
  
  }   
  goToCursoList(){

    this.router.navigate(['/cursos']);

  }

}
