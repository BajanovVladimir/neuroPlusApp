package ru.bazhanov.services.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bazhanov.services.dto.ServiceDTO;
import ru.bazhanov.services.model.OurService;
import ru.bazhanov.services.repository.ServiceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicesOurServiceImpl implements ServicesOurService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Boolean save(ServiceDTO serviceDTO) {
        String name = serviceDTO.getName();
        try{
            Double price = Double.parseDouble(serviceDTO.getPrice());
            int duration = Integer.parseInt(serviceDTO.getDuration());
            if(serviceRepository.save(new OurService(name, price, duration)) == null){
                return false;
            }
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    @Override
    public List<OurService> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public List<OurService> getCurrentServices() {
        List<OurService> listAllServices = getAllServices();
        return getAllServices().stream()
                               .filter(o -> (o.getDeleted() == false))
                               .collect(Collectors.toList());
    }
    @Override
    public OurService getById(int serviceId) {
        return serviceRepository.getReferenceById(serviceId);
    }
    @Transactional
    @Override
    public Boolean deleteById(int serviceId) {
        try {
            OurService service = getById(serviceId);
            service.setDeleted(true);
            OurService newService = service;
            serviceRepository.save(service);
            return true;
        } catch (EntityNotFoundException e){
            return false;
        }
    }
}
