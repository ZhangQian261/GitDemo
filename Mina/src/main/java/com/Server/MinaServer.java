package com.Server;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.Handler.MinaServerHandler;

public class MinaServer {
      //记录日志
	  private static Logger logger=Logger.getLogger(MinaServer.class);
	  
	  private static int RORT=3005;
	
	  
	  public static void main(String[] args) {
		 	
			IoAcceptor acceptor=null;
			try {
				//创建一个非阻塞的server端的Socket
				
				acceptor =new NioSocketAcceptor();
				//设置过滤器(使用Mina提供的文本换行符编解码器)
				//	                                                                         自定义名字
				acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"), 
														   LineDelimiter.WINDOWS.getValue(),
														   LineDelimiter.WINDOWS.getValue())));
				
				//设置虎丘数据的缓冲区大小
				acceptor.getSessionConfig().setReadBufferSize(2048);
				//读通道10秒内无操作进入空闲状态
				acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
				
				//绑定逻辑处理器
				acceptor.setHandler(new MinaServerHandler());
				//绑定端口
				acceptor.bind(new InetSocketAddress(RORT));
				logger.info("服务端启成功。。。。。端口号为:"+RORT);
				
				
				
				
				
				
			} catch (Exception e) {
				logger.error("服务器启动异常");
				e.printStackTrace();
			}
			
	}
	
}
