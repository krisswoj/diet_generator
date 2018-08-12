package pl.krzysiek.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.krzysiek.domain.User;
import pl.krzysiek.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

@RestController
public class UserApi {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String index() {
        return "Wszystko dziala ;-)";
    }


    @RequestMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User getTransmiter(@PathVariable("id") int id) throws SQLException {
        return userRepository.getById(id);
    }

    @RequestMapping(value ="/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getTransmiters() throws SQLException {
        return userRepository.getAll();
    }

//    @RequestMapping(value = "/user",
//            method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public User addTransmiter(@RequestBody User p) {
//        if (userRepository.addUser(p)) return null;
//        return p;
//    }

    @RequestMapping(value = "/transmiterDelete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteTransmiter(@PathVariable("id") int id) throws SQLException {
        User transmiterToDelete = new User();
        transmiterToDelete.setId(id);
        return new Integer(userRepository.deleteUser(transmiterToDelete));
    }
}

// test repo
