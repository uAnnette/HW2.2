import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderTests {

    @Test
    public void russianIdTest() {
        GeoService geoService = new GeoServiceImplMock();
        LocalizationService localizationService = new LocalizationServiceImplMock();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        String resRu = "Добро пожаловать";

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");

        String actualRu = messageSender.send(headers);

        Assertions.assertEquals(resRu, actualRu);
    }

    @Test
    public void englishIdTest() {
        GeoService geoService = new GeoServiceImplMock();
        LocalizationService localizationService = new LocalizationServiceImplMock();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        String resEn = "Welcome";

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");

        String actualEn = messageSender.send(headers);

        Assertions.assertEquals(resEn, actualEn);
    }
}
