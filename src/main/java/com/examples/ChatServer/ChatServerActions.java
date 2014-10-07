package com.examples.ChatServer;

import com.examples.ChatServer.chat.ChatRoom;
import fit.Fixture; 

public class ChatServerActions extends Fixture { 
	private ChatRoom chat = new ChatRoom(); 
	private String userName = ""; 
	private String roomName = ""; 
	
	public void user(String userName) { 
		this.userName = userName; 
	} 
	
	public void connect() { 
		chat.connectUser(userName);
	}
	
	public void room(String roomName) { 
		this.roomName = roomName; 
	} 
	
	public void newRoom() { 
		chat.userCreatesRoom(userName, roomName); 
	} 
	
	public void enterRoom() { 
		chat.userEntersRoom(userName,roomName); 
	}
	
	public int occupantCount() { 
		return chat.occupants(roomName); 
	} 
	
	public void disconnect() {
		chat.disconnectUser(userName);
	}
} 