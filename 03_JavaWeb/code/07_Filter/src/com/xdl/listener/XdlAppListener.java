package com.xdl.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class XdlAppListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("应用程序即将消亡");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("应用程序部署完毕");
		
	}

}
