package org.mdeforge.mdeforgeviewservice.dao;

import java.util.List;
import org.mdeforge.servicemodel.common.BusinessException;
import org.mdeforge.mdeforgeviewservice.model.*;

public interface UserService {

	public User createUser(User user) throws BusinessException;				
	public void updateUser(User user) throws BusinessException;			
	public User findUser(String id) throws BusinessException;
    public User findUserByEmail(String email) throws BusinessException;
    public User findUserByUsername(String username) throws BusinessException;
	public void deleteUser(User user) throws BusinessException;
	public List<User> findAll() throws BusinessException;

}	
