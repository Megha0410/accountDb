package com.app.accountdb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.app.accountdb.entity.*;

@Repository
public interface AccountInterfaceRepository extends CrudRepository<Account, Integer>{
	
}
