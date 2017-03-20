package com.Handler;

import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class MinaServerHandler extends IoHandlerAdapter{
		public static Logger logger=Logger.getLogger(MinaServerHandler.class);

		
		@Override
		public void sessionCreated(IoSession session) throws Exception {
					logger.info("服务端与客户端创建连接。。。。");
		}
		@Override
		public void sessionOpened(IoSession session) throws Exception {
				logger.info("服务器与客户端连接打开。。。。");
		}
		
		//received 收到
		@Override
		public void messageReceived(IoSession session, Object message)
				throws Exception {
			
			String msg=message.toString();
			logger.info("服务端接收到的数据为："+msg);
			
			//如果服务端接收到bye则服务器与客户端断开连接
			if("bye".equals(msg)){
				session.close();
				
			}
			Date date=new Date();
			String a="a";
			session.write(a);
			
		}
		
		
		
		@Override
		public void messageSent(IoSession session, Object message)
				throws Exception {
		    //session.close() //发送成功后主动断开与客户端的连接
			String seMsg=session.toString();
			String msg=message.toString();
			logger.info("服务端发送消息成功！服务端发送的消息为----》"+msg+"   "+"session为："+seMsg);
		}
		@Override
		public void sessionIdle(IoSession session, IdleStatus status)
				throws Exception {
		String seMsg=session.toString();
		String staMsg=status.toString();
					logger.info("服务度端进入空闲状态---》session 为："+seMsg+"   "+"status为"+staMsg);
		}

		
		@Override
		public void exceptionCaught(IoSession session, Throwable cause)
				throws Exception {
			// TODO Auto-generated method stub
			super.exceptionCaught(session, cause);
		}

		

		

		@Override
		public void sessionClosed(IoSession session) throws Exception {
			// TODO Auto-generated method stub
			super.sessionClosed(session);
		}

		
	
		

		
		
		
		
}
