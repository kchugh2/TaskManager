package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the LISTCUSTOMERS database table.
 * 
 */
@Entity
@Table(name="LISTCUSTOMERS", schema="testuserdb")

@NamedQuery(name="Listcustomer.findAll", query="SELECT l FROM Listcustomer l")
public class Listcustomer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="listuser_seq")
    @SequenceGenerator(schema="testuserdb", name="listuser_seq", sequenceName="listuser_seq", allocationSize=1)
	private long custid;

	private String custname;

	private String custpassword;

	public Listcustomer() {
	}

	public long getCustid() {
		return this.custid;
	}

	public void setCustid(long custid) {
		this.custid = custid;
	}

	public String getCustname() {
		return this.custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getCustpassword() {
		return this.custpassword;
	}

	public void setCustpassword(String custpassword) {
		this.custpassword = custpassword;
	}

}