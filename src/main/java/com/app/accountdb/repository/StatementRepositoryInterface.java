package com.app.accountdb.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.accountdb.entity.*;

@Repository
public interface StatementRepositoryInterface extends CrudRepository<Statement,Integer>{
	
	List<Statement> findAll();
	
}
