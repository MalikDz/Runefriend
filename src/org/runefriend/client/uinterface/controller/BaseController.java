package org.runefriend.client.uinterface.controller;

import org.runefriend.client.uinterface.view.BaseView;

/**
 * 
 * @author MalikDz
 *
 */

@SuppressWarnings("rawtypes")
public abstract class BaseController<T extends BaseView, E> {

	/**
	 * 
	 * our fields
	 * 
	 */

	protected T view;

	private E defaultModel;

	public abstract void show();

	public abstract BaseView view();

	/**
	 * 
	 * creates a new controller
	 * 
	 */

	public BaseController(T view, E defaultModel) {
		this.view = view;
		this.defaultModel = defaultModel;
	}

	/**
	 * 
	 * creates a new controller with a model only
	 * 
	 */

	public BaseController(E defaultModel) {
		this.defaultModel = defaultModel;
	}

	/**
	 * 
	 * creates a new controller with a view only
	 * 
	 */

	public void setView(T view) {
		this.view = view;
	}

	/**
	 * 
	 * set the default mode for this controller
	 * 
	 */

	public void setModel(E model) {
		this.defaultModel = model;
	}

	/**
	 * 
	 * creates a new controller with a view only
	 * 
	 */

	public BaseController(T view) {
		this.view = view;
	}

	/**
	 * 
	 * @return the model that this controller manage
	 *
	 */

	public E model() {
		return defaultModel;
	}
}