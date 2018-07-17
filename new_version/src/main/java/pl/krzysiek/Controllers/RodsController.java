package pl.krzysiek.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import pl.krzysiek.dao.IRodsRepository;
import pl.krzysiek.domain.Rods;
import pl.krzysiek.services.RodsService;

import javax.validation.Valid;

@Controller
@SessionAttributes("register")
public class RodsController {

    @Autowired
    private IRodsRepository listRepository;

    @Autowired
    private RodsService rodsService;

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
//        modelAndView.addObject("successMessage", "Rozmiar");
        modelAndView.setViewName("add_to_list");
        return modelAndView;
    }

    @RequestMapping(value = "/show_rods", method = RequestMethod.GET)
    public ModelAndView showRods(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("counts", rodsService.listAll());
        modelAndView.setViewName("list");
        return modelAndView;
    }

}
