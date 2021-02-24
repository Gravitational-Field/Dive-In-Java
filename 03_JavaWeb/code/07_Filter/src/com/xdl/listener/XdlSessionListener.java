package com.xdl.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class XdlSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("会话对象被创建了");
		// 获取创建的对象 
		HttpSession  session  = event.getSession();
		session.setAttribute("msg", "向session中添加了消息");
		session.setAttribute("msg", "向session中添加了消息");
		session.removeAttribute("msg");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("会话对象即将消亡");
	}

}
