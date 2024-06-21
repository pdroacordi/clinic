package br.com.pedroacordi.clinica.model;

import jakarta.persistence.*;

@Entity
@Table(name="USUARIO")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name="NOME", length = 45, nullable = false)
    private String name;

    @Column(name="LOGIN", length = 45, nullable = false)
    private String login;

    @Column(name="SENHA", length = 255, nullable = false)
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
