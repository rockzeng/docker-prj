package com.examples.ChatServer;

import com.examples.ChatServer.chat.ChatRoom;
import com.examples.ChatServer.chat.User;
import fit.Fixture;

/*
 * @author Rick Mugridge 6/10/2004
 * Copyright (c) 2004 Rick Mugridge, University of Auckland, NZ
 * Released under the terms of the GNU General Public License version 2 or later.
 */

/**
 * 
 */
public class UsersFixture extends Fixture { //COPY:ALL
	private ChatRoom chat; //COPY:ALL
	private User user; //COPY:ALL
	 //COPY:ALL
	public UsersFixture(ChatRoom chat, User user) { //COPY:ALL
		this.chat = chat; //COPY:ALL
		this.user = user; //COPY:ALL
	} //COPY:ALL
	public boolean createsRoom(String roomName) { //COPY:ALL
		chat.createRoom(roomName,user); //COPY:ALL
		return true; //COPY:ALL
	} //COPY:ALL
	public boolean entersRoom(String roomName) { //COPY:ALL
		return chat.userEntersRoom(user.getName(),roomName); //COPY:ALL
	} //COPY:ALL
} //COPY:ALL