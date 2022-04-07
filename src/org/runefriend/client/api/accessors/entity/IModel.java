package org.runefriend.client.api.accessors.entity;

/**
 * 
 * @author MalikDz
 *
 */

public interface IModel extends IRenderable {

	int[] getIndicesX();

	int[] getIndicesY();

	int[] getIndicesZ();

	int getIndicesSize();

	int[] getVerticlesX();

	int[] getVerticlesY();

	int[] getVerticlesZ();

	int getVerticlesSize();

	int getTrianglesSize();

}
