package com.polovyi.ivan.tutorials.dto.entity;

import com.polovyi.ivan.tutorials.dto.request.SensorRequest;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.util.UUID;
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
@Table("sensors")
public class SensorEntity {

    @PrimaryKey(value = "device_id")
    private String deviceId;

    @Column(value = "device_name")
    private String deviceName;

    @Column(value = "ip_address")
    private InetAddress ipAddress;

    @Column(value = "latitude")
    private Float latitude;

    @Column(value = "longitude")
    private Float longitude;

    @Column(value = "created_at")
    private LocalDateTime createdAt;

    public static SensorEntity valueOf(SensorRequest request) {
        return builder()
                .deviceId(UUID.randomUUID().toString())
                .deviceName(request.getDeviceName())
                .ipAddress(request.getIpAddress())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
