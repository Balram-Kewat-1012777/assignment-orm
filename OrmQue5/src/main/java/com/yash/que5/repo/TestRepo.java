package com.yash.que5.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.que5.models.Test;

@Repository
public interface TestRepo extends JpaRepository<Test, Integer>{
	
	@Query(value="SELECT * FROM test t WHERE t.techerid = ?1", nativeQuery = true)
	List<Test> findTestIdByTacherId(Integer id);
	
	@Query(value="select count(*) from test where techerid =?1", nativeQuery = true)
	Integer getTotalNumberOfTestByTeacherId(Integer id);
	
	
}
