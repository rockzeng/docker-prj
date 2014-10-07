package com.examples.ChatServer;

import com.examples.ChatServer.chat.ChatRoom;
import com.examples.ChatServer.chat.User;
import fit.Fixture;

public class UsersFixture extends Fixture {
	private ChatRoom chat; 
	private User user; 
	
	public UsersFixture(ChatRoom chat, User user) { 
		this.chat = chat; 
		this.user = user; 
	} 
	
	public boolean createsRoom(String roomName) {
		chat.createRoom(roomName,user);
		return true; 
	}
	
	public boolean entersRoom(String roomName) { 
		return chat.userEntersRoom(user.getName(),roomName); 
	} 
} 