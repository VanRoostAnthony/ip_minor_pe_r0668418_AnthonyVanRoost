package be.ucll.ip.project.service;

import be.ucll.ip.project.dto.CreateUserDTO;
import be.ucll.ip.project.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDTO createUser(CreateUserDTO userDTO);
}
