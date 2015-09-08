package test.jce.persistence.authentication.dao.impl;

import test.jce.persistence.authentication.dao.AuthenticationDao;
import test.jce.persistence.authentication.dao.mapper.AuthenticationMapper;
import test.jce.persistence.authentication.model.IdentificationDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Service
public class AuthenticationDaoImpl implements AuthenticationDao {

    @Autowired
    AuthenticationMapper mapper;

    @Override
    public IdentificationDb createAuthentication(String login, String password) {
        // Construction de l'objet db pour le mapping
        final IdentificationDb identification = new IdentificationDb();
        identification.setLogin(login);
        identification.setPassword(password);

        mapper.createAuthentication(identification);

        return identification;
    }

    @Override
    public IdentificationDb authenticate(String login, String password) {
        final Map<String, Object> parameters = new HashMap<>();

        parameters.put("login", login);
        parameters.put("password", password);

        final IdentificationDb identification = mapper.authenticate(parameters);

        return identification;
    }

    public void setAuthenticationMapper(AuthenticationMapper mapper) {
        this.mapper = mapper;
    }
}
