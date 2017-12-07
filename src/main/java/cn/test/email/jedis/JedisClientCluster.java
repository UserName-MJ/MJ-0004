package cn.test.email.jedis;

import java.util.List;


import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.JedisCluster;

public class JedisClientCluster  implements JedisClient{
	
	/**
	 * 多节点使用redis
	 * 
	 * Cluster 群
	 * 	 
	   */
	
	@Autowired
	private JedisCluster jedisCluster;

	@Override
	public String set(String key, String value) {
		return jedisCluster.set(key, value);
	}

	@Override
	public String get(String key) {
		return jedisCluster.get(key);
	}

	@Override
	public Boolean exists(String key) {
		return jedisCluster.exists(key);
	}

	@Override
	public Long expire(String key, int seconds) {
		return jedisCluster.expire(key, seconds);
	}

	@Override
	public Long ttl(String key) {
		return jedisCluster.ttl(key);
	}

	@Override
	public Long incr(String key) {
		return jedisCluster.incr(key);
	}

	@Override
	public Long hset(String key, String field, String value) {
		return jedisCluster.hset(key, field, value);
	}

	@Override
	public String hget(String key, String field) {
		return jedisCluster.hget(key, field);
	}

	@Override
	public Long hdel(String key, String... field) {
		return jedisCluster.hdel(key, field);
	}

	@Override
	public Long persist(String key) {
		return jedisCluster.persist(key);
	}

	@Override
	public Long del(String key) {
		return jedisCluster.del(key);
	}

	@Override
	public Long hlen(String key) {
		return jedisCluster.hlen(key);
	}

	@Override
	public Boolean hexists(String key, String field) {
		return jedisCluster.hexists(key, field);
	}

	@Override
	public Set<String> hkeys(String key) {
		return jedisCluster.hkeys(key);
	}

	@Override
	public List<String> hvals(String key) {
		return jedisCluster.hvals(key);
	}

	@Override
	public Map<String, String> hgetAll(String key) {
		return jedisCluster.hgetAll(key);
	}

	@Override
	public Long rpush(String key, String... string) {
		return jedisCluster.rpush(key, string);
	}

	@Override
	public Long lpush(String key, String... string) {
		return jedisCluster.lpush(key, string);
	}

	@Override
	public Long llen(String key) {
		return jedisCluster.llen(key);
	}

	@Override
	public List<String> lrange(String key, long start, long end) {
		return jedisCluster.lrange(key, start, end);
	}

	@Override
	public String ltrim(String key, long start, long end) {
		return jedisCluster.ltrim(key, start, end);
	}

	@Override
	public String lindex(String key, long index) {
		return jedisCluster.lindex(key, index);
	}

	@Override
	public String lset(String key, long index, String value) {
		return jedisCluster.lset(key, index, value);
	}

	@Override
	public Long lrem(String key, long count, String value) {
		return jedisCluster.lrem(key, count, value);
	}

	@Override
	public String lpop(String key) {
		return jedisCluster.lpop(key);
	}

	@Override
	public String rpop(String key) {
		return jedisCluster.rpop(key);
	}

	@Override
	public Long sadd(String key, String... member) {
		return jedisCluster.sadd(key, member);
	}

	@Override
	public Set<String> smembers(String key) {
		return jedisCluster.smembers(key);
	}

	@Override
	public Boolean sismember(String key, String member) {
		return jedisCluster.sismember(key, member);
	}

	@Override
	public Long srem(String key, String... member) {
		return jedisCluster.srem(key, member);
	}

}
