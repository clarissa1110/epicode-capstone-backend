package it.epicode.capstone.services;

import it.epicode.capstone.exceptions.UserNotFoundException;
import it.epicode.capstone.models.User;
import it.epicode.capstone.models.enums.UserRole;
import it.epicode.capstone.repositories.UserRepository;
import it.epicode.capstone.types.requests.CreateUserRequestBody;
import it.epicode.capstone.types.requests.UpdateUserRequestBody;
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

    public User addUser(CreateUserRequestBody userRequestBody){
        User userToCreate = new User();
        setUserFields(userToCreate, userRequestBody);

        return userRepository.save(userToCreate);
    }

    public User editUser(int userId, UpdateUserRequestBody userRequestBody) {
        User userToUpdate = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
        updateUserFields(userToUpdate, userRequestBody);

        return userRepository.save(userToUpdate);
    }

    public String removeUser(int userId) {
        User userToDelete = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));

        userRepository.delete(userToDelete);

        return "User with id: " + userId + " successfully deleted";
    }

    public void setUserFields(User userToCreate, CreateUserRequestBody userRequestBody) {
        userToCreate.setUsername(userRequestBody.getUsername());
        userToCreate.setEmail(userRequestBody.getEmail());
        userToCreate.setPassword(passwordEncoder.encode(userRequestBody.getPassword()));
        userToCreate.setFirstName(userRequestBody.getFirstName());
        userToCreate.setLastName(userRequestBody.getLastName());
        userToCreate.setAvatarUrl(userRequestBody.getAvatarUrl());
        userToCreate.setUserRole(UserRole.valueOf(userRequestBody.getUserRole()));
    }

    public void updateUserFields(User userToUpdate, UpdateUserRequestBody userRequestBody) {
        if (userRequestBody.getUsername() != null) {
            userToUpdate.setUsername(userRequestBody.getUsername());
        }
        if (userRequestBody.getEmail() != null) {
            userToUpdate.setEmail(userRequestBody.getEmail());
        }
        if (userRequestBody.getPassword() != null) {
            userToUpdate.setPassword(passwordEncoder.encode(userRequestBody.getPassword()));
        }
        if (userRequestBody.getFirstName() != null) {
            userToUpdate.setFirstName(userRequestBody.getFirstName());
        }
        if (userRequestBody.getLastName() != null) {
            userToUpdate.setLastName(userRequestBody.getLastName());
        }
        if (userRequestBody.getAvatarUrl() != null) {
            userToUpdate.setAvatarUrl(userRequestBody.getAvatarUrl());
        }
        if (userRequestBody.getUserRole() != null) {
            userToUpdate.setUserRole(UserRole.valueOf(userRequestBody.getUserRole()));
        }
    }
}
