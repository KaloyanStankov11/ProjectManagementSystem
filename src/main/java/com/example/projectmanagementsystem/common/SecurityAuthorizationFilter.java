package com.example.projectmanagementsystem.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.projectmanagementsystem.model.AppUser;
import com.example.projectmanagementsystem.service.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static com.example.projectmanagementsystem.common.SecurityConstants.*;

@Component
public class SecurityAuthorizationFilter extends OncePerRequestFilter {

    protected static Logger logger = LoggerFactory.getLogger("JWT");
    @Autowired
    SecurityService securityService;

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(SECURITY_HEADER_NAME);

        String defaultURL = "http://localhost:8080";
        logger.info("Authorizing request with token: {}", header);

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            logger.error("Invalid token format");
            chain.doFilter(req, res);
            return;
        } else if (defaultURL.concat(SIGN_UP_URL).equals(req.getRequestURL().toString())) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(SECURITY_HEADER_NAME).replace(TOKEN_PREFIX, "");
        logger.info("Getting authentication for token: {}", token);
        if (!token.equals("")) {
            String username = JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
                    .build()
                    .verify(token)
                    .getSubject();

            if (username != null) {
                AppUser currentUser = securityService.getAppUserByUsername(username);
                if (currentUser == null) {
                    logger.error("User does not exists");
                    return null;
                }
                Set<SimpleGrantedAuthority> authorities = new HashSet<>();
                    authorities.add(new SimpleGrantedAuthority(currentUser.getUserRole().getRoleName()));
                return new UsernamePasswordAuthenticationToken(username, null, authorities);
            }
            logger.error("Username is null");
            return null;
        }
        logger.error("Token is empty");
        return null;
    }

}
