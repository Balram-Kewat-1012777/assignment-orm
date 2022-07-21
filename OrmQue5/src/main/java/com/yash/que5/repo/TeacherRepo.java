package com.yash.que5.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.que5.models.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher,Integer>{

}
