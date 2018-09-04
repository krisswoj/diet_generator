package pl.krzysiek.dao;

        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;
        import pl.krzysiek.domain.Account;
        import pl.krzysiek.domain.CalorieCalculator;

        import java.util.List;

@Repository
public interface ICalculatorRepository extends CrudRepository<CalorieCalculator, Integer> {


    List<CalorieCalculator> findByCalorieCalculatorAccount(Account account);
}
