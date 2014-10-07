package com.examples.ChatServer.chat;

public class ChatServer extends ChatRoom {
	
	public ChatServer() {
		connectUser("anna");
		userCreatesRoom("anna", "lotr");
		userEntersRoom("anna","lotr");
		connectUser("luke");
		userEntersRoom("luke","lotr");
	}
}