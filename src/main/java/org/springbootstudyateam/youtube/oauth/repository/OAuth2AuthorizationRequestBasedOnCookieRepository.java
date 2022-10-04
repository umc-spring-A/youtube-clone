package org.springbootstudyateam.youtube.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Repository
public interface OAuth2AuthorizationRequestBasedOnCookieRepository extends JpaRepository<OAuth2AuthorizationRequestBasedOnCookieRepository,Long> {
    void removeAuthorizationRequestCookies(HttpServletRequest request, HttpServletResponse response);
}