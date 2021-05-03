package dev.fyloz.colval.jee.thymeleaf.cours.security;

import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.User;
import dev.fyloz.colval.jee.thymeleaf.cours.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userRepository.findOneByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException("User login not found"));
        return new UserPrincipal(user);
    }
}
