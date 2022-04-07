package org.runefriend.client.injector.model;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodNode;

/***
 * 
 * @author MalikDz
 *
 */

public class Utilities implements Opcodes {

	/**
	 * 
	 * generate the bytecode needed to multiply a constant with a field
	 * 
	 */

	protected static void generateNumberMultiplication(long number, MethodNode element) {
		if (number == 1)
			return;
		element.instructions.add(new LdcInsnNode((int)number));
		element.instructions.add(new InsnNode(IMUL));
	}
}
