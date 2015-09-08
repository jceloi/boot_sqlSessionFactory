package test.jce.persistence.user.dao.mapper;

import test.jce.persistence.authentication.model.IdentificationDb;
import test.jce.persistence.user.model.UserDb;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**.
 */
public interface UserMapper {


    String INSERT_USER = "insert into users (first_name, last_name, nick_name, token, usac_id)\n" +
            "        values (#{firstName}, #{lastName}, #{nickName}, #{token}, #{identificationInformations.id})";

    String GET_USER = "select user_id as id, first_name as firstName, last_name as lastName, nick_name as nickName,\n" +
            "               token as token\n" +
            "        from users\n" +
            "        where usac_id = #{id}";


    @Select(GET_USER)
    UserDb getUser(IdentificationDb identificationDb);

    @Insert(INSERT_USER)
    @Options(useGeneratedKeys = true)
    int saveUser(UserDb userDb);
}
