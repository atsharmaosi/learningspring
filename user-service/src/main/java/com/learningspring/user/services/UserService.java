package com.learningspring.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learningspring.user.entity.Department;
import com.learningspring.user.entity.ReponseTemplateVO;
import com.learningspring.user.entity.User;
import com.learningspring.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("Start:inside UserService ->saveUser");
		return userRepository.save(user);
	}

	public User findUserById(Long userId) {
		log.info("Start:inside UserService ->findUserById");
		return userRepository.findByUserId(userId);
	}

	public ReponseTemplateVO getUserWithDepartment(Long userId) {
		ReponseTemplateVO reponseTemplateVO=new ReponseTemplateVO();
		User user=userRepository.findByUserId(userId);
		Department department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/"+user.getUserId(), Department.class);
		reponseTemplateVO.setDepartment(department);
		reponseTemplateVO.setUser(user);
		return reponseTemplateVO;
	}

}
