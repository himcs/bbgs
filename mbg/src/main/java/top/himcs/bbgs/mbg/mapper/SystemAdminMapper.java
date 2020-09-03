package top.himcs.bbgs.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.himcs.bbgs.mbg.model.SystemAdmin;
import top.himcs.bbgs.mbg.model.SystemAdminExample;

public interface SystemAdminMapper {
    long countByExample(SystemAdminExample example);

    int deleteByExample(SystemAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemAdmin record);

    int insertSelective(SystemAdmin record);

    List<SystemAdmin> selectByExample(SystemAdminExample example);

    SystemAdmin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemAdmin record, @Param("example") SystemAdminExample example);

    int updateByExample(@Param("record") SystemAdmin record, @Param("example") SystemAdminExample example);

    int updateByPrimaryKeySelective(SystemAdmin record);

    int updateByPrimaryKey(SystemAdmin record);
}