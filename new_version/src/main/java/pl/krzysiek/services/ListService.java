package pl.krzysiek.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysiek.dao.IListRepository;
import pl.krzysiek.domain.Rods;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ListService {


    @Autowired
    IListRepository listRepository;

    public List<Rods> listAll() {
        List<Rods> counts = new ArrayList<>();
        listRepository.findAll().forEach(counts::add);
        return counts;
    }

    public Rods createRod(Rods rod){
        return listRepository.save(rod);
    }

    public Rods rodToUpdate(int id, Rods rods) {
        Rods updatedRod = listRepository.findById(id);
        if (!rods.getRod_price().equals(updatedRod.getRod_price())) {
            updatedRod.setRod_price(rods.getRod_price());
            return listRepository.save(updatedRod);
        } else
            return null;
    }












}
