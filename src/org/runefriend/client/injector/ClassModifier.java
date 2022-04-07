package org.runefriend.client.injector;

import java.io.IOException;
import java.io.FileOutputStream;

import java.util.Map;
import java.util.List;
import java.util.jar.*;
import java.util.HashMap;
import java.util.Enumeration;
import java.util.zip.ZipEntry;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;
import org.runefriend.client.data.serializable.FieldHook;
import org.runefriend.client.injector.model.GetterGenerator;
import org.runefriend.client.data.serializable.InfoContainer;
import org.runefriend.client.injector.model.InterfaceGenerator;

/**
 * 
 * @author MalikDz
 *
 */
public class ClassModifier {

	/**
	 * 
	 * our fields
	 * 
	 */

	private JarFile targetJar;
	private Map<String, InfoContainer> classesDataContainer;
	private Map<String, ClassNode> modifiedClasses = new HashMap<String, ClassNode>();

	/**
	 * 
	 * cache the jar path that will we inject
	 * 
	 */

	public void linkJar(final String targetJarPath) throws IOException {
		targetJar = new JarFile(targetJarPath);
	}

	/**
	 * 
	 * @return our modified classes nodes map
	 * 
	 */
	public Map<String, ClassNode> getModifiedClasses() {
		return modifiedClasses;
	}

	/**
	 * 
	 * register the containers map used for our client modifications
	 * 
	 */

	public void registerClassDataContainers(HashMap<String, InfoContainer> classesDataContainer) {
		this.classesDataContainer = classesDataContainer;
	}

	/**
	 * 
	 * use the containers map to apply modifications on the linked jar
	 * 
	 */

	@SuppressWarnings({ "unchecked" })
	public void applyModifications() {
		for (InfoContainer ic : classesDataContainer.values()) {
			InfoContainer superIc = ic.getSuperClass() == null ? null : classesDataContainer.get(ic.getSuperClass());
			InterfaceGenerator generatedClass = new InterfaceGenerator(ic, superIc);
			modifiedClasses.put(generatedClass.element().name, generatedClass.element());
			ClassNode classNodeTarget = modifiedClasses.get(ic.getObfName());
			classNodeTarget.interfaces.add(generatedClass.element().name);
			injectAccessors(ic.getFieldHooks(), classNodeTarget);
		}
	}

	/**
	 * 
	 * inject accessors to a parsed class using a list of field hooks
	 * 
	 */
	@SuppressWarnings("unchecked")
	private void injectAccessors(List<FieldHook> fieldHooks, ClassNode c) {
		for (FieldHook f : fieldHooks) {
			if (f.getType() == null)
				continue;
			final int d = (int) f.getDecoder();
			final String t = f.getSourceType();
			final boolean s = c.name.equals("client");
			final String mn = "get" + f.getRealName().substring(0, 1).toUpperCase() + f.getRealName().substring(1);
			c.methods.add(new GetterGenerator(f.getClassName(), f.getFieldName(), f.getType(), mn, s, d, t).element());
		}
	}

	/**
	 * 
	 * parse the jar classes and cache them on a class nodes map
	 * 
	 */

	public void parseJar() throws IOException {
		ClassNode cn = null;
		ClassReader cr = null;
		JarEntry entry = null;
		Enumeration<JarEntry> ens = targetJar.entries();
		while (ens.hasMoreElements()) {
			entry = ens.nextElement();
			if (entry.getName().endsWith(".class")) {
				cr = new ClassReader(targetJar.getInputStream(entry));
				cr.accept(cn = new ClassNode(), ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
				modifiedClasses.put(cn.name, cn);
				System.out.println("Wesh : " + cn.name);
			}
		}
	}

	/**
	 * 
	 * write the jar from our classnode maps
	 * 
	 */

	public void writeJar(String fileName) throws IOException {
		try (JarOutputStream out = new JarOutputStream(new FileOutputStream(fileName))) {
			for (ClassNode cn : modifiedClasses.values()) {
				ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
				cn.accept(cw);
				out.putNextEntry(new ZipEntry(cn.name + ".class"));
				out.write(cw.toByteArray());
				out.closeEntry();
			}
		}

	}
}
