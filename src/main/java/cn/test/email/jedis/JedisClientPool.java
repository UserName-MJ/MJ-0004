package cn.test.email.jedis;

import java.util.List;

import java.util.Map;
import java.util.Set;



import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


public class JedisClientPool implements JedisClient{
	/*
	 * 单节点使用redis
	 */

	private JedisPool jedisPool=new JedisPool();
	

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	@Override
	public String set(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.set(key, value);
		jedis.close();
		return result;
	}

	@Override
	public String get(String key) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.get(key);
		jedis.close();
		return result;
	}

	@Override
	public Boolean exists(String key) {
		Jedis jedis = jedisPool.getResource();
		Boolean result = jedis.exists(key);
		jedis.close();
		return result;
	}

	@Override
	public Long expire(String key, int seconds) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.expire(key, seconds);
		jedis.close();
		return result;
	}

	@Override
	public Long ttl(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.ttl(key);
		jedis.close();
		return result;
	}

	@Override
	public Long incr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.incr(key);
		jedis.close();
		return result;
	}

	@Override
	public Long hset(String key, String field, String value) {
		if(jedisPool==null){
			System.out.println("redis是null");
			return null;
		}
		Jedis jedis = jedisPool.getResource();
		if(jedis!=null){
			Long result = jedis.hset(key, field, value);
			jedis.close();
			return result;
		}else{
			System.out.println("redis是null");
			return null;
		}
	}

	@Override
	public String hget(String key, String field) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.hget(key,field);
		jedis.close();
		return result;
	}

	@Override
	public Long hdel(String key, String... field) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hdel(key, field);
		jedis.close();
		return result;
	}

	@Override
	public Long persist(String key) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.persist(key);
		jedis.close();
		return result;
	}

	@Override
	public Long del(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.del(key);
		jedis.close();
		return result;
	}

	@Override
	public Long hlen(String key) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hlen(key);
		jedis.close();
		return result;
	}

	@Override
	public Boolean hexists(String key, String field) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		Boolean result = jedis.hexists(key,field);
		jedis.close();
		return result;
	}

	@Override
	public Set<String> hkeys(String key) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		Set<String> result = jedis.hkeys(key);
		jedis.close();
		return result;
	}

	@Override
	public List<String> hvals(String key) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		List<String> result = jedis.hvals(key);
		jedis.close();
		return result;
	}

	@Override
	public Map<String, String> hgetAll(String key) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		Map<String, String> result = jedis.hgetAll(key);
		jedis.close();
		return result;
	}

	@Override
	public Long rpush(String key, String... string) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.rpush(key,string);
		jedis.close();
		return result;
	}

	@Override
	public Long lpush(String key, String... string) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.lpush(key,string);
		jedis.close();
		return result;
	}

	@Override
	public Long llen(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> lrange(String key, long start, long end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ltrim(String key, long start, long end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String lindex(String key, long index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String lset(String key, long index, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long lrem(String key, long count, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String lpop(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String rpop(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long sadd(String key, String... member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> smembers(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean sismember(String key, String member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long srem(String key, String... member) {
		// TODO Auto-generated method stub
		return null;
	}

}
