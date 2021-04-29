package fr.univ_smb.isc.m1.chess_royale.adapters.web;

import fr.univ_smb.isc.m1.chess_royale.application.ChessRoyaleClientService;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;

@Controller
public class HomeController {

    private final ChessRoyaleClientService chessRoyaleClientService;

    public HomeController(ChessRoyaleClientService chessRoyaleClientService) {
        this.chessRoyaleClientService = chessRoyaleClientService;
    }

    @GetMapping(value="/home")
    public String home(Model model, Principal principal) {
        model.addAttribute("users", chessRoyaleClientService.users());
        model.addAttribute("connectedUserName", principal.getName());
        return "home";
    }

    @GetMapping(value="/post-test")
    public String postRequestTest()
    {
        var url = "https://lichess.org/api/challenge/Owydoo";

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        headers.add("Authorization", "Bearer PlbPWXEbwRg4Qb5J");

        var entity = new HttpEntity<String>("Headers", headers);

        var restTemplate = new RestTemplate();

        try
        {
            restTemplate.postForEntity(url, entity , String.class );
            return "redirect:/home";
        }
        catch (Exception e)
        {
            return "redirect:/too-many-request";
        }
    }
}