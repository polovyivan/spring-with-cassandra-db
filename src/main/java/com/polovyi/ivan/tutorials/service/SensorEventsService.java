package com.polovyi.ivan.tutorials.service;

import com.polovyi.ivan.tutorials.dto.entity.SensorEventEntity;
import com.polovyi.ivan.tutorials.dto.request.SensorEventRequest;
import com.polovyi.ivan.tutorials.dto.response.SensorEventResponse;
import com.polovyi.ivan.tutorials.repository.SensorEventsRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SensorEventsService {

    private final SensorEventsRepository sensorEventsRepository;

    public void createEvent(SensorEventRequest sensorEventRequest) {
        log.info("Saving request {}", sensorEventRequest);
        sensorEventsRepository.save(SensorEventEntity.valueOf(sensorEventRequest));
    }

    public List<SensorEventResponse> getAll() {
        return sensorEventsRepository.findAll()
                .stream()
                .map(SensorEventResponse::valueOf)
                .collect(Collectors.toList());
    }
}
