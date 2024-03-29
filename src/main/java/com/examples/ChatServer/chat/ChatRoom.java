package com.examples.ChatServer.chat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ChatRoom { 
	private Map users = new HashMap();
	private Map rooms = new HashMap();
	
	public boolean connectUser(String userName) { 
		if (user(userName) != null)
			return false;
		users.put(userName,new User(userName));
		return true;
	} 
	
	public boolean disconnectUser(String userName) { 
		User user = (User)users.remove(userName);
		if (user == null)
			return false;
		for (Iterator it = getRooms(); it.hasNext(); )
			((Room)it.next()).remove(user);
			return true;
	} 
	
	public boolean userCreatesRoom(String userName, String roomName) { 
		User user = user(userName);
		if (user == null)
			throw new RuntimeException("Unknown user name: "+userName);
		createRoom(roomName,user);
		return true;
	} 
	
	public void createRoom(String roomName, User user) {
		if (rooms.containsKey(roomName))
			throw new RuntimeException("Duplicate room name: "+roomName);
		rooms.put(roomName,new Room(roomName,user,this));
	}
	
	public boolean userEntersRoom(String userName, String roomName) { 
		User user = user(userName);
		Room room = room(roomName);
		if (user == null || room == null)
			return false;
		room.add(user);
		return true;
	}
	
	public boolean userLeavesRoom(String userName, String roomName) {
		User user = user(userName);
		Room room = room(roomName);
		if (user == null || room == null)
			return false;
		return room.remove(user);
	}
	
	public int occupants(String roomName) { 
		Room room = room(roomName);
		if (room == null)
			throw new RuntimeException("Unknown room: "+roomName);
		return room.occupantCount();
	}
	
	public boolean userPaysDollarFee(String userName, double fee) {
		return true;
	}
	
	public Iterator getRooms() {
		return rooms.values().iterator();
	}
	
	public boolean removeRoom(String roomName) {
		Room room = room(roomName);
		if (room == null)
			return false;
		if (room.occupantCount() > 0)
			return false;
		rooms.remove(room);
		return true;
	}
	
	public User user(String userName) {
		return (User)users.get(userName);
	}
	
	public Room room(String roomName) {
		return (Room)rooms.get(roomName);
	}
	
	public Iterator usersIn(String roomName) {
		Room room = room(roomName);
		if (room == null)
			throw new RuntimeException("Unknown room");
		return room.users();	
	}
	
	public Set usersInRoom(String roomName) {
		Room room = room(roomName);
		if (room == null)
			throw new RuntimeException("Unknown room");
		return room.usersIn();	
	}

	public void renameRoom(Room room, String name) {
		rooms.remove(room.getName());
		rooms.put(name,room);
	}
} 