package com.polovyi.ivan.tutorials.repository;

import com.polovyi.ivan.tutorials.dto.entity.SensorEntity;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends CassandraRepository<SensorEntity, String> {

    @Query("""
            SELECT * FROM sensor_events WHERE 
            account_name=:#{#accountName} AND 
            device_id=:#{#deviceId} AND
            event_date = :#{#eventDate} AND 
            event_id = :#{#eventId} 
            """)
    List<SensorEntity> findByKeyAccountNameAndKeyDeviceId(String accountName, UUID deviceId,  LocalDate eventDate, UUID eventId);
}
