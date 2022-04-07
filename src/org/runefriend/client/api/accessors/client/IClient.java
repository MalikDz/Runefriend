package org.runefriend.client.api.accessors.client;

import java.awt.*;
import org.runefriend.client.api.accessors.world.*;
import org.runefriend.client.api.accessors.entity.*;
import org.runefriend.client.api.accessors.collect.*;
import org.runefriend.client.api.accessors.client.widget.*;

/**
 * 
 * @author MalikDz
 *
 */

public interface IClient {

	int getYaw();

	int getMenuX();

	int getMenuY();

	int getPlane();
	
	int getPitch();

	int getBaseX();

	int getBaseY();

	INpc[] getNpcs();

	int getCameraX();

	int getCameraY();

	int getCameraZ();

	int getMapAngle();

	int getIdleTime();

	int getLoopCycle();

	int getGameState();

	int getMenuWidth();

	int getMenuCount();

	Canvas getCanvas();

	IRegion getRegion();

	int getMenuHeigth();

	int[] getSettings();

	String getPassword();

	int[] getRealLevels();

	int getCurrentWorld();

	ITable getItemTables();

	IPlayer[] getPlayers();

	int getSelectionState();

	int[] getCurrentLevels();

	String getSelectedItem();

	IPlayer getLocalPlayer();

	ITable getWidgetsNodes();

	String[] getMenuActions();

	byte[][][] getTileBytes();

	String[] getMenuOptions();

	int[][][] getTileHeights();

	int[] getWidgetsSettings();

	int[] getWidgetPositionsX();

	int[] getWidgetPositionsY();

	int[] getSkillsExperience();

	int getHoveredRegionTileX();

	int getHoveredRegionTileY();

	boolean getMenuVisibility();

	int getSpellSelectionState();

	IDeque[][][] getGroundItems();

	IWidgetComponent[][] getWidgets();
}
