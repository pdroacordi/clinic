package br.com.pedroacordi.clinica.dao;

import br.com.pedroacordi.clinica.model.Media;
import org.springframework.data.repository.CrudRepository;

public interface MediaDAO extends CrudRepository<Media, Integer> {
}
