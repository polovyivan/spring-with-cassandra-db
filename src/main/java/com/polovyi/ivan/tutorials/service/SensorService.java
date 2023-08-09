package com.polovyi.ivan.tutorials.service;

import com.polovyi.ivan.tutorials.dto.entity.SensorEntity;
import com.polovyi.ivan.tutorials.dto.request.SensorRequest;
import com.polovyi.ivan.tutorials.dto.response.SensorResponse;
import com.polovyi.ivan.tutorials.repository.SensorRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;

    public void createSensor(SensorRequest sensorRequest) {
        log.info("Saving request {}", sensorRequest);
        sensorRepository.save(SensorEntity.valueOf(sensorRequest));
    }

    public List<SensorResponse> getAll() {
        log.info("Retreating all...");
        return sensorRepository.findAll()
                .stream()
                .map(SensorResponse::valueOf)
                .collect(Collectors.toList());
    }

    public SensorResponse getSensorById(String sensorId) {
        return sensorRepository.findById(sensorId)
                .map(SensorResponse::valueOf)
                .orElse(null);
    }

    public void deleteSensorById(String sensorId) {
        sensorRepository.findById(sensorId).ifPresent(sensorRepository::delete);
    }
}
