package com.example.soap_poc.service;

import com.example.soap_poc.dto.UserDTO;
import com.example.soap_poc.entity.User;
import com.example.soap_poc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO getUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return getDTO(user);
    }

    public UserDTO addUser(UserDTO userDTO){
      return getDTO( userRepository.save(userDtoToUser(userDTO)));
    }

    // Helper Method
    public UserDTO getDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setMobileNo(user.getMobileNo());
        return userDTO;
    }

    // Helper Method
    public User userDtoToUser(UserDTO userDTO){
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setMobileNo(userDTO.getMobileNo());
        return user;
    }
}
