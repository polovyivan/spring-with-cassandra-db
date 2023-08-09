package com.polovyi.ivan.tutorials.dto.response;

import com.polovyi.ivan.tutorials.dto.entity.SensorEntity;
import java.net.InetAddress;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SensorResponse {

    private String deviceId;
    private String deviceName;
    private InetAddress ipAddress;
    private Float latitude;
    private Float longitude;
    private LocalDateTime createdAt;

    public static SensorResponse valueOf(SensorEntity entity) {
        return builder()
                .deviceId(entity.getDeviceId())
                .deviceName(entity.getDeviceName())
                .ipAddress(entity.getIpAddress())
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .createdAt(entity.getCreatedAt())
                .build();
    }

}
