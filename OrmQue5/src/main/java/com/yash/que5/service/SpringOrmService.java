package com.yash.que5.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.que5.models.Student;
import com.yash.que5.models.StudentTestAttempt;
import com.yash.que5.models.Teacher;
import com.yash.que5.models.Test;
import com.yash.que5.models.TestQuestions;
import com.yash.que5.repo.StudentRepo;
import com.yash.que5.repo.StudentTestAttemptRepo;
import com.yash.que5.repo.TeacherRepo;
import com.yash.que5.repo.TestQuestionRepo;
import com.yash.que5.repo.TestRepo;

@Service
public class SpringOrmService {
	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private TeacherRepo teacherRepo;

	@Autowired
	private TestRepo testRepo;

	@Autowired
	private TestQuestionRepo testQuestionRepo;

	@Autowired
	private StudentTestAttemptRepo studentTestAttemptRepo;

	public Map<String, Integer> getCountQuestionByTeacher() {

		Map<String, Integer> questionByTeacher = new HashMap<String, Integer>();
		List<Teacher> teachers = teacherRepo.findAll();
		for (Teacher teacher : teachers) {
			List<Test> testIds = testRepo.findTestIdByTacherId(teacher.getTecherid());
			int count = 0;
			for (Test testId : testIds) {
				count = count + testQuestionRepo.countQuestionsByTestId(testId.getTestid());
			}
			questionByTeacher.put(teacher.getTeachername(), count);
		}
		return questionByTeacher;
	}

	public Map<String, Integer> getTeacherWithTotalNumberOftest() {
		Map<String, Integer> techerWithNumberOfTest = new HashMap<>();
		List<Teacher> teachers = teacherRepo.findAll();
		int count = 0;
		for (Teacher teacher : teachers) {
			count = testRepo.getTotalNumberOfTestByTeacherId(teacher.getTecherid());
			techerWithNumberOfTest.put(teacher.getTeachername(), count);
		}
		return techerWithNumberOfTest;
	}

	public Map<String, Double> getTotalMarksByStudentName(String studentName) {
		Map<String, Double> totalMarksOfTestByStudentName = new HashMap<>();
		double count = 0;
		int studentId = studentRepo.findByName(studentName);
		List<Test> allTest = testRepo.findAll();
		for (Test test : allTest) {
			List<StudentTestAttempt> studentTestattempts = studentTestAttemptRepo.findAllByStudentId(studentId);
			for (StudentTestAttempt studentTestattempt : studentTestattempts) {
				TestQuestions testQuestion = studentTestattempt.getQuestion();
				String correctAnswer = testQuestionRepo.findCorrectAnswer(testQuestion.getQid(), test.getTestid());
				if (correctAnswer == null) {
					continue;
				} else if (correctAnswer.equalsIgnoreCase(studentTestattempt.getMarkedAnswer().trim())) {
					count++;
				}

			}
			totalMarksOfTestByStudentName.put(test.getTestname(), count);
			count = 0;
		}
		return totalMarksOfTestByStudentName;
	}

	public Map<String, Map<String, Map<String, Double>>> getResultOfStudentByTeacherName() {
		Map<String, Map<String, Map<String, Double>>> resultOfStudentByTeacherName = new HashMap<String, Map<String, Map<String, Double>>>();
		double count = 0;
		List<Teacher> allTeachers = teacherRepo.findAll();
		List<Student> students = studentRepo.findAll();
		for (Teacher teacher : allTeachers) {
			Map<String, Map<String, Double>> resultOfStudentBySubject = new HashMap<String, Map<String, Double>>();
			for (Student student : students) {
				List<Test> tests = testRepo.findTestIdByTacherId(teacher.getTecherid());
				Map<String, Double> totalMarksOfTestByStudentName = new HashMap<>();
				for (Test test : tests) {
					List<StudentTestAttempt> studentTestattempts = studentTestAttemptRepo
							.findAllByStudentId(student.getSid());
					for (StudentTestAttempt studentTestattempt : studentTestattempts) {
						TestQuestions testQuestion = studentTestattempt.getQuestion();
						String correctAnswer = testQuestionRepo.findCorrectAnswer(testQuestion.getQid(),
								test.getTestid());
						if (correctAnswer == null) {
							continue;
						} else if (correctAnswer.equalsIgnoreCase(studentTestattempt.getMarkedAnswer().trim())) {
							count++;
						}

					}
					totalMarksOfTestByStudentName.put(test.getTestname(), count);
					count = 0;

				}
				resultOfStudentBySubject.put(student.getSname(), totalMarksOfTestByStudentName);
			}
			resultOfStudentByTeacherName.put(teacher.getTeachername(), resultOfStudentBySubject);
		}
		return resultOfStudentByTeacherName;
	}
	
	public Map<Student,Integer> getCountOfTestGivenByAllStudent()
	{
		Map<Student,Integer> countOfGivenTestByStudent=new HashMap<>();
		List<Student> allStudents=studentRepo.findAll();
		for(Student student:allStudents) {
			int count=studentTestAttemptRepo.findCountOfTestGivenByStudent(student.getSid());
			countOfGivenTestByStudent.put(student, count);
		}
		
		return countOfGivenTestByStudent;
	}
	
	public double getCountOfWrongAnswerByStudent()
	{
		List<Student> allStudents=studentRepo.findAll();
		List<Integer> listOfWrongAnswer=new ArrayList<>();
		for(Student student:allStudents) {
			
			int wrongAnswer=studentTestAttemptRepo.findCountOfWrongAnswerByStudent(student.getSid());
			listOfWrongAnswer.add(wrongAnswer);
		}
		 return listOfWrongAnswer.stream().collect(Collectors.averagingInt(e->e));
		
	}
	public double getCountOfCorrectAnswerByStudent()
	{
		List<Student> allStudents=studentRepo.findAll();
		List<Integer> listOfCorrectAnswer=new ArrayList<>();
		for(Student student:allStudents) {
			
			int correctAnswer=studentTestAttemptRepo.findCountOfCorrectAnswerByStudent(student.getSid());
			listOfCorrectAnswer.add(correctAnswer);
		}
		 return listOfCorrectAnswer.stream().collect(Collectors.averagingInt(e->e));
		
	}

}
