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
		return userRepository.save(user);
	}
				
	@Override
	public void updateUser(User user) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("updateUser(User user) - UserServiceImpl - MdeforgeviewService");
        userRepository.save(user);
	}
			
	@Override
	public User findUser(String id) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("findUser(String id) - UserServiceImpl - MdeforgeviewService");
		return userRepository.findOne(id);
	}

    @Override
    public User findUserByEmail(String email) throws BusinessException {
        log.info("findUserByEmail(String email) - UserServiceImpl - MdeforgeviewService");
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User findUserByUsername(String username) throws BusinessException {
        log.info("findUserByUsername(String username) - UserServiceImpl - MdeforgeviewService");
        return userRepository.findUserByUsername(username);
    }

    @Override
	public void deleteUser(User user) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("deleteUser(String id) - UserServiceImpl - MdeforgeviewService");
        userRepository.delete(user);
	}
			
	@Override
	public List<User> findAll() throws BusinessException{
		log.info("findAll() - UserServiceImpl - MdeforgeviewService");
		return userRepository.findAll();
	}

}
