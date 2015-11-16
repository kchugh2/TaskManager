package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the STATUS database table.
 * 
 */
@Entity
@Table(name="Status", schema="testuserdb")
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long statusid;

	private String statusdescription;

	public Status() {
	}

	public long getStatusid() {
		return this.statusid;
	}

	public void setStatusid(long statusid) {
		this.statusid = statusid;
	}

	public String getStatusdescription() {
		return this.statusdescription;
	}

	public void setStatusdescription(String statusdescription) {
		this.statusdescription = statusdescription;
	}

}