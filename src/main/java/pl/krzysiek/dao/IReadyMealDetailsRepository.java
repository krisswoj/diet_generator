package pl.krzysiek.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.krzysiek.domain.ReadyMealDetails;

import java.util.List;

@Repository
public interface IReadyMealDetailsRepository extends CrudRepository<ReadyMealDetails, Integer> {
    List<ReadyMealDetails> findAllById(int id);
}
