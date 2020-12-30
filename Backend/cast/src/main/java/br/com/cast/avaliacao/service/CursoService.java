package br.com.cast.avaliacao.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.cast.avaliacao.model.Curso;
import br.com.cast.avaliacao.repository.CursoRepository;

@Service
public class CursoService {
		
	
	@Autowired
	private CursoRepository cursoRepository;
	
	
	//Metodo para retornar data atual
	public String dataAtual() {
		
	//Pegando data atual e formatando  strDateFormat
		Date date = new Date();
		String strDateFormat = "yyyy-MM-dd";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		return dateFormat.format(date);
	}
	
	
	
	//Metodo para validar 1 regra de negocio
	public boolean primeiraRegra (Curso curso) {

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	 
	    LocalDate localDate = LocalDate.parse(dataAtual(), formatter);
	    
	    // VERIFICANDO SE A DATA INICIO OU FIM ESTÁ SENDO AGENDADA EM UM PERIODO ANTES DA ATUAL 
	    boolean init = curso.getData_inicio().isBefore( localDate );
	    boolean fim = curso.getData_termino().isBefore( localDate );
	    
	    if(init == true || fim == true) {
	    	return false;
	    }
	    
		return true;
	}
	
	//Metodo para validar 2 regra de negocio
	public boolean segundaRegra  (Curso curso) {
		List<Curso> listCurso = cursoRepository.findAll();
		
		for (int i = 0; i < listCurso.size(); i++) {
			System.out.println(listCurso.get(i));
			Curso cursoAux = listCurso.get(i);
			System.out.println(cursoAux.getDescricao());
			
			if(curso.getData_inicio().isAfter(cursoAux.getData_inicio()) && curso.getData_inicio().isBefore(cursoAux.getData_termino()))	
			{
				return false;	
			}	
			else if (curso.getData_termino().isAfter(cursoAux.getData_inicio()) && curso.getData_termino().isBefore(cursoAux.getData_termino())){		
				return false;
			}
			else if (curso.getData_inicio().isBefore(cursoAux.getData_inicio()) && curso.getData_termino().isAfter(cursoAux.getData_termino())){		
				return false;
			}		
			else if (curso.getData_inicio().isEqual(cursoAux.getData_inicio())&& curso.getData_termino().isEqual(cursoAux.getData_termino())) {
				System.out.println(curso.getData_inicio()+"E"+cursoAux.getData_inicio());
				System.out.println(curso.getData_termino()+"E"+cursoAux.getData_termino());
			   return false; 	   
			}
		} 	
			return true; 	
	}
	
	
	//Procurar todos os cursos
	public List<Curso> buscarTodosCursos(){
		List<Curso> listCurso = cursoRepository.findAll();
		return listCurso;	
	}
	
	//Procurar um curso pelo Id específico
	public Optional <Curso> BuscarPorCodigo(@PathVariable(name= "cod_curso", required = true)Integer cod_curso) {
		return cursoRepository.findById(cod_curso);
	}
	
	
	//Salvar um curso
	public ResponseEntity<String> salvarCurso (Curso curso) throws Exception {

	    boolean resultadoPrimeiraRegra = primeiraRegra(curso);
	    
	    if (resultadoPrimeiraRegra) {
	   	 
	    	System.out.println("A data deve ser à partir de hoje");
	    	//Metodo para validar periodos das datas
		    boolean resultadoSegundaRegra = segundaRegra(curso);
		    if (!resultadoSegundaRegra) {
		    	
		    return new ResponseEntity<>("Existe(m) curso(s) planejados(s) dentro do período informado.",HttpStatus.NOT_FOUND);
		   }
		        	
	    }else {
	    	
	    	return new ResponseEntity<>("A data é inferior a de hoje",HttpStatus.NOT_FOUND);
	    }
	    
	    cursoRepository.save(curso);
	    
	    return new ResponseEntity<>(HttpStatus.OK);	
	}
	

	//Deletar curso por ID
	public int deletarCurso(int cod_curso) {
		cursoRepository.deleteById(cod_curso);
		return cod_curso;
	}
	
	



	

	





	
	
	

	
}

	
	

