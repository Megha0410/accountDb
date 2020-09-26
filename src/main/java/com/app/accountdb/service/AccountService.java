package com.app.accountdb.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.accountdb.entity.Account;
import com.app.accountdb.entity.Statement;
import com.app.accountdb.repository.AccountInterfaceRepository;
@Service
public class AccountService {
	@Autowired
	DataSource datasource;
	
	@Autowired
	private AccountInterfaceRepository accuntRepo;
	
	public Set<Statement> getByAccountId(int id){
		Optional<Account> accountOp =accuntRepo.findById(id);
		Account account = null;
		if(accountOp.isPresent()) {
			account = accountOp.get();
		}
		Set<Statement> statement = null;
		if(account!= null)
		 statement= account.getStatements();
		return statement;
		
	}
}
