package pl.krzysiek.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysiek.dao.IRodsRepository;
import pl.krzysiek.domain.Rod;

import java.util.ArrayList;
import java.util.List;

@Service("ListService")
@Transactional
public class RodsServiceImpl implements RodService {


    @Autowired
    IRodsRepository rodsRepository;

    public List<Rod> listAll() {
        List<Rod> counts = new ArrayList<>();
        rodsRepository.findAll().forEach(counts::add);
        return counts;
    }

    public Rod createRod(Rod rod){
        return rodsRepository.save(rod);
    }

    public Rod rodToUpdate(int id, Rod rods) {
        Rod updatedRod = rodsRepository.findById(id);
        if (!rods.getPrice().equals(updatedRod.getPrice())) {
            updatedRod.setPrice(rods.getPrice());
            return rodsRepository.save(updatedRod);
        } else
            return null;
    }

    public Rod createRodWithExtraInfo(Rod rod){
        rod.setOptionalInformation("Dodano przez inny formularz");
        return rodsRepository.save(rod);
    }












}
