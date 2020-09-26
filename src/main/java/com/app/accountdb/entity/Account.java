package com.app.accountdb.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "account_type")
	private String accuntType;
	@Column(name = "account_number")
	private String accountNumber;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private Set<Statement> statements;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccuntType() {
		return accuntType;
	}

	public void setAccuntType(String accuntType) {
		this.accuntType = accuntType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Set<Statement> getStatements() {
		return statements;
	}

	public void setStatements(Set<Statement> statements) {
		this.statements = statements;
	}

	public Account(int id, String accuntType, String accountNumber, Set<Statement> statements) {
		super();
		this.id = id;
		this.accuntType = accuntType;
		this.accountNumber = accountNumber;
		this.statements = statements;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accuntType=" + accuntType + ", accountNumber=" + accountNumber + ", statements="
				+ statements + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((accuntType == null) ? 0 : accuntType.hashCode());
		result = prime * result + id;
		result = prime * result + ((statements == null) ? 0 : statements.hashCode());
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
		Account other = (Account) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (accuntType == null) {
			if (other.accuntType != null)
				return false;
		} else if (!accuntType.equals(other.accuntType))
			return false;
		if (id != other.id)
			return false;
		if (statements == null) {
			if (other.statements != null)
				return false;
		} else if (!statements.equals(other.statements))
			return false;
		return true;
	}

}
