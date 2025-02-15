package ru.bazhanov.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.bazhanov.services.dto.ServiceDTO;
import ru.bazhanov.services.model.OurService;
import ru.bazhanov.services.service.ServicesOurServiceImpl;

import java.util.List;

@SpringBootTest
public class ServicesOurServiceImplTests {
    @Autowired
    private ServicesOurServiceImpl servicesOurService;

    @Test
    public void test_that_save_is_true(){
        String name = "Service1";
        String price = "1200.50";
        String duration = "30";
        int size = servicesOurService.getAllServices().size();
        ServiceDTO serviceDTO = new ServiceDTO(name, duration, price);
        Assertions.assertTrue(servicesOurService.save(serviceDTO));
        Assertions.assertEquals(size+1, servicesOurService.getAllServices().size());
    }
    @Test
    public void test_that_save_is_false_if_price_is_bad(){
        String name = "Service1";
        String price = "adadad";
        String duration = "30";
        int size = servicesOurService.getAllServices().size();
        ServiceDTO serviceDTO = new ServiceDTO(name, duration, price);
        Assertions.assertFalse(servicesOurService.save(serviceDTO));
        Assertions.assertEquals(size, servicesOurService.getAllServices().size());
    }

    @Test
    public void test_that_save_is_false_if_duration_is_bad(){
        String name = "Service1";
        String price = "20.0";
        String duration = "vhg";
        int size = servicesOurService.getAllServices().size();
        ServiceDTO serviceDTO = new ServiceDTO(name, duration, price);
        Assertions.assertFalse(servicesOurService.save(serviceDTO));
        Assertions.assertEquals(size, servicesOurService.getAllServices().size());
    }
    @Test
    public void test_that_delete_is_work(){
        String name = "Service1";
        String price = "20.0";
        String duration = "10";
        ServiceDTO serviceDTO = new ServiceDTO(name, duration, price);
        servicesOurService.save(serviceDTO);
        String name2 = "Service2";
        String price2 = "40.0";
        String duration2 = "40";
        ServiceDTO serviceDTO2 = new ServiceDTO(name2, duration2, price2);
        servicesOurService.save(serviceDTO2);
        List<OurService> serviceList = servicesOurService.getCurrentServices();
        int size = serviceList.size();
        OurService service = serviceList.get(0);
        int serviceId = service.getId();
        servicesOurService.deleteById(serviceId);
        serviceList = servicesOurService.getCurrentServices();
        Assertions.assertEquals(size-1, serviceList.size());

    }
    @Test
    public void test_that_getCurrentServices_is_work(){
        String name = "Service1";
        String price = "20.0";
        String duration = "10";
        ServiceDTO serviceDTO = new ServiceDTO(name, duration, price);
        servicesOurService.save(serviceDTO);
        String name2 = "Service2";
        String price2 = "40.0";
        String duration2 = "40";
        ServiceDTO serviceDTO2 = new ServiceDTO(name2, duration2, price2);
        servicesOurService.save(serviceDTO2);
    }
}
