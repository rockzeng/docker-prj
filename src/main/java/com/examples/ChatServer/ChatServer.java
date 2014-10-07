package com.examples.ChatServer;

import com.examples.ChatServer.chat.ChatRoom;
import fit.Fixture; 

public class ChatServer extends Fixture { 
	public static ChatRoom CHAT; 
	private String userName = ""; 
	private String roomName = ""; 
	private boolean roomCreatedOK = false;
	private boolean roomEnteredOK = false;

	public ChatServer() { 
		CHAT = new ChatRoom(); 
	} 
	
	public void user(String userName) { 
		this.userName = userName; 
	}
	
	public void connect() { 
		CHAT.connectUser(userName);
	} 
	
	public void room(String roomName) { 
		this.roomName = roomName;
	} 
	
	public void newRoom() { 
		roomCreatedOK = CHAT.userCreatesRoom(userName, roomName); 
	} 
	
	public void enterRoom() { 
		roomEnteredOK = CHAT.userEntersRoom(userName,roomName); 
	} 
	
	public int occupantCount() {
		return CHAT.occupants(roomName); 
	} 
	
	public void disconnect() { 
		CHAT.disconnectUser(userName); 
	} 
	
	public boolean roomCreated() {
		return roomCreatedOK;
	}
	
	public boolean roomEntered() {
		return roomEnteredOK;
	}
} 