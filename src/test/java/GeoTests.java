import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

public class GeoTests {

    GeoServiceImpl geoService = new GeoServiceImpl();

    LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

    @Test
    public void locationTest() {

        String ruId = "172.50.16.70";
        String enId = "96.60.26.80";

        Location Rus = new Location("Moscow", Country.RUSSIA, "Gagarina", 15);
        Location En = new Location("New York", Country.USA, " 10th Avenue", 32);

        Location resRu = geoService.byIp(ruId);
        Location resEn = geoService.byIp(enId);

        Assertions.assertEquals(Rus.getCountry(), resRu.getCountry());
        Assertions.assertEquals(En.getCountry(), resEn.getCountry());
    }

    @Test
    public void textTest() {
        Country rusCountry = Country.RUSSIA;
        Country enCountry = Country.USA;

        String resRu = "Добро пожаловать";
        String resEn = "Welcome";

        String actualRu = localizationService.locale(rusCountry);
        String actualEn = localizationService.locale(enCountry);

        Assertions.assertEquals(resRu, actualRu);
        Assertions.assertEquals(resEn, actualEn);
    }
}
