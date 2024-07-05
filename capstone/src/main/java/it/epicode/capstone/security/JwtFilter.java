package it.epicode.capstone.security;

import it.epicode.capstone.exceptions.UnauthorizedException;
import it.epicode.capstone.models.User;
import it.epicode.capstone.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTool jwtTool;

    @Autowired
    private UserService userService;

    public JwtFilter(JwtTool jwtTool, UserService userService) {
        this.jwtTool = jwtTool;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")){
            throw new UnauthorizedException("Token missing in request, please try again");
        }

        String token = authHeader.substring(7);

        jwtTool.verifyToken(token);

        int id = jwtTool.getIdFromUser(token);

        User user = userService.retrieveUserById(id);

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }

    private static final List<String> EXCLUDE_URLS = Arrays.asList("/api/auth/register", "/api/auth/login");

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        return EXCLUDE_URLS.stream().anyMatch(path::equalsIgnoreCase);
//        return new AntPathMatcher().match("/api/auth/**", request.getServletPath());
    }
}
