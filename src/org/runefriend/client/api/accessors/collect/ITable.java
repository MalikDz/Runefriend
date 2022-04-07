package org.runefriend.client.api.accessors.collect;

/**
 * 
 * @author MalikDz
 *
 */

public interface ITable {

	INode getTableHead();

	INode getTableTail();

	INode[] getTableBuckets();
}
