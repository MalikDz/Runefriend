package org.runefriend.client.api.accessors.world;

import org.runefriend.client.api.accessors.entity.*;

/**
 * 
 * @author MalikDz
 *
 */

public interface IGroundDeco {

	int getX();

	int getY();

	int getHash();

	int getPlane();

	IRenderable getModel2();

	IRenderable getModel1();

	IRenderable getModel3();
}
