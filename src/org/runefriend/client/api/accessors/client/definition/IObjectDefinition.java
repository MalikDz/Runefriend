package org.runefriend.client.api.accessors.client.definition;

/**
 * 
 * @author MalikDz
 *
 */

public interface IObjectDefinition {

	int getIcon();

	int getSizeX();

	int getSizeY();

	String getName();

	int getMapScene();

	int getModelSizeX();

	int getModelSizeY();

	int getModelSizeZ();

	int getTranslateX();

	int getTranslateY();

	int getTranslateZ();

	int getAnimationId();

	boolean getWalkable();

	String[] getActions();

	boolean getRotated();

	boolean getCastShadow();
}
