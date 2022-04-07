package org.runefriend.client.api.accessors.client.definition;

/**
 * 
 * @author MalikDz
 *
 */

public interface INpcDefinition {

	int getLevel();

	int getSizeX();

	int getSizeY();

	int getVarpId();

	int getContrast();

	int getHeadIcon();

	boolean getVisible();

	boolean getClickable();

	String[] getActions();

	boolean getVisibleOnMap();

	String getName();

	int getSettingId();

	int getLightness();

	int getDegreToTurn();

	int getBoundDimension();

	int getStandingAnimation();

	int getWalkingAnimation();

	int getTurnAround();

	int getTurnRight();

	int getTurnLeft();
}
