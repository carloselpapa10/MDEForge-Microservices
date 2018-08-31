package org.mdeforge.mdeforgeviewservice.impl;

import org.mdeforge.servicemodel.common.BusinessException;
import org.mdeforge.servicemodel.user.api.events.*;
import org.mdeforge.servicemodel.user.api.info.*;
import org.mdeforge.mdeforgeviewservice.dao.UserService;
import org.mdeforge.mdeforgeviewservice.model.*;
import org.mdeforge.mdeforgeviewservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static java.util.Collections.singletonList;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import io.eventuate.tram.events.aggregates.ResultWithDomainEvents;

@Component
@Transactional
public class UserServiceImpl implements UserService{

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("createUser(User user) - UserServiceImpl - MdeforgeviewService");
		return user;
	}
				
	@Override
	public void updateUser(User user) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("updateUser(User user) - UserServiceImpl - MdeforgeviewService");
	}
			
	@Override
	public User findUser(String id) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("findUser(String id) - UserServiceImpl - MdeforgeviewService");
		return null;
	}
			
	@Override
	public void deleteUser(String id) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("deleteUser(String id) - UserServiceImpl - MdeforgeviewService");
	}
			
	@Override
	public List<User> findAll() throws BusinessException{
		log.info("findAll() - UserServiceImpl - MdeforgeviewService");
		return userRepository.findAll();
	}

}
