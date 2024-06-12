package it.epicode.capstone.controllers;

import it.epicode.capstone.dto.LoginUserDto;
import it.epicode.capstone.dto.UserDto;
import it.epicode.capstone.services.AuthService;
import it.epicode.capstone.services.UserService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public String register(@RequestBody @Validated UserDto userDto,
                           BindingResult validation) throws BadRequestException {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors()
                    .stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("", (acc, curr) -> acc + curr));
        }
        return userService.addUser(userDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody @Validated LoginUserDto loginUserDto, BindingResult validation) throws BadRequestException {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors()
                    .stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("", (acc, curr) -> acc + curr));
        }
        return authService.authenticateUserAndToken(loginUserDto);
    }
}
