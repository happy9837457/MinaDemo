package com.palm.mina.server;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.palm.mina.common.UserInfo;

/**
 * minaserver接收消息处理器
 * 
 * @author lottery
 * 
 */
public class MinaServerHandler extends IoHandlerAdapter {

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		super.exceptionCaught(session, cause);
	}

	/**
	 * 服务器端消息到达时
	 */
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		if(message instanceof String){
			System.out.println("MinaServer:receive message is " + (String) message);
		} else if(message instanceof UserInfo){
			System.out.println("MinaServer:receive UserInfo is " + ((UserInfo) message).getUsername());
		}
		session.write("server received");
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {

	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("sessionClosed");
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("sessionCreated");
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		System.out.println("idlestatus:" + status);
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("sessionOpened");
	}

}
