package test.jce.persistence.authentication.dao.mapper;

import test.jce.persistence.authentication.model.IdentificationDb;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * Created by jean-charles_eloi on 06/07/15.
 */
public interface AuthenticationMapper {

    String AUTHENTICATE = "select usac_id as id, login as login, password as password\n" +
            "        from authentication_users where login = #{login} and password = #{password}";

    String CREATE_AUTHENTICATION = "insert into authentication_users (login, password)\n" +
            "        values (#{login}, #{password})";

    @Select(AUTHENTICATE)
    IdentificationDb authenticate(Map<String, Object> parameters);

    @Insert(CREATE_AUTHENTICATION)
    @Options(useGeneratedKeys = true)
    void createAuthentication(IdentificationDb identificationDb);


}
