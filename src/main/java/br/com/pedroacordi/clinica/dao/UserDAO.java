package br.com.pedroacordi.clinica.dao;

import br.com.pedroacordi.clinica.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Integer> {
    public User findByLogin(String login);

}
