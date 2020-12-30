package br.com.cast.avaliacao.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;

@Data
@Entity
@Table (name = "curso", schema = "banco")
public class Curso {

	 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name ="cod_curso")
	private Integer cod_curso;
	
	
	@Column (name ="descricao")
	private String descricao;
	
	@Column (name ="data_inicio")
	private  LocalDate data_inicio;
	
	@Column (name ="data_termino")
	private  LocalDate data_termino;
	
	@Column (name ="quantidade_pessoas")
	private int quantidade_pessoas;
	
	@Column (name ="categoria")
	private int categoria;

	
	
	
	
	
	
}
