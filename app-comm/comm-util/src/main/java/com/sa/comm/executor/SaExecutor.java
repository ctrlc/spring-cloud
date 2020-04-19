package com.sa.comm.executor;

import java.util.concurrent.*;

/**
 * 线程池
 */
public class SaExecutor {

	private static ExecutorService es = null;

	static {
		int minThreadNum = 5;
		int maxThreadNum = Runtime.getRuntime().availableProcessors();
		if(maxThreadNum < minThreadNum) minThreadNum = maxThreadNum;
		es = new ThreadPoolExecutor(minThreadNum, maxThreadNum, 60L,
				TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
	}

	public static void submit(SaExecutor.QueryTask task){
		es.submit(task);
	}

	public static void submit(Runnable task){
		es.submit(task);
	}


	public static interface QueryHandler{
		void doQuery();
	}

	public static class QueryTask implements Runnable {
		private SaExecutor.QueryHandler queryHandler;
		private CountDownLatch cdl;
		public QueryTask(CountDownLatch cdl, QueryHandler queryHandler){
			this.cdl = cdl;
			this.queryHandler = queryHandler;
		}
		public void run() {
			try{
				this.queryHandler.doQuery();
			}catch(Exception ex){

			}
			this.cdl.countDown();
		}
	}
}



