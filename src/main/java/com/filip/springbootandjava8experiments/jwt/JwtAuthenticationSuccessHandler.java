package com.filip.springbootandjava8experiments.jwt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * This simple override removes the default behavior of a successful authentication (redirecting to
 * home or any other page the user requested). If you are wondering why we do not need to override
 * the AuthenticationFailureHandler, it is because default implementation will not redirect anywhere
 * if its redirect URL is not set, so we just avoid setting the URL, which is good enough.
 */
public class JwtAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) {
    // We do not need to do anything extra on REST authentication success, because there is no page to redirect to
  }

}