CREATE TYPE reading_type AS ENUM ('heartRate', 'BP');

CREATE TABLE reading (
    id SERIAL PRIMARY KEY,
    timestamp TIMESTAMPTZ NOT NULL DEFAULT now(),
    type reading_type NOT NULL,
    heart_rate_value NUMERIC(5, 2),
    systolic NUMERIC(5, 2),
    diastolic NUMERIC(5, 2),
    device_id INT NOT NULL REFERENCES device(id),
    CHECK (
        (type = 'heartRate' AND heart_rate_value IS NOT NULL AND systolic IS NULL AND diastolic IS NULL) OR
        (type = 'BP' AND systolic IS NOT NULL AND diastolic IS NOT NULL AND heart_rate_value IS NULL)
    )
);
