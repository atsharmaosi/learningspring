package com.learningspring.department.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningspring.department.controller.DepartmentController;
import com.learningspring.department.entity.Department;
import com.learningspring.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepo;

	public Department saveDepartment(Department department) {
		
		log.info("Start:inside service ->saveDepartment");
		return departmentRepo.save(department);
	}

	public Department findDepartmentById(Long departmentId) {
		return departmentRepo.findByDepartmentId(departmentId);
	}

}
