package CallableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


import org.junit.Test;

public class demo1 {
	
	@Test
	public <String> void test1(){
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		Future<String> future = threadPool.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				return (String) "hello";
			}
			
		});		
		
		System.out.println("等待结果");
		try {
			System.out.println("获得结果" + future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
