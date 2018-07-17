package pl.krzysiek.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.krzysiek.dao.IAccountRepository;
import pl.krzysiek.domain.Account;
import pl.krzysiek.domain.Rods;
import pl.krzysiek.services.AccountService;

@Controller
public class LoginController {

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login/login");
        return modelAndView;
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ModelAndView checkLogin(@RequestParam("email") String email,
//                                   @RequestParam("password") String password) {
//        ModelAndView modelAndView = new ModelAndView();
//
//        String wiadomosc;
//        if (accountService.checkPassword(email, password) == 1) {
//            wiadomosc = "Zostałeś poprawnie zalogowany";
//            modelAndView.addObject("successMessage", wiadomosc);
//            modelAndView.addObject("rod", new Rods());
//            modelAndView.setViewName("add_to_list");
//
//        } else {
//            wiadomosc = "Wprowadzone dane nie są poprawne";
//            modelAndView.addObject("successMessage", wiadomosc);
//            modelAndView.addObject("account", new Account());
//            modelAndView.setViewName("login");
//        }
//        return modelAndView;
//    }


}
