//package com.adapter.TCPAdapter;
//
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.adapter.TCPClientAdapter.service.GreetClient;
//
//@SpringBootTest
//class TcpAdapterApplicationTests {
//
//	@Test
//	public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() {
//		GreetClient client  = new GreetClient();
//		client.startConnection("127.0.0.1", 6666);
//		String response = client.sendMessage("hello server");
//		System.err.println("this is respone ********* " +response);
//		Assert.assertEquals("hello client", response);
//	}
//
//}
