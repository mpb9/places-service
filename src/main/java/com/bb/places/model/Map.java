package com.bb.places.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "MAP", schema = "PUBLIC")
public class Map implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private int id;

	@NotBlank
	@Column(name = "USER_ID", nullable = false, length = 32)
	private String userId;

	@Min(0)
	@Max(1)
	@NotNull
	@Column(name = "PBLC", nullable = false)
	private int pblc;

	@NotBlank
	@Column(name = "NAME", nullable = false, length = 64)
	private String name;

	@Column(name = "ABOUT", length = 255)
	private String about;

	public int getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPblc() {
		return pblc;
	}

	public void setPblc(int pblc) {
		this.pblc = pblc;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || this.getClass() != o.getClass())
			return false;

		Map that = (Map) o;

		return that.getId() == this.id;
	}

	@Override
	public String toString() {
		StringBuilder strBld = new StringBuilder();

		strBld.append("\n");
		strBld.append("***** MAP *****");
		strBld.append("\n");
		strBld.append("ID: " + this.id);
		strBld.append("\n");
		strBld.append("USER_ID: " + this.userId);
		strBld.append("\n");
		strBld.append("NAME: " + this.name);
		strBld.append("\n");
		strBld.append("PBLC: " + this.pblc);
		strBld.append("\n");
		strBld.append("ABOUT: " + this.about);
		strBld.append("\n");
		strBld.append("***** END MAP *****");

		return strBld.toString();
	}

}
