package life.juny.community.mapper;

import life.juny.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description TODO
 * @Author Juny
 * @Date 2021/7/18 22:19
 * @Version 1.0
 */
@Mapper
public interface UserMapper {
  @Insert("insert into USER (ACCOUNT_ID, NAME, TOKEN, GMT_CREATE, GMT_MODIFIED) values(#{accountId}, #{name}, #{token}, #{gmtCreate}, #{gmtModified})")
  public int insert(User user);
}
