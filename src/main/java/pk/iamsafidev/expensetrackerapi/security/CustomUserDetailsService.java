package pk.iamsafidev.expensetrackerapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pk.iamsafidev.expensetrackerapi.entity.User;
import pk.iamsafidev.expensetrackerapi.entity.UserRoles;
import pk.iamsafidev.expensetrackerapi.repository.UserRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User existingUser = userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User not found for the email:" + email));
        return new org.springframework.security.core.userdetails.User(
                existingUser.getEmail(), existingUser.getPassword(), mapRolesToAuthorities((UserRoles) existingUser.getUserRole()));
    }

    public Collection<? extends GrantedAuthority> mapRolesToAuthorities(UserRoles roles) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(roles.getRoleName()));
        System.out.println("Testing--%%%"+roles.getRoleName());
        return authorities;
    }

/*    @Override
    public User save(UserDTO userRegisteredDTO) {
        UserRoles role = new UserRoles();
        if(userRegisteredDTO.getRole().equals("USER"))
            role = roleRepo.findByRole("ROLE_USER");
        else if(userRegisteredDTO.getRole().equals("ADMIN"))
            role = roleRepo.findByRole("ROLE_ADMIN");
        User user = new User();
        user.setEmail(userRegisteredDTO.getEmail());
        user.setUserName(userRegisteredDTO.getUserName());
        user.setPassword(passwordEncoder.encode(userRegisteredDTO.getPassword()));
        user.setRole(role);

        return userRepo.save(user);
    }*/
}