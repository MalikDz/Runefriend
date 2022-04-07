package org.runefriend.client.api.accessors.client.widget;

import org.runefriend.client.api.accessors.collect.*;

/**
 * 
 * @author MalikDz
 *
 */

public interface IWidgetComponent extends INode {

	int getType();

	String getText();

	int getParentID();

	int getRelativeX();

	int getRelativeY();

	String[] getActions();

	int getComponentUID();

	int getWidth();

	int getHeight();

	int getItemId();

	int getBorder();

	int getScrollX();

	int getScrollY();

	int getItemStack();

	int getTextureId();

	int getTextAlpha();

	int getTextColor();

	int[] getSlotIds();

	int getBoundsIndex();

	int[] getSlotStackSizes();

	IWidgetComponent getChildren();
}
