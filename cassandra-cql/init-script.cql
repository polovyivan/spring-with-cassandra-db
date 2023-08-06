CREATE KEYSPACE iot WITH REPLICATION = {'class':'SimpleStrategy', 'replication_factor':3};


CREATE COLUMNFAMILY iot.sensor_events (
                    account_name text,
                    device_id UUID,
                    event_id UUID,
                    event_date date,
                    closest_devices_ip set<inet>,
                    temperatures list<int>,
                    tags map<text,text>,
                    latitude float,
                    longitude float,
                    humidity  int,
                    event_time time,
                    pressure int,
                    PRIMARY KEY((account_name,device_id), event_id, event_date)
);

INSERT INTO iot.sensor_events (account_name,
                               device_id,
                               event_id,
                               event_date,
                               closest_devices_ip,
                               temperatures,
                               tags,
                               latitude,
                               longitude,
                               humidity,
                               pressure,
                               event_time)
VALUES ('Account#1',
        89a35059-b6c1-4d28-9fae-d8a7abd896f5,
        uuid(),
        '2022-10-25',
        {'29.208.191.134','29.208.191.135'},
        [22,24,21,20],
        {'type':'whether_sensor','brand':'some_brand' },
        48.955624,
        30.025853,
        62,
        85,
        '06:36:07');
