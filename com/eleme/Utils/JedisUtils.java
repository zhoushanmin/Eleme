package com.eleme.Utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {

	private static JedisPoolConfig jPoolConfig;
	private static JedisPool jPool;
	
	static {
		jPoolConfig = new JedisPoolConfig();
		jPoolConfig.setMaxTotal(30);
		jPoolConfig.setMaxIdle(2);
		
		jPool = new JedisPool(jPoolConfig, "192.168.136.128", 6379);
	}
	
	public static Jedis getJedis() {
		return jPool.getResource();
	}
	
	public static void closeJedis(Jedis jedis) {
		jedis.close();
	}
	
}
