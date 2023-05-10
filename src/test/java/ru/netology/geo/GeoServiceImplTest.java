package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class GeoServiceImplTest {

    GeoServiceImpl geoService = new GeoServiceImpl();

    @Test
    public void ruLocationDeterminationTest() {

        String ruId = "172.50.16.70";

        Location rus = new Location("Moscow", Country.RUSSIA, "Gagarina", 15);

        Location resRu = geoService.byIp(ruId);

        Assertions.assertEquals(rus.getCountry(), resRu.getCountry());
    }

    @Test
    public void enLocationDeterminationTest() {

        String enId = "96.60.26.80";

        Location en = new Location("New York", Country.USA, " 10th Avenue", 32);

        Location resEn = geoService.byIp(enId);

        Assertions.assertEquals(en.getCountry(), resEn.getCountry());
    }
}