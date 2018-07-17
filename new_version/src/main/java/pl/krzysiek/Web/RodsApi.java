package pl.krzysiek.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.krzysiek.dao.IRodsRepository;
import pl.krzysiek.domain.Rods;
import pl.krzysiek.services.RodsService;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Transactional
@RestController
public class RodsApi {


    @Autowired
    RodsService rodsService;

    @Autowired
    IRodsRepository listRepository;

    @RequestMapping("/")
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
        return rodsService.listAll();
    }

    @RequestMapping(value ="/rods-rest", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Rods addRod(@RequestBody Rods rod) {
        Rods addedRod = listRepository.save(rod);
        return addedRod;
    }

    @RequestMapping(value = "/rods-test", method = GET)
    @ResponseBody
    public String deleteRods(@RequestParam("id") int id) throws SQLException {
        listRepository.deleteById(id);
        return String.format("Wedka o id  #%d zostala usunieta", id);
    }

    @RequestMapping(value = "/rods-test/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteRodss(@PathVariable("id") int id) throws SQLException {
        listRepository.deleteById(id);
        return String.format("Wedka o id  #%d zostala usunieta", id);
    }

    @RequestMapping(value = "/rods-rest/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Rods rodToUpdate(@PathVariable("id") int id, @RequestBody Rods rod){
        return rodsService.rodToUpdate(id, rod);
    }

    @RequestMapping(value = "/rods-update/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Rods updateRods(@RequestBody Rods rod, @PathVariable("id") int id) throws SQLException{
        Rods addedRod = rod;
        addedRod.setRod_id(id);
        return listRepository.save(addedRod);
    }

    @RequestMapping(value = "/extra-info", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Rods RodsWithExtraInfo(@RequestBody Rods rod) {
        Rods addedRecord = rodsService.createRodWithExtraInfo(rod);
        return addedRecord;
    }
}
