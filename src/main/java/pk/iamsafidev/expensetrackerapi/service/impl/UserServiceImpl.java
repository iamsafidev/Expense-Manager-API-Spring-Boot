package pk.iamsafidev.expensetrackerapi.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pk.iamsafidev.expensetrackerapi.entity.User;
import pk.iamsafidev.expensetrackerapi.entity.UserModel;
import pk.iamsafidev.expensetrackerapi.exceptions.ItemAlreadyExistsException;
import pk.iamsafidev.expensetrackerapi.exceptions.ResourceNotFoundException;
import pk.iamsafidev.expensetrackerapi.repository.UserRepository;
import pk.iamsafidev.expensetrackerapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(UserModel userModel) {
        if (userRepository.existsByEmail(userModel.getEmail()))
            throw new ItemAlreadyExistsException("User is already registered with email: " + userModel.getEmail());
        User user = new User();
        BeanUtils.copyProperties(userModel, user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User read() {
        Long userId = getLoggedInUser().getId();
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for id :" + userId));
    }

    @Override
    public User update(User user) {
        User existingUser = read();
        existingUser.setName(user.getName() != null ? user.getName() : existingUser.getName());
        existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());
        existingUser.setPassword(user.getPassword() != null ? passwordEncoder.encode(user.getPassword()) : existingUser.getPassword());
        existingUser.setAge(user.getAge() != null ? user.getAge() : existingUser.getAge());
        return userRepository.save(existingUser);
    }

    @Override
    public void delete() {
        User user = read();
        userRepository.delete(user);
    }

    @Override
    public User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User not found for email" + email));
    }
}
