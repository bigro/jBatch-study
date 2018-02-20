package hello;

import org.apache.ibatis.annotations.*;

@Mapper
public interface StatusMapper {
    @Insert("INSERT INTO status_after (status) VALUES (#{status})")
    void insert(@Param("status") String status);

    @Results(id = "status", value = {
            @Result(property = "status", column = "status"),
            @Result(property = "id", column = "id")})
    @Select("SELECT id, status FROM status ORDER BY id")
    Status selectAll();

}
