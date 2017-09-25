package com.nameof.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Client {
	public static void main(String[] args) {
		RedisTimer rt = new RedisTimer();
		rt.start();
		final SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss:SSS");
		for (int i = 0; i < 2; i++) {
			System.out.println(s.format(new Date()) + "提交任务！" );
			rt.addTask(new Task() {
				
				@Override
				public void run() {
					System.out.println(s.format(new Date()) + "执行了！");
				}
			}, 10, TimeUnit.SECONDS);
		}
	}
}
