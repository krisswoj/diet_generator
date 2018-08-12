package pl.krzysiek.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.krzysiek.domain.ReadyMeal;

@Repository
public interface IReadyMealsRepository extends CrudRepository<ReadyMeal, Integer> {

    public ReadyMeal findByMealId(int id);
}
