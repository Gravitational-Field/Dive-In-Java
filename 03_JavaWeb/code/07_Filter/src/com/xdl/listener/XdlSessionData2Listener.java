package com.xdl.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class XdlSessionData2Listener
 *
 */
public class XdlSessionData2Listener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public XdlSessionData2Listener() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		System.out.println("增加数据了 监控2");

	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		System.out.println("删除数据了 监控2");

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("修改数据了 监控2");

	}

	
}
