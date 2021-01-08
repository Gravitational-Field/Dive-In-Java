package com.xdl.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class XdlSessionDataListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		System.out.println("增加数据了 监控1");

	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		System.out.println("删除数据了 监控1");

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("修改数据了 监控1");

	}

}
