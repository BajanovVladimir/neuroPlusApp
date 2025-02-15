package ru.bazhanov.services.service;

import ru.bazhanov.services.dto.ServiceDTO;
import ru.bazhanov.services.model.OurService;

import java.util.List;

public interface ServicesOurService {
    Boolean save(ServiceDTO serviceDTO);
    List<OurService> getAllServices();
    List<OurService> getCurrentServices();
    OurService getById(int serviceId);
    void deleteById(int serviceId);

}
