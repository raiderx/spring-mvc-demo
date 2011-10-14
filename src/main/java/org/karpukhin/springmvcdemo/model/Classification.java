package org.karpukhin.springmvcdemo.model;

/**
 * @author Pavel Karpukhin
 */
public class Classification extends Entity {

	private String name;

	public Classification() {
	}

	public Classification(String name) {
		this.name = name;
	}

	public Classification(int id, String name) {
		setId(id);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
