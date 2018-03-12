package pl.krzysiek.repository;
import pl.krzysiek.domain.ZawodyZapisy;
import java.util.List;

public interface ZawodyZapisyRepository{

    public List<ZawodyZapisy> getAll();
    public void initDatabase();
    public ZawodyZapisy getById(Long id);
    public void addZawodyZapisy(ZawodyZapisy zawodyZapisy);
    public void deleteZawodyZapisy(ZawodyZapisy zawodyZapisy);
    public void updateZawodyZapisy(Long oldId, ZawodyZapisy newZawodyZapisy);
}