import org.codehaus.jackson.map.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Main {
    public static void main(String[]args) throws JAXBException {
        at.ac.fh_kufstein.a2.Weather weather = new at.ac.fh_kufstein.a2.Weather();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            weather = objectMapper.readValue(new File("src/weather.json"), at.ac.fh_kufstein.a2.Weather.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(weather.toString());


        JAXBContext jaxbContext = JAXBContext.newInstance(at.ac.fh_kufstein.a2.Weather.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(weather, new File("src/weather.xml"));
        marshaller.marshal(weather, System.out);
    }
}
