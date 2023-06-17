DROP TABLE IF EXISTS hits CASCADE;

CREATE TABLE IF NOT EXISTS hits
(
    id        BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    app       VARCHAR                     NOT NULL,
    uri       VARCHAR                     NOT NULL,
    ip        VARCHAR                     NOT NULL,
    timestamp TIMESTAMP WITHOUT TIME ZONE NOT NULL
);