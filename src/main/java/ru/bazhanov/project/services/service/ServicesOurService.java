package ru.bazhanov.project.services.service;

import ru.bazhanov.project.services.dto.ServiceDTO;
import ru.bazhanov.project.model.OurService;

import java.util.List;

public interface ServicesOurService {
    Boolean save(ServiceDTO serviceDTO);
    List<OurService> getAllServices();
    List<OurService> getCurrentServices();
    OurService getById(int serviceId);
    Boolean deleteById(int serviceId);

}
