package org.example.week4.day21.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
  public static void main(String[] args) {
//	test01();
//	test02();
//	test03();
//	test04();
	test05();
	
}

  //鍛ㄦ湡鎬ф墽琛屼换鍔�
  private static void test05() {
	  //鍒涘缓涓�涓畾闀跨嚎绋嬫睜锛屾敮鎸佸畾鏃跺強鍛ㄦ湡鎬т换鍔℃墽琛�
  ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);
  ses.scheduleAtFixedRate(new Runnable() {
	
	@Override
	public void run() {
		System.out.println("寤惰繜1绉掑悗姣�3绉掓墽琛屼竴娆′换鍔�"+Thread.currentThread().getName());
		
	}
}, 1, 3, TimeUnit.SECONDS);
}

//newScheduleThreadPool鍒涘缓涓�涓畾闀跨嚎绋嬫睜锛屾敮鎸佸畾鏃跺強鍛ㄦ湡鎬т换鍔℃墽琛屄�
  private static void test04() {
	  //鍒涘缓涓�涓畾闀跨嚎绋嬫睜锛屾敮鎸佸畾鏃跺強鍛ㄦ湡鎬т换鍔℃墽琛�
  ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);
   //鎵ц浠诲姟
  ses.schedule(new Runnable() {
	@Override
	public void run() {
		System.out.println("寤惰繜3绉�");
	}
}, 3, TimeUnit.SECONDS);
}

//newSingleThreadExecutor鍒涘缓涓�涓崟绾跨▼鍖栫殑绾跨▼姹狅紝瀹冨彧浼氱敤鍞竴鐨勫伐浣滅嚎绋嬫潵鎵ц浠诲姟銆�
  private static void test03() {
	//newSingleThreadExecutor鍒涘缓涓�涓崟绾跨▼鍖栫殑绾跨▼姹狅紝瀹冨彧浼氱敤鍞竴鐨勫伐浣滅嚎绋嬫潵鎵ц浠诲姟銆�
	ExecutorService es =  Executors.newSingleThreadExecutor();
	 for (int i = 1; i <=5; i++) {
			int index = i;
			es.execute(new Runnable() {   //鎵ц浠诲姟
				@Override
				public void run() {
				System.out.println("绗�"+index+"涓嚎绋�"+Thread.currentThread().getName()); 
					  try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
			});
		}
}


//newFixedThreadPool鍒涘缓涓�涓彲閲嶇敤鍥哄畾涓暟鐨勭嚎绋嬫睜
  private static void test02() {
	//newFixedThreadPool鍒涘缓涓�涓彲閲嶇敤鍥哄畾涓暟鐨勭嚎绋嬫睜  
    ExecutorService es = Executors.newFixedThreadPool(3);	
    
    //缁撴灉瑙ｆ瀽锛氱敱浜庤缃渶澶х嚎绋嬫暟涓�3锛屾墍浠ュ湪杈撳嚭涓変釜鏁板悗绛夊緟1s鎵嶇户缁緭鍑�
    for (int i = 1; i <=20; i++) {
		int index = i;
		es.execute(new Runnable() {   //鎵ц浠诲姟
			@Override
			public void run() {
				System.out.println("绗�"+index+"涓嚎绋�"+Thread.currentThread().getName()); 
				  try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		});
	}
  }


/*
   newCachedThreadPool鍒涘缓涓�涓彲缂撳瓨绾跨▼姹狅紝鍏堟煡鐪嬫睜涓湁娌℃湁浠ュ墠寤虹珛鐨勭嚎绋嬶紝
       濡傛灉鏈夛紝灏辩洿鎺ヤ娇鐢ㄣ�傚鏋滄病鏈夛紝灏卞缓涓�涓柊鐨勭嚎绋嬪姞鍏ユ睜涓�
   * 
   */
private static void test01() {
	//鍒涘缓涓�涓彲缂撳瓨鐨勭嚎绋嬫睜
   ExecutorService es1 = Executors.newCachedThreadPool();	
  //鎵ц5娆′换鍔�
   for (int i = 1; i <=5; i++) {
	   int index = i;
		try {
			Thread.sleep(2000);  //浼戠湢2绉�
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	   //鍐呴儴绫�---new Runnable(){run{}}鐩稿綋浜� 鑷畾涔夌被瀹炵幇Runnable鎺ュ彛閲嶅啓run鏂规硶
//	   es1.execute(new MyThread());
	   es1.execute(new Runnable() {   //绛変环浜巈s1.execute(new MyThread());
			@Override
			public void run() {
				System.out.println("绗�"+index+"涓嚎绋�"+Thread.currentThread().getName()); 
			}
		});
   }
}
}

/*class MyThread implements Runnable{

	@Override
	public void run() {
		System.out.println("绾跨▼"+Thread.currentThread().getName()); 
	}
	
}*/
