package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TODOLIST database table.
 * 
 */
@Entity
@Table(name="Todolist", schema="testuserdb")
@NamedQuery(name="Todolist.findAll", query="SELECT t FROM Todolist t")
public class Todolist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="task_seq")
    @SequenceGenerator(schema="testuserdb", name="task_seq", sequenceName="task_seq", allocationSize=1)
	private long taskid;

	@Temporal(TemporalType.DATE)
	private Date compdate;

	@Temporal(TemporalType.DATE)
	private Date duedate;

	private BigDecimal statusid;

	private String taskdescription;

	private String taskpriority;

	private String taskuser;

	public Todolist() {
	}

	public long getTaskid() {
		return this.taskid;
	}

	public void setTaskid(long taskid) {
		this.taskid = taskid;
	}

	public Date getCompdate() {
		return this.compdate;
	}

	public void setCompdate(Date compdate) {
		this.compdate = compdate;
	}

	public Date getDuedate() {
		return this.duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public BigDecimal getStatusid() {
		return this.statusid;
	}

	public void setStatusid(BigDecimal statusid) {
		this.statusid = statusid;
	}

	public String getTaskdescription() {
		return this.taskdescription;
	}

	public void setTaskdescription(String taskdescription) {
		this.taskdescription = taskdescription;
	}

	public String getTaskpriority() {
		return this.taskpriority;
	}

	public void setTaskpriority(String taskpriority) {
		this.taskpriority = taskpriority;
	}

	public String getTaskuser() {
		return this.taskuser;
	}

	public void setTaskuser(String taskuser) {
		this.taskuser = taskuser;
	}

}