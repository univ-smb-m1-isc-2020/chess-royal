package fr.univ_smb.isc.m1.chess_royale.adapters.web;

import fr.univ_smb.isc.m1.chess_royale.application.ChessRoyaleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class AdminController {

    private final ChessRoyaleService chessRoyaleService;

    public AdminController(ChessRoyaleService chessRoyaleService) {
        this.chessRoyaleService = chessRoyaleService;
    }

    @GetMapping(value = "/admin")
    public String home(Model model) {
        model.addAttribute("facts", chessRoyaleService.users());
        return "admin";
    }

    @PostMapping(value = "/admin/delete", params = {"userId"})
    public String removeRow(HttpServletRequest req) {
        Long userId = Long.valueOf(req.getParameter("userId"));
        chessRoyaleService.delete(userId);
        return "redirect:/admin";
    }

    @PostMapping("/admin/create")
    public String pidUserSubmit(@RequestParam(name = "name") String name,
                                @RequestParam(name = "hash") String hash,
                                Principal principal) {
        //TODO: fix parameters
        String author = principal.getName();
        chessRoyaleService.create(name, hash);
        return "redirect:/admin";
    }



}