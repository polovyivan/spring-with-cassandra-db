package com.polovyi.ivan.tutorials.controller;

import com.polovyi.ivan.tutorials.dto.request.SensorEventRequest;
import com.polovyi.ivan.tutorials.dto.response.SensorEventResponse;
import com.polovyi.ivan.tutorials.service.SensorEventsService;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/sensor-events", consumes = MediaType.APPLICATION_JSON_VALUE )
public class SensorEventsController {

    private final SensorEventsService sensorEventsService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createEvent(@RequestBody SensorEventRequest event) {
        sensorEventsService.createEvent(event);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SensorEventResponse> getAll() {
        return sensorEventsService.getAll();
    }
}
