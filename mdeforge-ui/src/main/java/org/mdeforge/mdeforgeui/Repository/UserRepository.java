package org.mdeforge.mdeforgeui.Repository;

import org.mdeforge.mdeforgeui.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {

    public User findUserByEmail(String email);
}
