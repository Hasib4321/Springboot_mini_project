package net.codejava;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Request {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long claimNumber;
	private int reqUserId;
	private String category;
	private String fromDate;
	private String toDate;
	private int amount;
	private int statusId;
	private long reqRmId;
	public long getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(long claimNumber) {
		this.claimNumber = claimNumber;
	}
	public int getReqUserId() {
		return reqUserId;
	}
	public void setReqUserId(int reqUserId) {
		this.reqUserId = reqUserId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	
	public long getReqRmId() {
		return reqRmId;
	}
	public void setReqRmId(long reqRmId) {
		this.reqRmId = reqRmId;
	}
	public Request(long claimNumber, int reqUserId, String category, String fromDate, String toDate, int amount,
			int statusId, String approvedDate, long reqRmId) {
		super();
		this.claimNumber = claimNumber;
		this.reqUserId = reqUserId;
		this.category = category;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.amount = amount;
		this.statusId = statusId;
		this.reqRmId = reqRmId;
	}
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}