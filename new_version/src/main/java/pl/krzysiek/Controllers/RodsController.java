package pl.krzysiek.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import pl.krzysiek.dao.IRodsRepository;
import pl.krzysiek.domain.Rod;
import pl.krzysiek.services.RodService;

import javax.validation.Valid;

@Controller
@SessionAttributes("register")
public class RodsController {

    @Autowired
    private IRodsRepository rodsRepository;

    @Autowired
    private RodService rodService;

    @RequestMapping(value = "/add_rod", method = RequestMethod.POST)
    public ModelAndView addRod(@Valid Rod rod) {
        ModelAndView modelAndView = new ModelAndView();

        if (!rod.getBrand().isEmpty() && !rod.getModel().isEmpty()) {
            rodsRepository.save(rod);
            modelAndView.addObject("successMessage", "Wedka została dodana, dziękujemy");
            modelAndView.addObject("rod", new Rod());
            modelAndView.setViewName("list/add_to_list");
            return modelAndView;
        } else {
            modelAndView.addObject("successMessage", "Wystąpił błąd - wędka nie została dodana");
            modelAndView.setViewName("list/add_to_list");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/add_rod", method = RequestMethod.GET)
    public ModelAndView addRod() {
        ModelAndView modelAndView = new ModelAndView();
        Rod rod = new Rod();
        modelAndView.addObject("rod", rod);
        modelAndView.setViewName("list/add_to_list");
        return modelAndView;
    }

    @RequestMapping(value = "/show_rods", method = RequestMethod.GET)
    public ModelAndView showRods(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("counts", rodService.listAll());
        modelAndView.setViewName("list/list");
        return modelAndView;
    }

}
