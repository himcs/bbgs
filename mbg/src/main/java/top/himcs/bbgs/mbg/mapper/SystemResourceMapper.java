package top.himcs.bbgs.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.himcs.bbgs.mbg.model.SystemResource;
import top.himcs.bbgs.mbg.model.SystemResourceExample;

public interface SystemResourceMapper {
    long countByExample(SystemResourceExample example);

    int deleteByExample(SystemResourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemResource record);

    int insertSelective(SystemResource record);

    List<SystemResource> selectByExample(SystemResourceExample example);

    SystemResource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemResource record, @Param("example") SystemResourceExample example);

    int updateByExample(@Param("record") SystemResource record, @Param("example") SystemResourceExample example);

    int updateByPrimaryKeySelective(SystemResource record);

    int updateByPrimaryKey(SystemResource record);
}