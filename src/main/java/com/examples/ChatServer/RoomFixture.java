package com.examples.ChatServer;

import com.examples.ChatServer.chat.ChatRoom;

public class RoomFixture extends fit.Fixture { 
	private String roomName; 
	private ChatRoom chat; 
	
	public RoomFixture(ChatRoom chat, String roomName) { 
		this.chat = chat; 
		this.roomName = roomName; 
	} 
	
	public boolean hasOccupants(int count) { 
		return chat.room(roomName).occupantCount() == count;
	} 
	
	public boolean isOpen() { 
		return chat.room(roomName).isOpen(); 
	}
}