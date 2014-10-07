package com.examples.ChatServer;
import fit.RowFixture; 

public class ParamRowFixture extends RowFixture { 
	private Object[] collection; 
	private Class targetClass; 
	 
	public ParamRowFixture(Object[] collection, Class targetClass) { 
		this.collection = collection; 
		this.targetClass = targetClass; 
	} 
	
	public Object[] query() throws Exception { 
		return collection;
	} 
	
	public Class getTargetClass() {
		return targetClass; 
	} 
}