package com.jiuyuvip.redis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

import com.jiuyuvip.entity.User;

/**
 * ����redis����
 * @author Administrator
 *
 */
public class RedisJava {
	
   public static void main(String[] args) {
      //���ӱ��ص� Redis ����
      Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
      //�鿴�����Ƿ�����
      System.out.println("Server is running: "+jedis.ping());
      //���� redis �ַ�������
      jedis.set("runoobkey", "Redis tutorial");
      // ��ȡ�洢�����ݲ����
      System.out.println("Stored string in redis:: "+ jedis.get("runoobkey"));
      //�洢���ݵ��б���
      jedis.lpush("tutorial-list", "Redis");
      jedis.lpush("tutorial-list", "Mongodb");
      jedis.lpush("tutorial-list", "Mysql");
      // ��ȡ�洢�����ݲ����
      List<String> list = jedis.lrange("tutorial-list", 0 ,5);
      for(int i=0; i<list.size(); i++) {
       System.out.println("Stored string in redis:: "+list.get(i));
      }
      // ��ȡ���ݲ����
   		Set<String> keys = jedis.keys("*"); 
   		Iterator<String> it=keys.iterator() ;   
   		while(it.hasNext()){   
   			String key = it.next();   
   			System.out.println(key);   
   		}
 }
}