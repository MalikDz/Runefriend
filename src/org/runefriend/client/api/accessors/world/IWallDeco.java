package org.runefriend.client.api.accessors.world;

import org.runefriend.client.api.accessors.entity.*;

/**
 * 
 * @author MalikDz
 *
 */

public interface IWallDeco {

	int getX();

	int getY();

	int getHash();

	int getPlane();

	int getOrientation1();

	int getOrientation2();

	IRenderable getModel1();

	IRenderable getModel2();

	int getConfigurationHash();
}
