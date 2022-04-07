package org.runefriend.client.injector.model;

import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;
import org.objectweb.asm.tree.FieldInsnNode;

/**
 * 
 * @author MalikDz
 *
 */

public class GetterGenerator extends Generator<MethodNode> {

	/**
	 * 
	 * @param owner
	 * @param field
	 * @param type
	 * @param getterName
	 * @param isStatic
	 *
	 */

	public GetterGenerator(String owner, String field, String type, String getterName, boolean isStatic, String sType) {
		this(owner, field, type, getterName, isStatic, -1, sType);
	}

	/**
	 * 
	 * @param owner
	 * @param field
	 * @param type
	 * @param getter
	 * @param staticField
	 * @param deco
	 *
	 */

	public GetterGenerator(String owner, String field, String t, String name, boolean isStatic, int deco, String type) {
		element = new MethodNode(ACC_PUBLIC, name, "()" + t, null, null);
		if (!isStatic)
			element.instructions.add(new VarInsnNode(ALOAD, 0));
		element.instructions.add(new FieldInsnNode(isStatic ? GETSTATIC : GETFIELD, owner, field, type));
		Utilities.generateNumberMultiplication(deco, element);
		element.instructions.add(new InsnNode(getReturnInstruction(t)));
		element.visitMaxs(0, 0);
	}

	/**
	 * 
	 * @return
	 * 
	 */

	private int getReturnInstruction(String type) {
		switch (type.toLowerCase()) {
		case "i":
		case "z":
			return IRETURN;
		case "j":
			return LRETURN;
		default:
			return ARETURN;
		}
	}
}
