package top.himcs.bbgs.common.service;

public interface RedisService {
    /**
     * 存储数据
     */
    void set(String key, Object value);

    /**
     * 获取数据
     */
    Object get(String key);

    /**
     * 设置超期时间
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     * @return
     */
    Boolean remove(String key);

    /**
     * 自增操作
     *
     * @param delta 自增步长
     */
    Long increment(String key, long delta);
}
