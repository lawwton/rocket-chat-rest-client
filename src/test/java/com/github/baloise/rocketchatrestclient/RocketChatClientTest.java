package com.github.baloise.rocketchatrestclient;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

import com.github.baloise.rocketchatrestclient.model.ServerInfo;
import com.github.baloise.rocketchatrestclient.model.User;

public class RocketChatClientTest {
    private RocketChatClient rc;
    
    @Before
    public void setup() {
        String serverUrl = "http://localhost:3000/api/";
        String user = "graywolf336";
        String password = "graywolf336";
        rc = new RocketChatClient(serverUrl, user, password);
    }

	@Test
	public void testRocketCatExists() throws Exception {
		ServerInfo info = rc.getServerInformation();
		assertTrue("The Rocket.Chat Version is empty, when it shouldn't be.", !info.getVersion().isEmpty());
		
		User rocketCat = rc.getUser("rocket.cat");
		assertTrue("The Rocket.Cat user's id doesn't match what it should be.", "rocket.cat".equals(rocketCat.getId()));
	}
	
	@Test
	public void testChannelGetting() throws Exception {
	    assertEquals("The default count changed?", 50, rc.getChannelsApi().list().length);
	    assertEquals("The channel count wasn't one?", 1, rc.getChannelsApi().list(new RocketChatQueryParams().setCount(1)).length);
	}
}
