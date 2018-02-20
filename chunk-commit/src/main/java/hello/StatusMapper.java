package hello;

import org.apache.ibatis.annotations.*;

@Mapper
public interface StatusMapper {
    @Insert("INSERT INTO status_after (status) VALUES (#{status})")
    void insert(@Param("status") String status);

    @Results(id = "status", value = {@Result(property = "status", column = "status")})
    @Select("SELECT status FROM status")
    Status selectAll();

}
