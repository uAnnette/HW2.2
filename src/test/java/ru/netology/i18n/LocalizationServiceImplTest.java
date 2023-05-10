package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

public class LocalizationServiceImplTest {
    LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

    @Test
    public void ruTextTest() {
        Country rusCountry = Country.RUSSIA;

        String resRu = "Добро пожаловать";

        String actualRu = localizationService.locale(rusCountry);

        Assertions.assertEquals(resRu, actualRu);
    }

    @Test
    public void enTextTest() {
        Country enCountry = Country.USA;

        String resEn = "Welcome";

        String actualEn = localizationService.locale(enCountry);

        Assertions.assertEquals(resEn, actualEn);
    }
}
