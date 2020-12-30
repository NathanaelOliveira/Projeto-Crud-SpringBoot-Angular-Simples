package br.com.cast.avaliacao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;



@Data
@Entity
@Table (name = "Categoria", schema = "banco")
public class Categoria {
	
	@Id 
	@Column (name ="codigo")
	private Integer codigo;
	
	@Column (name ="descricao_categoria")
	private String descricao_categoria;

	
	

	
	
}
