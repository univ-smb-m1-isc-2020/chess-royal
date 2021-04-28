package fr.univ_smb.isc.m1.chess_royale.adapters.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("hello")
public class HelloRESTController
{
    @GetMapping("user")
    public String helloUser(Principal principal) {
        return "Hello user : " + principal.getName() +" \n\n\n " + principal.toString();
    }

    @GetMapping("admin")
    public String helloAdmin(Principal principal) {
        return "Hello admin : " + principal.getName();
    }

}