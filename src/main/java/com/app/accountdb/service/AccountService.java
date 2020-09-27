package com.app.accountdb.service;


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
		Set<Statement> statements = null;
		if(account!= null) {
		 statements= account.getStatements();
		 for(Statement s: statements) {
			 int ide= s.getId();
			 int maskId = ide << 4;
			 s.setId(maskId);
		 }
		}
		return statements;
		
	}
}
