package com.javachinna.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javachinna.config.Profiles;
import com.javachinna.model.JwtRequest;
import com.javachinna.model.JwtResponse;
import com.javachinna.util.JwtTokenUtil;

import lombok.RequiredArgsConstructor;

@Profile(Profiles.JWT_AUTH)
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class JwtAuthenticationController {
	private final AuthenticationManager authenticationManager;
	private final JwtTokenUtil jwtTokenUtil;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
}