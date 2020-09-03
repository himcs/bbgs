package top.himcs.bbgs.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.himcs.bbgs.mbg.model.SystemAdmin;
import top.himcs.bbgs.mbg.model.SystemAdminExample;

public interface SystemAdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_admin
     *
     * @mbg.generated Thu Sep 03 13:43:58 CST 2020
     */
    long countByExample(SystemAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_admin
     *
     * @mbg.generated Thu Sep 03 13:43:58 CST 2020
     */
    int deleteByExample(SystemAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_admin
     *
     * @mbg.generated Thu Sep 03 13:43:58 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_admin
     *
     * @mbg.generated Thu Sep 03 13:43:58 CST 2020
     */
    int insert(SystemAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_admin
     *
     * @mbg.generated Thu Sep 03 13:43:58 CST 2020
     */
    int insertSelective(SystemAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_admin
     *
     * @mbg.generated Thu Sep 03 13:43:58 CST 2020
     */
    List<SystemAdmin> selectByExample(SystemAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_admin
     *
     * @mbg.generated Thu Sep 03 13:43:58 CST 2020
     */
    SystemAdmin selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_admin
     *
     * @mbg.generated Thu Sep 03 13:43:58 CST 2020
     */
    int updateByExampleSelective(@Param("record") SystemAdmin record, @Param("example") SystemAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_admin
     *
     * @mbg.generated Thu Sep 03 13:43:58 CST 2020
     */
    int updateByExample(@Param("record") SystemAdmin record, @Param("example") SystemAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_admin
     *
     * @mbg.generated Thu Sep 03 13:43:58 CST 2020
     */
    int updateByPrimaryKeySelective(SystemAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_admin
     *
     * @mbg.generated Thu Sep 03 13:43:58 CST 2020
     */
    int updateByPrimaryKey(SystemAdmin record);
}