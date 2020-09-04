package top.himcs.bbgs.common.exception;

import top.himcs.bbgs.common.api.ResultCode;

public class CommonException extends RuntimeException {
    private ResultCode code;
    private String info;

    public CommonException(String info) {
        this(ResultCode.FAILED, info);
    }

    public CommonException(ResultCode code, String info) {
        this.code = code;
        this.info = info;
    }

    public ResultCode getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
