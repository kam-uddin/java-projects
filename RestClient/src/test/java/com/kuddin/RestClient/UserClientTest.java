package com.kuddin.RestClient;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class UserClientTest {

	@Test
	void expectedAmountOfUserShouldBeReturned() throws IOException, InterruptedException {
		assertEquals(6, UserClient.queryUsers(1).size());
	}
	
	@Test
	void firstUserShouldBeGeorge() throws IOException, InterruptedException {
		assertEquals("George", UserClient.queryUsers(1).get(0).getFirst_name());
	}

}
