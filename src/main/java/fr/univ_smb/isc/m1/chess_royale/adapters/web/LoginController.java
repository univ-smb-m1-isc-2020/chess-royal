package fr.univ_smb.isc.m1.chess_royale.adapters.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(value = "/")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/create-account-page")
    public String createAccount(){
        return "create-account";
    }
}
