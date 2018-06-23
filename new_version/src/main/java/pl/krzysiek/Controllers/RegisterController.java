package pl.krzysiek.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import pl.krzysiek.dao.IAccountRepository;
import pl.krzysiek.domain.Account;

import javax.validation.Valid;

@Controller
@SessionAttributes("register")
public class RegisterController {

    @Autowired
    private IAccountRepository accountRepository;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        Account account = new Account();
        modelAndView.addObject("account", account);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid Account account, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        Account accountExists = accountRepository.findByEmail(account.getEmail());
        Account accountExistsNick = accountRepository.findByName(account.getName());

        if (accountExists != null) {
            bindingResult.rejectValue("email", "error.user", "There is already a user registered with the email provided");
            modelAndView.setViewName("register");
        }

        if (accountExistsNick != null){
            bindingResult.rejectValue("name", "error.name", "Obecny nick jest juz zarejestrowany w bazie");
            modelAndView.setViewName("register");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        }

        else {
            accountRepository.save(account);
            modelAndView.addObject("successMessage", "User has been registered successfully - ahahah");
            modelAndView.addObject("account", new Account());
            modelAndView.setViewName("success_page");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/success_page", method = RequestMethod.GET)
    public ModelAndView success_page(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("successMessage", "User has been registered successfully - ble ble ble");
        modelAndView.setViewName("success_page");
        return modelAndView;
    }




}