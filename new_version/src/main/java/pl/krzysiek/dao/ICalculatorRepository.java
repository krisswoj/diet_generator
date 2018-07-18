package pl.krzysiek.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.krzysiek.domain.CalorieCalculator;

@Repository
public interface ICalculatorRepository extends CrudRepository<CalorieCalculator, Integer> {

}
