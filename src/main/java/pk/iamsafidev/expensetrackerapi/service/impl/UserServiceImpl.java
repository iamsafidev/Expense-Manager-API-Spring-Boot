package pk.iamsafidev.expensetrackerapi.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.iamsafidev.expensetrackerapi.entity.User;
import pk.iamsafidev.expensetrackerapi.entity.UserModel;
import pk.iamsafidev.expensetrackerapi.exceptions.ItemAlreadyExistsException;
import pk.iamsafidev.expensetrackerapi.repository.UserRepository;
import pk.iamsafidev.expensetrackerapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserModel userModel) {
        if (userRepository.existsByEmail(userModel.getEmail()))
            throw new ItemAlreadyExistsException("User is already registered with email: " + userModel.getEmail());
        User user = new User();
        BeanUtils.copyProperties(userModel, user);
        return userRepository.save(user);
    }
}
