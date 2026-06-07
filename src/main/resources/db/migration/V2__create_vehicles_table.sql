CREATE TABLE vehicles (
                          id UUID PRIMARY KEY,

                          plate VARCHAR(20) NOT NULL UNIQUE,

                          brand VARCHAR(100) NOT NULL,

                          model VARCHAR(100) NOT NULL,

                          year INTEGER NOT NULL,

                          color VARCHAR(50) NOT NULL,

                          daily_price NUMERIC(10,2) NOT NULL,

                          status VARCHAR(20) NOT NULL,

                          created_at TIMESTAMP NOT NULL,

                          updated_at TIMESTAMP NULL
);