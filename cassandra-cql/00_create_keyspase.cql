
CREATE KEYSPACE iot
    WITH REPLICATION = {
        'class' : 'NetworkTopologyStrategy',
        'dc' : 3
        };
