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

        List<Role> roleList = new ArrayList<>();
        roleList.add(new Role("546f7ba5ce248eba4487eda5", "ROLE_USER"));

        user.setRoles(roleList);
        user.setState(UserState.CREATED);

        List<RoleInfo> roleInfoList = new ArrayList<>();
        roleInfoList.add(new RoleInfo("546f7ba5ce248eba4487eda5", "ROLE_USER"));

		UserInfo userInfo = new UserInfo(user.getFirstname(), user.getLastname(), user.getEmail(), user.getUsername(), user.getState().toString(), user.getPassword(), roleInfoList, user.getImage());

		List<UserDomainEvent> events = singletonList(new UserCreatedEvent(userInfo));
		ResultWithDomainEvents<User, UserDomainEvent> userAndEvents = new ResultWithDomainEvents<>(user, events);		
		
		user = userRepository.save(user);
		userAggregateEventPublisher.publish(user, userAndEvents.events);

		return user;
	}
				
	@Override
	public User updateUser(User modifiedUser) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("updateUser(User user) - UserServiceImpl - UserService");

		User user = findUser(modifiedUser.getId());

		if(user == null) {
		    return null;
        }

		modifiedUser.setState(UserState.UPDATED);
		user = userRepository.save(modifiedUser);

        List<RoleInfo> roleInfoList = new ArrayList<>();
		user.getRoles().forEach(role -> {
		    roleInfoList.add(new RoleInfo(role.getId(), role.getName()));
        });

        UserInfo userInfo = new UserInfo(user.getId(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getUsername(), user.getState().toString(), user.getPassword(), roleInfoList, user.getImage());

		List<UserDomainEvent> events = singletonList(new UserUpdatedEvent(userInfo));
		ResultWithDomainEvents<User, UserDomainEvent> userAndEvents = new ResultWithDomainEvents<>(user, events);		
		userAggregateEventPublisher.publish(user, userAndEvents.events);

		return user;
	}
			
	@Override
	public User findUser(String id) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("findUser(String id) - UserServiceImpl - UserService");
		return userRepository.findOne(id);
	}

    @Override
    public User findUserByEmail(String email) throws BusinessException {
        log.info("findUserByEmail(String id) - UserServiceImpl - UserService");
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User findUserByUsername(String username) throws BusinessException {
        log.info("findUserByUsername(String id) - UserServiceImpl - UserService");
        return userRepository.findUserByUsername(username);
    }

    @Override
	public void deleteUser(User user) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("deleteUser(User user) - UserServiceImpl - UserService");

		List<UserDomainEvent> events = singletonList(new UserDeletedEvent(new UserInfo(user.getId())));
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
