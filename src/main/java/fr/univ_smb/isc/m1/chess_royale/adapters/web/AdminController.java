package fr.univ_smb.isc.m1.chess_royale.adapters.web;

import fr.univ_smb.isc.m1.chess_royale.application.ChessRoyaleClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class AdminController {

    private final ChessRoyaleClientService chessRoyaleClientService;

    public AdminController(ChessRoyaleClientService chessRoyaleClientService) {
        this.chessRoyaleClientService = chessRoyaleClientService;
    }

    @GetMapping(value = "/admin")
    public String home(Model model) {
        model.addAttribute("users", chessRoyaleClientService.users());
        return "admin";
    }

    @PostMapping(value = "/admin/delete", params = {"userId"})
    public String removeRow(HttpServletRequest req) {
        Long userId = Long.valueOf(req.getParameter("userId"));
        chessRoyaleClientService.deleteUser(userId);
        return "redirect:/admin";
    }

    @PostMapping("/admin/create")
    public String pidUserSubmit(@RequestParam(name = "name") String name,
                                @RequestParam(name = "hash") String hash,
                                @RequestParam(name = "lichessAPIToken") String lichessAPIToken,
                                Principal principal) {
        String author = principal.getName();
        chessRoyaleClientService.createUser(name, hash, lichessAPIToken);
        return "redirect:/admin";
    }
}