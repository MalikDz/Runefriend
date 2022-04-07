package org.runefriend.client.data.deserializer;

/**
 * 
 * @author MalikDz
 *
 */

public abstract class AbstractDeserializer {

	/**
	 * 
	 * this variable contain the path or link of the file
	 * 
	 */

	private String location;

	/**
	 * 
	 * deserialize the file linked to this deserializer instance
	 * 
	 */

	public abstract void deserialize();

	/**
	 * 
	 * create a deser
	 * 
	 */

	public AbstractDeserializer(String location) {
		this.location = location;
	}

	/**
	 * 
	 * link a location to deserializer instance , this is mandatory
	 * 
	 */

	public void link(String location) {
		this.location = location;
	}

	/**
	 * 
	 * @return the path or link of this file deserializer
	 * 
	 */

	public String getLocation() {
		return location;
	}
}
