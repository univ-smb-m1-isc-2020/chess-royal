package fr.univ_smb.isc.m1.chess_royale.adapters.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/test")
public class AuthenticationTestController {
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("This page is only visible after a successful login as admin, congrats");
    }
}