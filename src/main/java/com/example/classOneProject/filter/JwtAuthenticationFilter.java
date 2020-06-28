package com.example.classOneProject.filter;

import com.example.classOneProject.ForSpringSecurity.model.User;
import com.example.classOneProject.repository.UserRepository;
import com.example.classOneProject.service.imple.CustomUserDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    //for authorization first must define a KEY
    //JWT authorization come from header
    private final JwtTokenProvider jwtTokenProvider;
    private final CustomUserDetailsService customUserDetailsService;
    private final UserRepository userRepository;

    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider, CustomUserDetailsService customUserDetailsService, UserRepository userRepository) {

        this.jwtTokenProvider = jwtTokenProvider;
        this.customUserDetailsService = customUserDetailsService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //jehoto amader user ti token theke nite hobe
        try {
                String jwt = getJwtFromRequest(httpServletRequest);
                if (StringUtils.hasText(jwt)&&jwtTokenProvider.isValidateToken(jwt)) {//ekhane amader token provider er madhome token ta ke validate korte hobe so at first make a token provider...
                    Long userId = jwtTokenProvider.getUserIdFromToken(jwt);
                    User user = userRepository.findByIdAndIsActiveTrue(userId);
                    UserDetails userDetails = customUserDetailsService.loadUserByUsername(user.getUsername());
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);//for pass user details
                }
            }catch (Exception e){

            }
        filterChain.doFilter(httpServletRequest,httpServletResponse);

    }
    private String getJwtFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken)&& bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }
        return null;
    }
}
