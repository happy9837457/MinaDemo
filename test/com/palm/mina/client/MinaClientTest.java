package com.palm.mina.client;

import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.palm.mina.common.UserInfo;

public class MinaClientTest {
	private MinaClient minaClient;

	@Before
	public void setUp() throws Exception {
//		minaClient = new MinaClient(new TextLineCodecFactory());// 传输字符
		minaClient = new MinaClient(new ObjectSerializationCodecFactory());// 传输对象
	}

	@Test
	public void testStartClient() {
//		minaClient.send("client");
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername("arvin");
		userInfo.setPassword("love");
		minaClient.send(userInfo);
	}

	@After
	public void tearDown() throws Exception {
	}

}
