package org.runefriend.client.api.accessors.world;

import org.runefriend.client.api.accessors.entity.*;

/**
 * 
 * @author MalikDz
 *
 */

public interface IInteractableObject {
	
	int getX();

	int getY();

	int getHash();

	int getPlane();

	int getSizeX();

	int getSizeY();

	int getFlags();

	int getRelativeX();

	int getRelativeY();

	int getOrientation1();

	IRenderable getModel1();
}
