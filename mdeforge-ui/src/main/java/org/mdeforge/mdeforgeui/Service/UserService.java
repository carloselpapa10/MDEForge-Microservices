package org.mdeforge.mdeforgeui.Service;

import org.mdeforge.mdeforgeui.Model.User;
import org.mdeforge.mdeforgeui.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }
}
