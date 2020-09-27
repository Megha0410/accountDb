package com.app.accountdb.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.accountdb.entity.*;

import com.app.accountdb.repository.StatementRepositoryInterface;

@Service
public class StatementService {
	@Autowired
	DataSource datasource;
	
	@Autowired
	private StatementRepositoryInterface statementRepo;
	
	public List<Statement> getByAmountRange(String fromAmount, String toAmount){
		List<Statement> statements = statementRepo.findAll();
		Float fromAmt = Float.valueOf(fromAmount);
		Float toAmt = Float.valueOf(toAmount);
		List<Statement> filteredList = new ArrayList<Statement>();
		for(Statement s: statements) {
			String amount = s.getAmount();
			Float amt = Float.valueOf(amount);
			if(amt.compareTo(fromAmt)==1 && amt.compareTo(toAmt) == -1) {
				s.setId(maskInt(s.getId()));
				filteredList.add(s);
			}
		}
		return filteredList;
	}
	
	public List<Statement> getByDateRange(String fromDate, String toDate){
		List<Statement> statements = statementRepo.findAll();
		List<Statement> filtered = new ArrayList<Statement>();
		fromDate = fromDate.replaceAll(".","-");
		toDate = toDate.replaceAll(".","-");
		SimpleDateFormat  s = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date fDate = s.parse(fromDate);
			Date tDate = s.parse(toDate);
			for(Statement st : statements) {
				String date = st.getDatefield();
				date = date.replaceAll(".", "-");
				Date d = s.parse(date);
				if(d.after(fDate) && d.before(tDate)) {
					st.setId(maskInt(st.getId()));
					filtered.add(st);
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filtered;
		
	} 
	
	public List<Statement> getStatement(){
		List<Statement> statements =statementRepo.findAll();
		List<Statement> filtered = new ArrayList<Statement>();
		LocalDate date = LocalDate.now().minusMonths(6);
		for(Statement s : statements) {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String de = s.getDatefield().replaceAll(".","-");
			LocalDate ld = LocalDate.parse(de,format);
			if(ld.isAfter(date)) {
				s.setId(maskInt(s.getId()));
				filtered.add(s);
			}
		}
		return filtered;
	}
	
	private int maskInt(int id) {
		return id << 4;
	}
}
