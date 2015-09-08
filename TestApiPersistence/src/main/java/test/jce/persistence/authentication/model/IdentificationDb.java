package test.jce.persistence.authentication.model;

import java.util.Date;

/**
 */
public class IdentificationDb {

    /**
     * Login de l'utilisateur.
     */
    private String login;

    private String password;

    private String token;

    private Integer id;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
