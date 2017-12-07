package cn.test.email.jedis;

import java.util.List;

import java.util.Map;
import java.util.Set;

public interface JedisClient {

	String set(String key, String value);
	String get(String key);
	Boolean exists(String key);
	Long expire(String key, int seconds);
	Long ttl(String key);
	Long incr(String key);
	Long hset(String key, String field, String value);
	String hget(String key, String field);
	Long hdel(String key, String... field);
	Long persist(final String key);
	Long del(final String key);
	Long hlen(final String key);
	Boolean hexists(final String key, final String field);
	Set<String> hkeys(final String key);
	List<String> hvals(final String key);
	Map<String, String> hgetAll(final String key);
	Long rpush(final String key, final String... string);
	Long lpush(final String key, final String... string);
	Long llen(final String key);
	List<String> lrange(final String key, final long start, final long end);
	String ltrim(final String key, final long start, final long end);
	String lindex(final String key, final long index);
	String lset(final String key, final long index, final String value);
	Long lrem(final String key, final long count, final String value);
	 String lpop(final String key);
	 String rpop(final String key);
	 Long sadd(final String key, final String... member);
	 Set<String> smembers(final String key);
	 Boolean sismember(final String key, final String member);
	 Long srem(final String key, final String... member);
	
}
