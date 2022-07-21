package com.yash.que5.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.que5.models.StudentTestAttempt;

@Repository
public interface StudentTestAttemptRepo extends JpaRepository<StudentTestAttempt,Integer>{
	
	@Query(value="select * from student_test_attempt where studentid=?1",nativeQuery = true)
	List<StudentTestAttempt> findAllByStudentId(int id);
	
	@Query(value="select count(*) from (select count(*) from student_test_attempt st inner join test_questions tq on st.qid= tq.qid where st.studentid=?1 group by tq.testid) as result",nativeQuery = true)
	Integer findCountOfTestGivenByStudent(int sid);

	@Query(value="select count(*) from student_test_attempt st inner join test_questions tq on st.qid= tq.qid where st.studentid=?1 and st.marked_answer != tq.correctanswer",nativeQuery = true)
	Integer findCountOfWrongAnswerByStudent(int sid);
	
	@Query(value="select count(*) from student_test_attempt st inner join test_questions tq on st.qid= tq.qid where st.studentid=?1 and st.marked_answer = tq.correctanswer",nativeQuery = true)
	Integer findCountOfCorrectAnswerByStudent(int sid);
}
