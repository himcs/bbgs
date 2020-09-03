package top.himcs.bbgs.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.himcs.bbgs.mbg.model.SystemRoleResourceRelation;
import top.himcs.bbgs.mbg.model.SystemRoleResourceRelationExample;

public interface SystemRoleResourceRelationMapper {
    long countByExample(SystemRoleResourceRelationExample example);

    int deleteByExample(SystemRoleResourceRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemRoleResourceRelation record);

    int insertSelective(SystemRoleResourceRelation record);

    List<SystemRoleResourceRelation> selectByExample(SystemRoleResourceRelationExample example);

    SystemRoleResourceRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemRoleResourceRelation record, @Param("example") SystemRoleResourceRelationExample example);

    int updateByExample(@Param("record") SystemRoleResourceRelation record, @Param("example") SystemRoleResourceRelationExample example);

    int updateByPrimaryKeySelective(SystemRoleResourceRelation record);

    int updateByPrimaryKey(SystemRoleResourceRelation record);
}