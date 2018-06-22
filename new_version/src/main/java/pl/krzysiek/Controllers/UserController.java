package pl.krzysiek.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.krzysiek.domain.User;
import pl.krzysiek.services.UserImpl;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class UserController {

    public List<User> transmiterList;

    @RequestMapping(value = "/users2")
    public String getAll(Map<String, Object> model) {

        try {
            UserImpl impl = new UserImpl();
            model.put("list", impl.getAll());
        } catch (Exception e) {
            Logger.getGlobal().log(Level.ALL, e.getMessage());
        }
        return "list";
    }
}