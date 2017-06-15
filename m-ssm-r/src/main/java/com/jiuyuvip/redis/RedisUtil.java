package com.jiuyuvip.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil implements Cache{
    
    private RedisTemplate<Serializable, Object> redisTemplate;    
    private String name;    
    public RedisTemplate<Serializable, Object> getRedisTemplate() {  
        return redisTemplate;    
    }  
       
    public void setRedisTemplate(RedisTemplate<Serializable, Object> redisTemplate) {  
        this.redisTemplate = redisTemplate;    
    }  
       
    public void setName(String name) {  
        this.name = name;    
    }  
       
    @Override    
    public String getName() {  
        return this.name;    
    }  
  
    @Override    
    public Object getNativeCache() {  
        return this.redisTemplate;    
    }  
    
    private Jedis redisClient = createClient(); 
    protected  static Jedis createClient() {  
        try {  
               JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");  
               return pool.getResource();  
        } catch (Exception e) {  
                e.printStackTrace();  
        }finally{
        	System.out.println("��ʼ�����ӳسɹ�");
        }
        throw new RuntimeException("��ʼ�����ӳش���");  
    }  
    
    /** The ReadWriteLock. */  
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(); 
    public ReadWriteLock getReadWriteLock() {
		// TODO Auto-generated method stub
		 return readWriteLock;  
	}  
    
    private long defaultCacheExpireTime=3600; // ����Ĭ�ϵĹ���ʱ��  
    private long recordManagerTime=60; //  
    private long setRecordManagerTime=60; 
    
    /**
     * �ӻ����л�ȡkey
     */
    @Override    
    public ValueWrapper get(Object key) {  
    	System.out.println(key.toString());
        Object object = null;  
        try {
    	   ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();  
           object = operations.get(key); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        return (object != null ? new SimpleValueWrapper(object) : null);  
      }  
    
     /**
      * ��һ���µ�key���浽������
      * ���õ���Ҫ����key���ƺͶ���Ȼ����ת��ByteArray
      */
     @Override    
     public void put(Object key, Object value) {  
        try {
        	 final String keyf = key.toString();
             final Object valuef = value;  
             final long liveTime = 1000;   
             ValueOperations<Serializable, Object> operations = redisTemplate .opsForValue();  
             operations.set(keyf, valuef);  
             redisTemplate.expire(keyf, liveTime, TimeUnit.SECONDS);  //��λ��SECONDS
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
     }  
  
       
       
       /**
        * ɾ��key
        */
       @Override    
       public void evict(Object key) {    
           final String keyf = key.toString();    
           redisTemplate.delete(keyf);  
        }  
       
        /**
         * ���key
         */
        @Override    
        public void clear() {    
        	 redisClient.flushDB();     
        }  
        
     	public int getSize() {
    		// TODO Auto-generated method stub
    		return Integer.valueOf(redisClient.dbSize().toString());  
    	}
  
         public <T> T get(Object key, Class<T> type) {  
            return null;  
        }  
      
         public ValueWrapper putIfAbsent(Object key, Object value) {  
            return null;  
        }  
      
}