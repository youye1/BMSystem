package cn.youye.back.sys;

import org.apache.ibatis.cache.decorators.LoggingCache;

/**
 * Created by pc on 2016/9/20.
 */
public class LoggingRedisCache extends LoggingCache{

    public LoggingRedisCache(String id) {
        super(new RedisCache(id));
    }
}
