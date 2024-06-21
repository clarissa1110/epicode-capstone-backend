package it.epicode.capstone.services;

import it.epicode.capstone.dto.LoginUserDto;
import it.epicode.capstone.exceptions.UnauthorizedException;
import it.epicode.capstone.models.User;
import it.epicode.capstone.security.JwtTool;
import it.epicode.capstone.types.requests.LoginUserRequestBody;
import it.epicode.capstone.types.responses.LoginUserResponseBody;
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

    public LoginUserResponseBody authenticateUserAndToken (LoginUserRequestBody loginUserRequestBody) {
        User user = userService.retrieveUserByEmail(loginUserRequestBody.getEmail());

        if (passwordEncoder.matches(loginUserRequestBody.getPassword(), user.getPassword())){
            return new LoginUserResponseBody(user, "Successfully logged in", jwtTool.createToken(user));
        }
        else throw new UnauthorizedException("User not found, please try again");
    }
}
