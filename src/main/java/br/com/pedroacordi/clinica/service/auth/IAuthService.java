package br.com.pedroacordi.clinica.service.auth;

import br.com.pedroacordi.clinica.model.User;
import br.com.pedroacordi.clinica.security.Token;

public interface IAuthService {
    public User create(User user);
    public Token login(User user);
}
