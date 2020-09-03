package top.himcs.bbgs.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SystemAdmin implements Serializable {
    @ApiModelProperty(value = "管理员ID")
    private Integer id;

    @ApiModelProperty(value = "后台管理员账号")
    private String account;

    @ApiModelProperty(value = "密码")
    private String pwd;

    @ApiModelProperty(value = "后台管理员状态 1有效0无效")
    private Boolean status;

    private Byte isDel;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", account=").append(account);
        sb.append(", pwd=").append(pwd);
        sb.append(", status=").append(status);
        sb.append(", isDel=").append(isDel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}