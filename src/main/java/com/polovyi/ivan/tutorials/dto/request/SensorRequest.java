package com.polovyi.ivan.tutorials.dto.request;

import java.net.InetAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SensorRequest {

    private String deviceName;
    private InetAddress ipAddress;
    private Float latitude;
    private Float longitude;

}
