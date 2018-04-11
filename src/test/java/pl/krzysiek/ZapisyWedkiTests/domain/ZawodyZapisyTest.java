package pl.krzysiek.ZapisyWedkiTests.domain;


import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import pl.krzysiek.domain.ZawodyZapisy;
import pl.krzysiek.repository.ZawodyZapisyFactory;
import pl.krzysiek.repository.ZawodyZapisyRepository;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class ZawodyZapisyTest {

    ZawodyZapisyRepository zawodyZapisyRepository;

    @Test
    public void czyZapisano() {
        ZawodyZapisy zapis = new ZawodyZapisy();
        assertNotNull(zapis);
    }

    @Test
    public void getById() throws SQLException {
        int idToFind = zawodyZapisyRepository.getAll().size() - 1;
        assertNotNull(zawodyZapisyRepository.getById(idToFind));
    }

    @Test
    public void addZawodyZapis() throws SQLException {
        ZawodyZapisy nowyZawodnik = new ZawodyZapisy();
        nowyZawodnik.setImie("Krzysztof xgfhcjgkhl");
        nowyZawodnik.setWiek(23);
        zawodyZapisyRepository.addZawodyZapisy(nowyZawodnik);
        assertNotNull(zawodyZapisyRepository.getById(zawodyZapisyRepository.getAll().size() - 1));
    }


    @Test
    public void deleteZawodyZapis() throws SQLException {

        int idPierwszegoZawodnika = zawodyZapisyRepository.getById(zawodyZapisyRepository.getAll().size()-2).getId();
        int idDrugiegoZawodnika = zawodyZapisyRepository.getById(zawodyZapisyRepository.getAll().size()-3).getId();

        int wiekDrugiegoZawodnika = zawodyZapisyRepository.getById(idDrugiegoZawodnika).getWiek();

        zawodyZapisyRepository.deleteZawodyZapisy(idPierwszegoZawodnika);

        assertEquals(zawodyZapisyRepository.getById(idPierwszegoZawodnika), null);
        assertEquals(zawodyZapisyRepository.getById(idDrugiegoZawodnika).getWiek(), wiekDrugiegoZawodnika);
    }

    @Test
    public void updateZawodyZapis() throws SQLException {


        int idPierwszegoZawodnika = zawodyZapisyRepository.getById(zawodyZapisyRepository.getAll().size() - 2).getId();
        int idDrugiegoZawodnika = zawodyZapisyRepository.getById(zawodyZapisyRepository.getAll().size() - 3).getId();
        int wiekDrugiegoZawodnika = zawodyZapisyRepository.getById(idDrugiegoZawodnika).getWiek();

        ZawodyZapisy newAgeForPierwszyZawodnik = new ZawodyZapisy();
        newAgeForPierwszyZawodnik.setImie("new age for test1");
        newAgeForPierwszyZawodnik.setWiek(666);

        zawodyZapisyRepository.updateZawodyZapisy(idPierwszegoZawodnika, newAgeForPierwszyZawodnik);

        assertEquals(zawodyZapisyRepository.getById(idPierwszegoZawodnika).getWiek(), newAgeForPierwszyZawodnik.getWiek());
        assertEquals(zawodyZapisyRepository.getById(idDrugiegoZawodnika).getWiek(), wiekDrugiegoZawodnika);
    }


    @Test
    public void getAll() {
        assertNotNull(zawodyZapisyRepository.getAll());
    }

    @Before
    public void inicjacjaRepository() {
        zawodyZapisyRepository = ZawodyZapisyFactory.getInstance();
        ZawodyZapisy szymek = new ZawodyZapisy();
        ZawodyZapisy tomek = new ZawodyZapisy();
        ZawodyZapisy mateusz = new ZawodyZapisy();

        szymek.setImie("Szymon");
        szymek.setWiek(263);

        tomek.setImie("Tomasz");
        tomek.setWiek(11);

        mateusz.setImie("Mateusz");
        mateusz.setWiek(45);

        zawodyZapisyRepository.addZawodyZapisy(szymek);
        zawodyZapisyRepository.addZawodyZapisy(tomek);
        zawodyZapisyRepository.addZawodyZapisy(mateusz);


    }

    @After
    public void dropTable() throws SQLException{
        zawodyZapisyRepository.dropTable();
    }
}