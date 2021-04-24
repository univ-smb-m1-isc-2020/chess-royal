package fr.univ_smb.isc.m1.chess_royale.adapters.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/admin/test")
public class AuthenticationTestController {
    @GetMapping
    public ResponseEntity<String> test(Principal principal) {
        return ResponseEntity.ok("This page is only visible after a successful login as admin " + principal.getName() + ", congrats");
    }
}