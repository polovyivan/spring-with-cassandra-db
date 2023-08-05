package com.polovyi.ivan.tutorials.dto.entity;

import com.polovyi.ivan.tutorials.dto.request.SensorEventRequest;
import com.polovyi.ivan.tutorials.dto.response.SensorEventResponse;
import java.net.Inet4Address;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("sensor_events")
public class SensorEventEntity {

    @PrimaryKey
    private SensorEventEntityCompositeKey primaryKey;

    @Column(value = "closest_devices_ip")
    private Set<Inet4Address> closestDevicesIp;

    @Column(value = "temperature")
    private List<Integer> temperature;

    @Column(value = "tags")
    private Map<String, String> tags;

    @Column(value = "latitude")
    private Double latitude;

    @Column(value = "longitude")
    private Double longitude;

    @Column(value = "humidity")
    private Integer humidity;

    @Column(value = "event_time")
    private LocalTime eventTime;

    public static SensorEventEntity valueOf(SensorEventRequest request) {
        SensorEventEntityCompositeKey sensorEventEntityCompositeKey = SensorEventEntityCompositeKey.builder()
                .accountName(request.getAccountName())
                .deviceId(request.getDeviceId())
                .eventId(request.getEventId())
                .eventDate(request.getEventDate())
                .build();

        return builder()
                .primaryKey(sensorEventEntityCompositeKey)
                .closestDevicesIp(request.getClosestDevicesIp())
                .temperature(request.getTemperature())
                .tags(request.getTags())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .humidity(request.getHumidity())
                .humidity(request.getHumidity())
                .build();
    }
}
