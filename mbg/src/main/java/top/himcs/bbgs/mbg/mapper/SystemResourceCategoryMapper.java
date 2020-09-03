package top.himcs.bbgs.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.himcs.bbgs.mbg.model.SystemResourceCategory;
import top.himcs.bbgs.mbg.model.SystemResourceCategoryExample;

public interface SystemResourceCategoryMapper {
    long countByExample(SystemResourceCategoryExample example);

    int deleteByExample(SystemResourceCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemResourceCategory record);

    int insertSelective(SystemResourceCategory record);

    List<SystemResourceCategory> selectByExample(SystemResourceCategoryExample example);

    SystemResourceCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemResourceCategory record, @Param("example") SystemResourceCategoryExample example);

    int updateByExample(@Param("record") SystemResourceCategory record, @Param("example") SystemResourceCategoryExample example);

    int updateByPrimaryKeySelective(SystemResourceCategory record);

    int updateByPrimaryKey(SystemResourceCategory record);
}