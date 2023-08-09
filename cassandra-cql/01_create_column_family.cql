
CREATE COLUMNFAMILY iot.sensors (
                             device_id text PRIMARY KEY,
                             device_name text,
                             ip_address inet,
                             latitude float,
                             longitude float,
                             created_at timestamp
);

