package com.lg.zzq.bia.web.common.db;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 单例模式
 * @author zzq_eason
 *
 */
public class AppContext {

	// 此处加入volatile，当值改变立即更新
	private static volatile AppContext instance = null;
	private static String[] paths = { "applicationContext.xml" };
	private AbstractApplicationContext appContext;

	public static AppContext getIntstance() {

		if (instance == null) {
			synchronized (AppContext.class) {
				if (instance == null) {
					instance = new AppContext();
				}
			}
		}
		return instance;
	}

	private AppContext() {
		this.appContext = new ClassPathXmlApplicationContext(paths);
	}

	public AbstractApplicationContext getAppContext() {
		return appContext;
	}
}
