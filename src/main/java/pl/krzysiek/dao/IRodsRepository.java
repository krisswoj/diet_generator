package pl.krzysiek.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.krzysiek.domain.Rod;

@Repository
public interface IRodsRepository extends CrudRepository<Rod, Integer> {

    Rod findById(int id);
    void deleteById(int id);
    Rod save(Rod rod);
}
