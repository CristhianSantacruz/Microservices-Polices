package com.microservice.policies.microservicepolicies.service.implement;

import com.microservice.policies.microservicepolicies.models.PoliceEntity;
import com.microservice.policies.microservicepolicies.repository.PoliceRepository;
import com.microservice.policies.microservicepolicies.service.IPoliceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoliceService implements IPoliceService {

    private final PoliceRepository policeRepository;

    public PoliceService(PoliceRepository policeRepository){
        this.policeRepository = policeRepository;
    }
    @Override
    public List<PoliceEntity> findByAll() {
        return policeRepository.findAll();
    }

    @Override
    public Optional<PoliceEntity> findById(Long id) {
        return policeRepository.findById(id);
    }

    @Override
    public void save(PoliceEntity policeEntity) {
            policeRepository.save(policeEntity);
    }

    @Override
    public void deleteById(Long id) {
        policeRepository.deleteById(id);
    }

    @Override
    public List<PoliceEntity> findAllByDepartmentNorth(Long idDepartmentNorth) {
        return policeRepository.findAllByDepartmentNorth(idDepartmentNorth);
    }

    @Override
    public List<PoliceEntity> findAllByDepartmentSouth(Long idDepartmentSouth) {
        return policeRepository.findAllByDepartmentSouth(idDepartmentSouth);
    }


}
