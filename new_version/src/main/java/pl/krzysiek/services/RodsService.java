package pl.krzysiek.services;

import pl.krzysiek.domain.Rods;
import java.util.List;

public interface RodsService {

    public List<Rods> listAll();
    public Rods createRod(Rods rod);
    public Rods rodToUpdate(int id, Rods rods);
    public Rods createRodWithExtraInfo(Rods rod);

}
