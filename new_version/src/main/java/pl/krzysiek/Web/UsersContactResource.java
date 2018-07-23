package pl.krzysiek.Web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.krzysiek.dao.UsersContactRepository;
import pl.krzysiek.domain.Users;
import pl.krzysiek.domain.UsersContact;
import pl.krzysiek.domain.UsersLog;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/rest/userscontact")
@RestController
public class UsersContactResource {

    private UsersContactRepository usersContactRepository;

    public UsersContactResource(UsersContactRepository usersContactRepository) {
        this.usersContactRepository = usersContactRepository;
    }

    @GetMapping(value = "/all")
    public List<UsersContact> getUsersContact() {
        return usersContactRepository.findAll();
    }

    @GetMapping(value = "/update/{name}")
    public List<UsersContact> update(@PathVariable final String name) {

        UsersContact usersContact = new UsersContact();
        Users users = new Users();

        UsersLog usersLog = new UsersLog();
        usersLog.setLog("HI Youtube");

        UsersLog usersLog2 = new UsersLog();
        usersLog2.setLog("HI Viewers");

        users.setTeamName("Development")
                .setSalary(10000)
                .setName(name)
                .setUsersLogs(Arrays.asList(usersLog, usersLog2));

        usersContact.setPhoneNo(11111)
                .setUsers(users);

        //persist
        usersContactRepository.save(usersContact);

        //getall
        return usersContactRepository.findAll();


    }


}
