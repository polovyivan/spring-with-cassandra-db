package com.polovyi.ivan.tutorials.dto.response;

import com.polovyi.ivan.tutorials.dto.entity.SensorEventEntity;
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
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SensorEventResponse {

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


    public static SensorEventResponse valueOf(SensorEventEntity entity) {
        return builder()
                .accountName(entity.getPrimaryKey().getAccountName())
                .deviceId(entity.getPrimaryKey().getDeviceId())
                .eventId(entity.getPrimaryKey().getEventId())
                .eventDate(entity.getPrimaryKey().getEventDate())
                .closestDevicesIp(entity.getClosestDevicesIp())
                .temperature(entity.getTemperature())
                .tags(entity.getTags())
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .humidity(entity.getHumidity())
                .humidity(entity.getHumidity())
                .build();
    }

}
