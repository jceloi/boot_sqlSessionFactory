package test.jce.persistence.user.dao.impl;

import test.jce.persistence.authentication.model.IdentificationDb;
import test.jce.persistence.user.dao.mapper.UserMapper;
import test.jce.persistence.user.model.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 */
@Service
public class UserDaoImpl{

    @Autowired
    UserMapper mapper;

    public void saveUser(UserDb user) {
        mapper.saveUser(user);
    }

    public UserDb getUser(IdentificationDb identification) {
        final UserDb user = mapper.getUser(identification);

        user.setIdentificationInformations(identification);

        return user;
    }


    public void setUserMapper(UserMapper mapper) {
        this.mapper = mapper;
    }
}
