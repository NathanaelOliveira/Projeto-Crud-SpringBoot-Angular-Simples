import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateCursoComponent } from './create-curso/create-curso.component';
import { CursoListComponent } from './curso-list/curso-list.component';
import { UpdateCursoComponent } from './update-curso/update-curso.component';

const routes: Routes = [
  {path:'cursos', component: CursoListComponent},
  {path: 'create-curso', component: CreateCursoComponent },
  {path:'', redirectTo: 'cursos', pathMatch: 'full'},
  {path:'update-curso/:cod_curso', component: UpdateCursoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
