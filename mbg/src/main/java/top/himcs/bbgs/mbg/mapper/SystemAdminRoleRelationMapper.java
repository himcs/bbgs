package top.himcs.bbgs.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.himcs.bbgs.mbg.model.SystemAdminRoleRelation;
import top.himcs.bbgs.mbg.model.SystemAdminRoleRelationExample;

public interface SystemAdminRoleRelationMapper {
    long countByExample(SystemAdminRoleRelationExample example);

    int deleteByExample(SystemAdminRoleRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemAdminRoleRelation record);

    int insertSelective(SystemAdminRoleRelation record);

    List<SystemAdminRoleRelation> selectByExample(SystemAdminRoleRelationExample example);

    SystemAdminRoleRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemAdminRoleRelation record, @Param("example") SystemAdminRoleRelationExample example);

    int updateByExample(@Param("record") SystemAdminRoleRelation record, @Param("example") SystemAdminRoleRelationExample example);

    int updateByPrimaryKeySelective(SystemAdminRoleRelation record);

    int updateByPrimaryKey(SystemAdminRoleRelation record);
}