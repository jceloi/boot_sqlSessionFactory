package test.jce.persistence.authentication.dao;

import test.jce.persistence.authentication.model.IdentificationDb;

/**
 */
public interface AuthenticationDao {

    /**
     *
     * @param login
     * @param password
     * @return
     */
    IdentificationDb createAuthentication(final String login, final String password);

    /**
     *
     * @param login
     * @param password
     * @return
     */
    IdentificationDb authenticate(final String login, final String password);

}
