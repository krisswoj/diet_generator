package pl.krzysiek.ZapisyWedkiTests.domain;


import org.junit.Test;
import org.junit.Before;
import pl.krzysiek.domain.ZawodyZapisy;
import pl.krzysiek.repository.ZawodyZapisyFactory;
import pl.krzysiek.repository.ZawodyZapisyRepository;

import static org.junit.Assert.*;


public class ZawodyZapisyTest {

    ZawodyZapisyRepository zawodyZapisyRepository;

    @Test
    public void isZapis() {
        ZawodyZapisy zapis = new ZawodyZapisy();
        assertNotNull(zapis);
    }

    @Test
    public void getById() {
        Long idToFind = (long) 1;
        assertNotNull(zawodyZapisyRepository.getById(idToFind));
    }

    @Test
    public void addZawodyZapis() {
        ZawodyZapisy zapis = new ZawodyZapisy();
        zapis.setId((long) 1);
        zapis.setImie("Krzysztof");
        zapis.setNazwisko("Wojdak");
        zawodyZapisyRepository.addZawodyZapisy(zapis);
        assertNotNull(zawodyZapisyRepository.getById(zapis.getId()));
    }

    @Test
    public void deleteZawodyZapis() {
        ZawodyZapisy zapis = zawodyZapisyRepository.getById((long) 1);
        zawodyZapisyRepository.deleteZawodyZapisy(zapis);
        if (zawodyZapisyRepository.getAll().size() > 0) {
            assertNotNull(zawodyZapisyRepository.getAll());
        } else {
            assertNull(zawodyZapisyRepository.getById(zapis.getId()));
        }
    }

    @Test
    public void updateZawodyZapis() {
        ZawodyZapisy clicker = new ZawodyZapisy();
        clicker.setId((long) 1);
        clicker.setImie("Clicker");
        Long krzysiekToUpdate = (long) 1;
        zawodyZapisyRepository.updateZawodyZapisy(krzysiekToUpdate, clicker);
        assertEquals(zawodyZapisyRepository.getById(krzysiekToUpdate).getImie(), clicker.getImie());

        for (ZawodyZapisy zawodyZapisy : zawodyZapisyRepository.getAll()) {
            if (clicker.getId().equals(krzysiekToUpdate)) {
                assertNotEquals(zawodyZapisy.getImie(), clicker.getImie());
            }
        }
    }

    @Test
    public void getAll() {
        assertNotNull(zawodyZapisyRepository.getAll());
    }

    @Before
    public void initRepository() {
        zawodyZapisyRepository = ZawodyZapisyFactory.getInstance();
        ZawodyZapisy szymek = new ZawodyZapisy();
        ZawodyZapisy tomek = new ZawodyZapisy();
        ZawodyZapisy mateusz = new ZawodyZapisy();
        ZawodyZapisy filip = new ZawodyZapisy();

        szymek.setId((long) 1);
        szymek.setImie("Szymon");

        tomek.setId((long) 2);
        tomek.setImie("Tomasz");

        mateusz.setId((long) 3);
        mateusz.setImie("Mateusz");

        filip.setId((long) 4);
        filip.setImie("Imie");

        zawodyZapisyRepository.addZawodyZapisy(szymek);
        zawodyZapisyRepository.addZawodyZapisy(tomek);
        zawodyZapisyRepository.addZawodyZapisy(mateusz);
        zawodyZapisyRepository.addZawodyZapisy(filip);


    }
}