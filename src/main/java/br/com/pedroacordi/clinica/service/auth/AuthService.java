package br.com.pedroacordi.clinica.service.auth;

import br.com.pedroacordi.clinica.dao.UserDAO;
import br.com.pedroacordi.clinica.model.User;
import br.com.pedroacordi.clinica.security.Token;
import br.com.pedroacordi.clinica.security.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AuthService implements IAuthService{

    @Autowired
    private UserDAO dao;

    @Override
    public User create(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        String newPassword = encoder.encode(user.getPassword());
        user.setPassword(newPassword);

        return dao.save(user);
    }

    @Override
    public Token login(User user) {
        User res  = dao.findByLogin(user.getLogin());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return (res != null && encoder.matches(user.getPassword(), res.getPassword()))
                ? TokenUtil.encode(res)
                : null;
    }
}
