package br.com.cast.avaliacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.avaliacao.model.Categoria;
import br.com.cast.avaliacao.repository.CategoriaRepository;

@RestController
@RequestMapping("categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<Categoria> listar() {
		List <Categoria> categorias = categoriaRepository.findAll();
		return categorias;
		
		
	}
	
	

}
