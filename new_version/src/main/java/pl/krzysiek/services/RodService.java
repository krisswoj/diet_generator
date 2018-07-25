package pl.krzysiek.services;

import pl.krzysiek.domain.Rod;

import java.util.List;

public interface RodService {

    public List<Rod> listAll();
    public Rod createRod(Rod rod);
    public Rod rodToUpdate(int id, Rod rods);
    public Rod createRodWithExtraInfo(Rod rod);

}
