package br.com.cast.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.cast.avaliacao.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
