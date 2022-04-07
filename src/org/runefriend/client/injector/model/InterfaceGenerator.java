package org.runefriend.client.injector.model;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;
import org.runefriend.client.data.serializable.FieldHook;
import org.runefriend.client.data.serializable.InfoContainer;

/**
 * 
 * @author MalikDz
 *
 */

public class InterfaceGenerator extends Generator<ClassNode> {

	/**
	 * 
	 * creates an interface using asm as our bytecode generator library
	 * 
	 */

	public InterfaceGenerator(InfoContainer classInfo, InfoContainer scInfo) {
		element = new ClassNode();
		element.superName ="java/lang/Object";
		element.access = (ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE);
		element.name = API_PACKAGE_PATH + classInfo.getPackageName() + "I" + classInfo.getRealName();
		injectAbstractMethod(classInfo);
		setSuperClassName(scInfo);
		element.version = V1_6;
	}

	/**
	 * 
	 * add the super class name of this interface
	 * 
	 */

	@SuppressWarnings("unchecked")
	private void setSuperClassName(InfoContainer scInfo) {
		if (scInfo != null)
			element.interfaces.add(API_PACKAGE_PATH + scInfo.getPackageName() + "I" + scInfo.getRealName());
	}

	/**
	 * 
	 * add the abstract method to the current interface
	 * 
	 */

	@SuppressWarnings("unchecked")
	private void injectAbstractMethod(InfoContainer classInfo) {
		for (FieldHook h : classInfo.getFieldHooks()) {
			String name = "get" + h.getRealName().substring(0, 1).toUpperCase() + h.getRealName().substring(1);
			MethodNode fieldAccessor = new MethodNode(ACC_PUBLIC + ACC_ABSTRACT, name, "()" + h.getType(), null, null);
			element.methods.add(fieldAccessor);
		}
	}
}
