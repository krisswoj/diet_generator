package pl.krzysiek.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.krzysiek.dao.IListRepository;
import pl.krzysiek.domain.Rods;
import pl.krzysiek.domain.User;
import pl.krzysiek.repository.UserRepository;
import pl.krzysiek.services.ListService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@Transactional
@RestController
public class UserApi {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ListService listService;

    @Autowired
    IListRepository listRepository;

    @RequestMapping("/test-control")
    public String index() {
        return "Wszystko dziala ;-)";
    }


    @RequestMapping(value = "/rods-rest/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Rods getRod(@PathVariable("id") int id) throws SQLException {
        return listRepository.findById(id);
    }

    @RequestMapping(value = "/rods-rest", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Rods> getRods() throws SQLException {
        return listService.listAll();
    }

    @RequestMapping(value ="/rods-rest", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Rods addRod(@RequestBody Rods rod) {
        Rods addedRod = listService.createRod(rod);
        return addedRod;
    }

    @RequestMapping(value = "/rods-test/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteRods(@PathVariable("id") int id) throws SQLException {
        listRepository.deleteById(id);
        return String.format("Wedka o id  #%d zostala usunieta", id);
    }

    @RequestMapping(value = "/rods-rest/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Rods rodToUpdate(@PathVariable("id") int id, @RequestBody Rods rod){
        return listService.rodToUpdate(id, rod);
    }




}
