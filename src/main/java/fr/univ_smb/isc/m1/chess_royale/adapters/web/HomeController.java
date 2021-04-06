package fr.univ_smb.isc.m1.chess_royale.adapters.web;

public class HomeController {
}


package fr.univ_smb.isc.m1.chuck_facts.adapters.web;

        import fr.univ_smb.isc.m1.chuck_facts.application.ChuckFactsService;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ChuckFactsService chuckFactsService;

    public HomeController(ChuckFactsService chuckFactsService) {
        this.chuckFactsService = chuckFactsService;
    }

    @GetMapping(value="/")
    public String home(Model model) {
        model.addAttribute("facts", chuckFactsService.facts());
        return "home";
    }

}