package org.mdeforge.userservice.impl;

import org.mdeforge.servicemodel.common.BusinessException;
import org.mdeforge.servicemodel.user.api.events.*;
import org.mdeforge.servicemodel.user.api.info.*;
import org.mdeforge.userservice.dao.UserService;
import org.mdeforge.userservice.model.*;
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
	
	@Autowired
	private UserDomainEventPublisher userAggregateEventPublisher;

	@Override
	public User createUser(User user) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("createUser(User user) - UserServiceImpl - UserService");
		
		List<UserDomainEvent> events = singletonList(new UserCreatedEvent());
		ResultWithDomainEvents<User, UserDomainEvent> userAndEvents = new ResultWithDomainEvents<>(user, events);		
		
		user = userRepository.save(user);
		userAggregateEventPublisher.publish(user, userAndEvents.events);

		return user;
	}
				
	@Override
	public void updateUser(User user) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("updateUser(User user) - UserServiceImpl - UserService");

		List<UserDomainEvent> events = singletonList(new UserUpdatedEvent());
		ResultWithDomainEvents<User, UserDomainEvent> userAndEvents = new ResultWithDomainEvents<>(user, events);		
		userAggregateEventPublisher.publish(user, userAndEvents.events);

	}
			
	@Override
	public User findUser(String id) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("findUser(String id) - UserServiceImpl - UserService");
		return null;
	}
			
	@Override
	public void deleteUser(User user) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("deleteUser(User user) - UserServiceImpl - UserService");
		
		List<UserDomainEvent> events = singletonList(new UserDeletedEvent());
		ResultWithDomainEvents<User, UserDomainEvent> userAndEvents = new ResultWithDomainEvents<>(user, events);
		
		userRepository.delete(user);
		userAggregateEventPublisher.publish(user, userAndEvents.events);
		
	}
			
	@Override
	public List<User> findAll() throws BusinessException{
		log.info("findAll() - UserServiceImpl - UserService");
		return userRepository.findAll();
	}
	
}
