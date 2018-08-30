package pl.krzysiek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.krzysiek.domain.Account;
import pl.krzysiek.domain.enums.Notifications;
import pl.krzysiek.services.AccountService;

import javax.validation.Valid;

@Controller
@SessionAttributes("register")
public class RegisterController {

    @Autowired
    private AccountService accountService;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("account", new Account());
        modelAndView.setViewName("login/register");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid Account account, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (accountService.findUserByEmail(account) != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            String.valueOf(Notifications.FAILED_REGISTER_ACCOUNT));
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("login/register");
        } else {
            accountService.addAccount(account);
            modelAndView.addObject("successMessage", Notifications.SUCCESS_REGISTER_ACCOUNT);
            modelAndView.addObject("account", new Account());
            modelAndView.setViewName("login/register");
        }
        return modelAndView;
    }
}