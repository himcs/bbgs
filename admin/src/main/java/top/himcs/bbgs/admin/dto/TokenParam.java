package top.himcs.bbgs.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class TokenParam {
    @NotEmpty
    @ApiModelProperty(value = "Token", required = true, example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmcifQ.jMqkp-5bN32Vwnnm18wSotHtSE-XNu82Fz0mFMgm5Gc")
    private String token;
}
