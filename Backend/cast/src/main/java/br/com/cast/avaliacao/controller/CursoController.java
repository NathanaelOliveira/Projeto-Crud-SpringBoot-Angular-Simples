package br.com.cast.avaliacao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.cast.avaliacao.model.Curso;
import br.com.cast.avaliacao.service.CursoService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CursoController {
	
	
	@Autowired
	private CursoService cursoService;
	

	//Pegando todos os cursos e enviando para a classe cursoServices no método buscarTodosCursos
	@GetMapping("/cursos")
	public List<Curso> buscarCurso() {
		return cursoService.buscarTodosCursos();	
	}
	
	//Pegando cursos pelo cod_curso e enviando para a classe CursoService no método BuscarPorCodigo
	@GetMapping (value = "/cursos/{cod_curso}")
	public Optional<Curso> BuscarCursoCod(@PathVariable("cod_curso")Integer cod_curso) {
		return cursoService.BuscarPorCodigo(cod_curso);
	}
	

	//Realiza a tentativa cadastro de cursos, e envia para o metodo salvarCurso lá na classe CursoService
	@PostMapping (path = "/cursos")
	public ResponseEntity<String> salvarCurso (@RequestBody Curso curso) {
		try {			
			return cursoService.salvarCurso(curso);	
		}  catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	//Envia os dados para atualizar o cadastro de cursos no método salvaCurso lá classe CursoService
	@PutMapping (path = "/cursos")
	 public ResponseEntity<String> atualizarCurso(@RequestBody Curso curso) {
	    	try {
	    		return cursoService.salvarCurso(curso);    			
	    	}  catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	    }
	
	//Envia os dados para deletar um curso no método deletarCurso lá na classe no CursoService
    @DeleteMapping(path = "/cursos/{cod_curso}")
    public int deletarCurso(@PathVariable("cod_curso") Integer cod_curso) {
    	return cursoService.deletarCurso(cod_curso);
    }
    
  
   }


   
    
 
	
	

	
	
	

		
		
	