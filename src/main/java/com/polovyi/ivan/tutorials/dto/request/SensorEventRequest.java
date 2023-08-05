package com.polovyi.ivan.tutorials.dto.request;

import com.polovyi.ivan.tutorials.dto.entity.SensorEventEntity;
import com.polovyi.ivan.tutorials.dto.response.SensorEventResponse;
import java.net.Inet4Address;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SensorEventRequest {
    private String accountName;
    private UUID deviceId;
    private UUID eventId;
    private LocalDate eventDate;
    private Set<Inet4Address> closestDevicesIp;
    private List<Integer> temperature;
    private Map<String, String> tags;
    private Double latitude;
    private Double longitude;
    private Integer humidity;
    private LocalTime eventTime;

}
