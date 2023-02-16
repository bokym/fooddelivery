package fooddelivery.common;


import fooddelivery.OrdernpayApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { OrdernpayApplication.class })
public class CucumberSpingConfiguration {
    
}
