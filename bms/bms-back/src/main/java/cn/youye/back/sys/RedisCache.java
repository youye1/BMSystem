package cn.youye.back.sys;

import cn.youye.back.sys.utils.SpringContextHolder;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by pc on 2016/9/20.
 */
public class RedisCache implements Cache {

    private String keyPrefix;
    private Logger logger= LoggerFactory.getLogger(RedisCache.class);

    //读写锁
    private final  ReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    private String id;
    public RedisCache(final String id){

        if (id==null ||id==""){
            throw new IllegalArgumentException("必须传入ID");
        }
        logger.debug("MybatisRedisCache:id="+id);
        this.id=id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getSize() {

        Jedis jedis = null;
        JedisPool jedisPool = null;
        int result = 0;
        boolean borrowOrOprSuccess = true;
        try {
            jedis   = CachePool.getInstance().getJedis();
            jedisPool = CachePool.getInstance().getJedisPool();
            result = Integer.valueOf(jedis.dbSize().toString());
        } catch (JedisConnectionException e) {
            borrowOrOprSuccess = false;
            if (jedis != null)
                jedisPool.returnBrokenResource(jedis);
        } finally {
            if (borrowOrOprSuccess)
                jedisPool.returnResource(jedis);
        }
        return result;

    }

    @Override
    public void putObject(Object key, Object value) {

        if(logger.isDebugEnabled())
            logger.debug("putObject:" + key.hashCode() + "=" + value);
        if(logger.isInfoEnabled())
            logger.info("put to redis sql :" +key.toString());
        Jedis jedis = null;
        JedisPool jedisPool = null;
        boolean borrowOrOprSuccess = true;
        try {
            jedis   = CachePool.getInstance().getJedis();
            jedisPool = CachePool.getInstance().getJedisPool();
            jedis.set(SerializeUtil.serialize(key.hashCode()), SerializeUtil.serialize(value));
        } catch (JedisConnectionException e) {
            borrowOrOprSuccess = false;
            if (jedis != null)
                jedisPool.returnBrokenResource(jedis);
        } finally {
            if (borrowOrOprSuccess)
                jedisPool.returnResource(jedis);
        }

    }

    @Override
    public Object getObject(Object key) {

        Jedis jedis = null;
        JedisPool jedisPool = null;
        Object value = null;
        boolean borrowOrOprSuccess = true;
        try {
            jedis   = CachePool.getInstance().getJedis();
            jedisPool = CachePool.getInstance().getJedisPool();
            value  = SerializeUtil.unserialize(jedis.get(SerializeUtil.serialize(key.hashCode())));
        } catch (JedisConnectionException e) {
            borrowOrOprSuccess = false;
            if (jedis != null)
                jedisPool.returnBrokenResource(jedis);
        } finally {
            if (borrowOrOprSuccess)
                jedisPool.returnResource(jedis);
        }
        if(logger.isDebugEnabled())
            logger.debug("getObject:" + key.hashCode() + "=" + value);
        return value;
    }

    @Override
    public Object removeObject(Object key) {
        Jedis jedis = null;
        JedisPool jedisPool = null;
        Object value = null;
        boolean borrowOrOprSuccess = true;
        try {
            jedis   = CachePool.getInstance().getJedis();
            jedisPool = CachePool.getInstance().getJedisPool();
            value  = jedis.expire(SerializeUtil.serialize(key.hashCode()), 0);
        } catch (JedisConnectionException e) {
            borrowOrOprSuccess = false;
            if (jedis != null)
                jedisPool.returnBrokenResource(jedis);
        } finally {
            if (borrowOrOprSuccess)
                jedisPool.returnResource(jedis);
        }
        if(logger.isDebugEnabled())
            logger.debug("getObject:" + key.hashCode() + "=" + value);
        return value;
    }

    @Override
    public void clear() {
        Jedis jedis = null;
        JedisPool jedisPool = null;
        boolean borrowOrOprSuccess = true;
        try {
            jedis   = CachePool.getInstance().getJedis();
            jedisPool = CachePool.getInstance().getJedisPool();
            jedis.flushDB();
            jedis.flushAll();
        } catch (JedisConnectionException e) {
            borrowOrOprSuccess = false;
            if (jedis != null)
                jedisPool.returnBrokenResource(jedis);
        } finally {
            if (borrowOrOprSuccess)
                jedisPool.returnResource(jedis);
        }
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }

    /**
     *
     * @ClassName: CachePool
     * @Description: TODO(单例Cache池)
     * @author LiuYi
     * @date 2014年6月17日 上午10:50:52
     *
     */
    public static class CachePool {
        JedisPool pool;
        private static final CachePool cachePool = new CachePool();

        public static CachePool getInstance(){
            return cachePool;
        }
        private CachePool() {
//            JedisPoolConfig config = new JedisPoolConfig();
//            config.setMaxIdle(100);
//            config.setMaxWaitMillis(1000l);
//            PropertiesLoader pl =  new PropertiesLoader("classpath:config/redis.properties");
//            pool = new JedisPool(config,pl.getProperty("redisvip"));
            pool = SpringContextHolder.getBean(JedisPool.class);
        }
        public  Jedis getJedis(){
            Jedis jedis = null;
            boolean borrowOrOprSuccess = true;
            try {
                jedis = pool.getResource();
            } catch (JedisConnectionException e) {
                borrowOrOprSuccess = false;
                if (jedis != null)
                    pool.returnBrokenResource(jedis);
            } finally {
                if (borrowOrOprSuccess)
                    pool.returnResource(jedis);
            }
            jedis = pool.getResource();
            return jedis;
        }

        public JedisPool getJedisPool(){
            return this.pool;
        }

    }

    public static class SerializeUtil {
        public static byte[] serialize(Object object) {
            ObjectOutputStream oos = null;
            ByteArrayOutputStream baos = null;
            try {
                // 序列化
                baos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(baos);
                oos.writeObject(object);
                byte[] bytes = baos.toByteArray();
                return bytes;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public static Object unserialize(byte[] bytes) {
            if(bytes == null)return null;
            ByteArrayInputStream bais = null;
            try {
                // 反序列化
                bais = new ByteArrayInputStream(bytes);
                ObjectInputStream ois = new ObjectInputStream(bais);
                return ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
