package ca.ws.cacheDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.junit.Test;

public class CacheDemo {
	
	private Map<String, Object> cache = new HashMap<String,Object>();
	private ReadWriteLock rwl = new ReentrantReadWriteLock();
	
	@Test 
	public /*synchronized*/ Object getData(String key){
		rwl.readLock().lock();
		Object value = null;
		try{
			value = cache.get(key);
			if(value == null){
				rwl.readLock().unlock();
				rwl.writeLock().lock();
				try{
					if(value == null){
						value = "aaaa"; //实际是去queryDB（）
					}
				}finally{
					rwl.writeLock().unlock();
				}
				rwl.readLock().lock();
			}			
		}finally{
			rwl.readLock().unlock(); 
		}
		return value;
	}

}
