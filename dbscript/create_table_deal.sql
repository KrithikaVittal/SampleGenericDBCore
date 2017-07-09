CREATE TABLE sampledb.deal (
     deal_id BIGINT NOT NULL AUTO_INCREMENT,
     deal_name VARCHAR(30) NOT NULL,
     deal_desc VARCHAR(30) NOT NULL,
     last_updated TIMESTAMP NOT NULL,
     PRIMARY KEY (deal_id)
);