package it.epicode.capstone.services;

import it.epicode.capstone.dto.UserDto;
import it.epicode.capstone.exceptions.UserNotFoundException;
import it.epicode.capstone.models.User;
import it.epicode.capstone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Page<User> retrieveAllUsers(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return userRepository.findAll(pageable);
    }

    public User retrieveUserById(int userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
    }

    public User retrieveUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));
    }

    public String addUser(UserDto userDto){
        User userToCreate = new User();
        getUserFields(userToCreate, userDto);

        userRepository.save(userToCreate);

        return "User successfully created with id: " + userToCreate.getId();
    }

    public User editUser(int userId, UserDto userDto) {
        User userToUpdate = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
        getUserFields(userToUpdate, userDto);

        return userRepository.save(userToUpdate);
    }

    public String removeUser(int userId) {
        User userToDelete = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));

        userRepository.delete(userToDelete);

        return "User with id: " + userId + " successfully deleted";
    }

    public void getUserFields(User userToCreate, UserDto userDto) {
        userToCreate.setUsername(userDto.getUsername());
        userToCreate.setEmail(userDto.getEmail());
        userToCreate.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userToCreate.setFirstName(userDto.getFirstName());
        userToCreate.setLastName(userDto.getLastName());
        userToCreate.setAvatarUrl(userDto.getAvatarUrl());
    }
}
