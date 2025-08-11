package com.example.notes.controller

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController {
    @GetMapping("/me")
    fun getCurrentUser(@AuthenticationPrincipal principal: OAuth2AuthenticatedPrincipal) = mapOf(
        "sub" to principal.getAttribute<String>("sub"),
        "name" to principal.getAttribute<String>("name"),
        "email" to principal.getAttribute<String>("email"),
        "issuer" to principal.getAttribute<String>("iss")
    )
}
