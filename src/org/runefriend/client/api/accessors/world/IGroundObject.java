package org.runefriend.client.api.accessors.world;

import org.runefriend.client.api.accessors.entity.*;

/**
 * 
 * @author MalikDz
 *
 */

public interface IGroundObject {

	int getX();

	int getY();

	int getHash();

	int getPlane();

	IRenderable getModel1();

	int getConfigurationHash();
}
