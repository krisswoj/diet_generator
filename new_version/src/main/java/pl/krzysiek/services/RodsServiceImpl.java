package pl.krzysiek.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysiek.dao.IRodsRepository;
import pl.krzysiek.domain.Rods;

import java.util.ArrayList;
import java.util.List;

@Service("ListService")
@Transactional
public class RodsServiceImpl implements RodsService {


    @Autowired
    IRodsRepository rodsRepository;

    public List<Rods> listAll() {
        List<Rods> counts = new ArrayList<>();
        rodsRepository.findAll().forEach(counts::add);
        return counts;
    }

    public Rods createRod(Rods rod){
        return rodsRepository.save(rod);
    }

    public Rods rodToUpdate(int id, Rods rods) {
        Rods updatedRod = rodsRepository.findById(id);
        if (!rods.getRod_price().equals(updatedRod.getRod_price())) {
            updatedRod.setRod_price(rods.getRod_price());
            return rodsRepository.save(updatedRod);
        } else
            return null;
    }

    public Rods createRodWithExtraInfo(Rods rod){
        rod.setOptional_information("Dodano przez inny formularz");
        return rodsRepository.save(rod);
    }












}
