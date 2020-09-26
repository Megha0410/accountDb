package com.app.accountdb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Statement")
public class Statement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name = "account_id", insertable = false)
	private Account account;
	@Column(name = "datefield")
	private String datefield;
	@Column(name = "amount")
	private String amount;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the datefield
	 */
	public String getDatefield() {
		return datefield;
	}

	/**
	 * @param datefield
	 *            the datefield to set
	 */
	public void setDatefield(String datefield) {
		this.datefield = datefield;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Statement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Statement(int id, String datefield, String amount) {
		super();
		this.id = id;
		this.datefield = datefield;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Statement [id=" + id + ", account=" + account + ", datefield=" + datefield + ", amount=" + amount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((datefield == null) ? 0 : datefield.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Statement other = (Statement) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (datefield == null) {
			if (other.datefield != null)
				return false;
		} else if (!datefield.equals(other.datefield))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
