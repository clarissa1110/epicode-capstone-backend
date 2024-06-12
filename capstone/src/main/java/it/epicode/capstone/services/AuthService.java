package it.epicode.capstone.services;

import it.epicode.capstone.dto.LoginUserDto;
import it.epicode.capstone.exceptions.UnauthorizedException;
import it.epicode.capstone.models.User;
import it.epicode.capstone.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtTool jwtTool;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticateUserAndToken (LoginUserDto loginUserDto) {
        User user = userService.retrieveUserByEmail(loginUserDto.getEmail());

        if (passwordEncoder.matches(loginUserDto.getPassword(), user.getPassword())){
            jwtTool.createToken(user);

            return "Successfully logged in!";
        }
        else throw new UnauthorizedException("User not found, please try again");
    }
}
