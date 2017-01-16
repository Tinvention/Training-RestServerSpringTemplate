package net.tinvention.training.model;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String note;
	private Date created;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	

}