package pl.krzysiek.repository;
import pl.krzysiek.domain.ZawodyZapisy;

import java.util.List;
import java.sql.SQLException;


public interface ZawodyZapisyRepository{

    public List<ZawodyZapisy> getAll();
    public ZawodyZapisy getById(int id) throws SQLException;
    public void addZawodyZapisy(ZawodyZapisy zawodyZapisy);
    public void deleteZawodyZapisy(int IdZawodnika) throws SQLException;
    public void updateZawodyZapisy(int oldId, ZawodyZapisy newZawodyZapisy) throws SQLException;
    public void dropTable() throws SQLException;

}