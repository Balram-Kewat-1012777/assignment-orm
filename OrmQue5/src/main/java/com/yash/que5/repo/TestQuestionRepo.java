package com.yash.que5.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yash.que5.models.TestQuestions;

public interface TestQuestionRepo extends JpaRepository<TestQuestions, Integer> {

	@Query(value="select count(*) from test_questions where testid =?1", nativeQuery = true)
	Integer countQuestionsByTestId(Integer id);
	
	@Query(value="select correctanswer from test_questions where qid=?1 and testid=?2",nativeQuery = true)
	String findCorrectAnswer(int qid,int testid);
	
}
