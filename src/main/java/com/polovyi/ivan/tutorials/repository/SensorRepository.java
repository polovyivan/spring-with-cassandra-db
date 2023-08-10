package com.polovyi.ivan.tutorials.repository;

import com.polovyi.ivan.tutorials.dto.entity.SensorEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends CassandraRepository<SensorEntity, String> { }