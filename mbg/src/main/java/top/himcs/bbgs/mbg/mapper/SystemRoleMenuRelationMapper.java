package top.himcs.bbgs.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.himcs.bbgs.mbg.model.SystemRoleMenuRelation;
import top.himcs.bbgs.mbg.model.SystemRoleMenuRelationExample;

public interface SystemRoleMenuRelationMapper {
    long countByExample(SystemRoleMenuRelationExample example);

    int deleteByExample(SystemRoleMenuRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemRoleMenuRelation record);

    int insertSelective(SystemRoleMenuRelation record);

    List<SystemRoleMenuRelation> selectByExample(SystemRoleMenuRelationExample example);

    SystemRoleMenuRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemRoleMenuRelation record, @Param("example") SystemRoleMenuRelationExample example);

    int updateByExample(@Param("record") SystemRoleMenuRelation record, @Param("example") SystemRoleMenuRelationExample example);

    int updateByPrimaryKeySelective(SystemRoleMenuRelation record);

    int updateByPrimaryKey(SystemRoleMenuRelation record);
}