package com.Handler;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class MinaClientHandler extends IoHandlerAdapter {

	private static Logger logger=Logger.getLogger(MinaClientHandler.class);
	
	
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
			String msg=message.toString();
			
			logger.info("客户端接收的信息为:"+msg);
	}
	
	
	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
			logger.error("客户端发生异常。。。。。"+cause);	
	}

	

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
			String msg=message.toString();
			
			logger.info("客户端发送的消息为:"+msg);
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionClosed(session);
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionCreated(session);
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		// TODO Auto-generated method stub
		super.sessionIdle(session, status);
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionOpened(session);
	}
		
}
