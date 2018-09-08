package org.mdeforge.mdeforgeui;

import org.mdeforge.mdeforgeui.Model.User;
import org.mdeforge.mdeforgeui.Repository.UserRepository;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

@Component
public class MongoInitiailizer implements SmartInitializingSingleton {

    private final UserRepository userRepository;

    public MongoInitiailizer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void afterSingletonsInstantiated() {

        String passsword = "73ac8218b92f7494366bf3a03c0c2ee2095d0c03a29cb34c95da327c7aa17173248af74d46ba2d4c";

        User martha = new User(""+1L, "martha@example.com", "{sha256}"+passsword, "Martha", "Caro");
        User carlos = new User(""+100L,"c.avendano10@gmail.com", "{sha256}"+passsword, "Carlos", "Avendano");

        this.userRepository.save(martha);
        this.userRepository.save(carlos);

    }
}
