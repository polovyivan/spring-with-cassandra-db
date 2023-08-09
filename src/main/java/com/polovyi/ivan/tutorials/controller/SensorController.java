package com.polovyi.ivan.tutorials.controller;

import com.polovyi.ivan.tutorials.dto.request.SensorRequest;
import com.polovyi.ivan.tutorials.dto.response.SensorResponse;
import com.polovyi.ivan.tutorials.service.SensorService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/sensors")
public class SensorController {

    private final SensorService sensorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSensor(@RequestBody SensorRequest event) {
        sensorService.createSensor(event);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SensorResponse> getAll() {
        return sensorService.getAll();
    }

    @GetMapping("/{sensorId}")
    @ResponseStatus(HttpStatus.OK)
    public SensorResponse getSensorById(@PathVariable String sensorId) {
        return sensorService.getSensorById(sensorId);
    }

    @DeleteMapping("/{sensorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSensor(@PathVariable String sensorId) {
        sensorService.deleteSensorById(sensorId);
    }

}
