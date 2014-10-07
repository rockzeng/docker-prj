package com.examples.ChatServer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.examples.ChatServer.chat.*;

public class OccupantList extends fit.RowFixture { 
	public Object[] query() throws Exception { 
		List occupancies = new ArrayList(); 
		for (Iterator it = ChatServer.CHAT.getRooms(); 
                      it.hasNext(); ) { 
			Room room = (Room)it.next(); 
			collectOccupants(occupancies,room); 
		} 
		return occupancies.toArray(); 
	} 
	
	public Class getTargetClass() { 
		return Occupancy.class; 
	} 
	
	private void collectOccupants(List occupancies, Room room) {
		for (Iterator it = room.users(); it.hasNext(); ) { 
			User user = (User)it.next(); 
			Occupancy occupant = new Occupancy(room.getName(), user.getName()); 
			occupancies.add(occupant);
		} 
	} 
}