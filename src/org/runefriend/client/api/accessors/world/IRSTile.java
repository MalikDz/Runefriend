package org.runefriend.client.api.accessors.world;

import org.runefriend.client.api.accessors.collect.*;

/**
 * 
 * @author MalikDz
 *
 */

public interface IRSTile extends INode {

	IWallObject getWallObject();

	IWallDeco getWallDecoration();

	IGroundObject getGroundObject();

	IGroundDeco getGroundDecoration();

	IInteractableObject[] getInteractableObjects();
}
