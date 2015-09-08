package test.jce.persistence.user.model;

import test.jce.persistence.authentication.model.IdentificationDb;

/**
 */
public class UserDb {

    private Integer id;

    private String firstName;

    private String lastName;

    private String nickName;

    private String token;
    
    private IdentificationDb identificationInformations = new IdentificationDb();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickname) {
        this.nickName = nickname;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public IdentificationDb getIdentificationInformations() {
        return identificationInformations;
    }

    public void setIdentificationInformations(IdentificationDb identificationInformations) {
        this.identificationInformations = identificationInformations;
    }
}
