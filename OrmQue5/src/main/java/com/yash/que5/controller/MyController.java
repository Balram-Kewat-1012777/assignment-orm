package com.yash.que5.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yash.que5.models.Student;
import com.yash.que5.service.SpringOrmService;

@RestController
public class MyController {

	@Autowired
	private SpringOrmService service;

	// Write query to print total number of questions given by each teachers

	@GetMapping("/totalQuestionByTeacher")
	public Map<String, Integer> totalNumberOfQuestionByTeacher() {
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
//		System.out.println("Write query to print total number of questions given by each teachers");
		Map<String, Integer> questionByTeacher = service.getCountQuestionByTeacher();
		return questionByTeacher;
	}

	// Write query to print teacher name total number of test created
	@GetMapping("/TestByTeacher")
	public Map<String, Integer> getTeacherWithTotalNumberOftest() {
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
//		System.out.println("b. Write query to print teacher name total number of test created.");
		return service.getTeacherWithTotalNumberOftest();
	}

	// Write query to print student total marks obtained for each test for given
	// student name
	@GetMapping("/getTotalMarksByStudentName/{name}")
	public Map<String, Double> getTotalMarksByStudentName(@PathVariable String name) {
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
//System.out.println("c. Write query to print student total marks obtained for each test for given student name");
		return service.getTotalMarksByStudentName(name);

	}

	// Write query to print result of students for teacher by teacher name
	@GetMapping("/getResultOfAllStudentByTeacherName")
	public Map<String, Map<String, Map<String, Double>>> getResultOfAllStudentByTeacherName() {

//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
//		System.out.println("d. Write query to print result of students for teacher by teacher name.");
		return service.getResultOfStudentByTeacherName();
	}

	// Count how many test is given by a student
	@GetMapping("/getCountOfTestGivenByStudent")
	public Map<Student, Integer> getCountOfTestGivenByStudent() {
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
//System.out.println("e. Count how many test is given by a student");
		return service.getCountOfTestGivenByAllStudent();

	}

	// Calculate average wrong questions attempt by students.
	@GetMapping("/getAverageOfWrongAnswerByStudent")
	public double getAverageOfWrongAnswerByStudent() {
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
//		System.out.println("f. Calculate average wrong questions attempt by students.");

		return service.getCountOfWrongAnswerByStudent();
	}

	// Calculate average correct questions attempt by students
	@GetMapping("/getAverageOfCorrectAnswerByStudent")
	public double getAverageOfCorrectAnswerByStudent() {
//		System.out.println("g. Calculate average correct questions attempt by students.");
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

		return service.getCountOfCorrectAnswerByStudent();
	}
}
