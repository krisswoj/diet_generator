package pl.krzysiek.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.krzysiek.domain.Rods;

@Repository
public interface IRodsRepository extends CrudRepository<Rods, Integer> {

    Rods findById(int rod_id);
    void deleteById(int rod_id);
    Rods save(Rods rod);
}
