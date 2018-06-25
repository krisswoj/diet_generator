package pl.krzysiek.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import pl.krzysiek.dao.IAccountRepository;
import pl.krzysiek.dao.IListRepository;
import pl.krzysiek.domain.Account;
import pl.krzysiek.domain.Rods;
import pl.krzysiek.services.ListService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@SessionAttributes("register")
public class RegisterController {

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private IListRepository listRepository;

    @Autowired
    private ListService listService;

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

        if (accountExistsNick != null) {
            bindingResult.rejectValue("name", "error.name", "Obecny nick jest juz zarejestrowany w bazie");
            modelAndView.setViewName("register");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        } else {
            accountRepository.save(account);
            modelAndView.addObject("account", new Account());
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.setViewName("register");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/add_rod", method = RequestMethod.POST)
    public ModelAndView addRod(@Valid Rods rod) {
        ModelAndView modelAndView = new ModelAndView();

        if (!rod.getRod_brand().isEmpty() && !rod.getRod_model().isEmpty()) {
            listRepository.save(rod);
            modelAndView.addObject("successMessage", "Wedka została dodana, dziękujemy");
            modelAndView.addObject("rod", new Rods());
            modelAndView.setViewName("add_to_list");
            return modelAndView;
        } else {
            modelAndView.addObject("successMessage", "Wystąpił błąd - wędka nie została dodana");
            modelAndView.setViewName("add_to_list");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/add_rod", method = RequestMethod.GET)
    public ModelAndView addRod() {
        ModelAndView modelAndView = new ModelAndView();
        Rods rod = new Rods();
        modelAndView.addObject("rod", rod);
        modelAndView.addObject("successMessage", "Rozmiar Iterable: " + listService.listAll().size());
        modelAndView.setViewName("add_to_list");
        return modelAndView;
    }

    @RequestMapping(value = "/show_rods", method = RequestMethod.GET)
    public ModelAndView showRods(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("counts", listService.listAll());
        modelAndView.setViewName("list");
        return modelAndView;
    }


}