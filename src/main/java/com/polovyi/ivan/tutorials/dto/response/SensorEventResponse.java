package com.polovyi.ivan.tutorials.dto.response;

import com.polovyi.ivan.tutorials.dto.entity.SensorEventEntity;
import java.net.InetAddress;
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
@AllArgsConstructor
@NoArgsConstructor
public class SensorEventResponse {

    private String accountName;
    private UUID deviceId;
    private UUID eventId;
    private LocalDate eventDate;
    private Set<InetAddress> closestDevicesIp;
    private List<Integer> temperatures;
    private Map<String, String> tags;
    private Float latitude;
    private Float longitude;
    private Integer humidity;
    private Integer pressure;
    private LocalTime eventTime;


    public static SensorEventResponse valueOf(SensorEventEntity entity) {
        return builder()
                .accountName(entity.getPrimaryKey().getAccountName())
                .deviceId(entity.getPrimaryKey().getDeviceId())
                .eventId(entity.getPrimaryKey().getEventId())
                .eventDate(entity.getPrimaryKey().getEventDate())
                .closestDevicesIp(entity.getClosestDevicesIp())
                .temperatures(entity.getTemperatures())
                .tags(entity.getTags())
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .humidity(entity.getHumidity())
                .pressure(entity.getPressure())
                .eventTime(entity.getEventTime())
                .build();
    }

}
