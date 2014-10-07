package com.examples.ChatServer;

import java.util.List;
import com.examples.ChatServer.chat.User;
import fit.RowFixture;

public class UsersFixture2 extends RowFixture { 
	private Object[] collection;
	 
	public UsersFixture2(List users) { 
		collection = users.toArray();
	} 
	
	public Object[] query() throws Exception { 
		return collection; 
	}
	
	public Class getTargetClass() { 
		return User.class; 
	} 
} 