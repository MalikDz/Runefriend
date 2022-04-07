package org.runefriend.client.api.accessors.entity;

/**
 * 
 * @author MalikDz
 *
 */

public interface ICharacter extends IRenderable {

	int getRegionX();

	int getRegionY();

	int getQueuesize();

	int getAnimation();

	int getOrientation();

	int getInteractingId();

}
