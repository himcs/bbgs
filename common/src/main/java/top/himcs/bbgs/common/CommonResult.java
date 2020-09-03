package top.himcs.bbgs.common;

/**
 * API 返回对象
 */
public class CommonResult<T> {
    private long code;
    private String info;
    private T data;

    protected CommonResult() {

    }

    public CommonResult(long code, String info, T data) {
        this.code = code;
        this.info = info;
        this.data = data;
    }


    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getInfo(), data);
    }

    public static <T> CommonResult<T> failed(T data) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), ResultCode.SUCCESS.getInfo(), data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
