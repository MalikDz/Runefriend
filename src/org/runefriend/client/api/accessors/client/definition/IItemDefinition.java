package org.runefriend.client.api.accessors.client.definition;

/**
 * 
 * @author MalikDz
 *
 */

public interface IItemDefinition {

	int getSine();

	int getValue();

	String getName();

	int getModelZoom();

	int getRotation1();

	int getRotation2();

	int getDRotation();

	int getModOffSet();

	int getMaleEquipOffset();

	int getFemaleEquipOffset();

	String[] getGroundActions();

	String[] getInterfaceActions();

	int getMaleEquipPrimaryModel();

	int getMaleEquipSecondaryModel();

	int getFemaleEquipPrimaryModel();

	int getFemaleEquipSecondaryModel();

	int getNoteIndex();

	int getMaleEmblem();

	int getMaleDialog();

	int getFemaleDialog();

	int getFemaleEmblem();

	int getMaleDialogHat();

	int getFemaleDialogHat();

	int getNoteTemplateIndex();

	int getModelX();

	int getModelY();

	int getModelZ();

	int getTeamIndex();

	int getLightModel();

	int getShadowModel();

}
