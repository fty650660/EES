package com.ees.hibernate;

/**
 * AbstractAdministrator entity provides the base persistence definition of the
 * Administrator entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAdministrator implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String password;
	private Integer level;

	// Constructors

	/** default constructor */
	public AbstractAdministrator() {
	}

	/** minimal constructor */
	public AbstractAdministrator(Integer id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	/** full constructor */
	public AbstractAdministrator(Integer id, String name, String password,
			Integer level) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.level = level;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

}