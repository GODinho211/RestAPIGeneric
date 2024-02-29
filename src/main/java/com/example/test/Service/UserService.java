package com.example.test.Service;

import com.example.test.Repository.UserRepository;
import com.example.test.model.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){

        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(n -> users.add(n));
        return users;
    }
    public void save(User data){
        userRepository.save(data);
    }


    public void delete(long userId) {
        userRepository.deleteById(userId);
    }

    public User findById(long userId) {
        Optional<User> optionalUser = userRepository.findById(userId); //optional permite que o objeto possa ou nao ser null
        return optionalUser.orElse(null);
    }


//    public void update(long userId, User updatedUserData) {
//        User user = userRepository.findById(userId).orElse(null);
//        if (user != null) {
//            user.setName(updatedUserData.getName());
//            user.setAge(updatedUserData.getAge());
//            userRepository.save(user);
//        }
//    }

}
