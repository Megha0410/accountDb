package com.app.accountdb.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.app.accountdb.entity.*;

import com.app.accountdb.service.AccountService;
import com.app.accountdb.service.StatementService;

@RestController
public class DataBaseAccessController {
	@Autowired
	private AccountService accServ;
	
	@Autowired
	private StatementService stateServ;
	
	@RequestMapping(method= RequestMethod.GET, value="/statement/{id}")
	public Set<Statement> getByAccountId(@PathVariable int id){
		Set<Statement> statement =accServ.getByAccountId(id);
		return statement;
	}
	
	@RequestMapping(method= RequestMethod.GET, value="/statement/byAmt/{fromAmt}/{toAmt}")
	public List<Statement> getByAmountRange(@PathVariable String fromAmt, @PathVariable String toAmt){
		List<Statement> statement = stateServ.getByAmountRange(fromAmt, toAmt);
		return statement;
	}
	
	@RequestMapping(method= RequestMethod.GET, value="/statement/byDate/{fromDate}/{toDate}")
	public List<Statement> getByDateRange(@PathVariable String fromDate, @PathVariable String toDate){
		List<Statement> statement = stateServ.getByDateRange(fromDate, toDate);
		return statement;
	}
	
	@RequestMapping(method= RequestMethod.GET, value="/statement")
	public List<Statement> getStatemnt(){
		List<Statement> statement = stateServ.getStatement();
		return statement;
	}
	
}
