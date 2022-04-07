package org.runefriend.client.api.accessors.collect;

/**
 * 
 * @author MalikDz
 *
 */

public interface INode {
	
	long getUID();

	INode getNext();

	INode getPrevious();
}
