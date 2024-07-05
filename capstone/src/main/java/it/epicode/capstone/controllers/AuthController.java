package it.epicode.capstone.controllers;

import it.epicode.capstone.models.User;
import it.epicode.capstone.services.AuthService;
import it.epicode.capstone.services.UserService;
import it.epicode.capstone.types.requests.CreateUserRequestBody;
import it.epicode.capstone.types.requests.LoginUserRequestBody;
import it.epicode.capstone.types.responses.LoginUserResponseBody;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Validated CreateUserRequestBody userRequestBody,
                                         BindingResult validation) throws BadRequestException {
        System.out.println(userRequestBody);
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors()
                    .stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("", (acc, curr) -> acc + curr));
        }

        return new ResponseEntity<>(userService.addUser(userRequestBody), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginUserResponseBody> login(@RequestBody @Validated LoginUserRequestBody loginUserRequestBody, BindingResult validation) throws BadRequestException {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors()
                    .stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("", (acc, curr) -> acc + curr));
        }
        return new ResponseEntity<>(authService.authenticateUserAndToken(loginUserRequestBody), HttpStatus.OK) ;
    }
}
