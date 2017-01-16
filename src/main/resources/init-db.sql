CREATE TABLE IF NOT EXISTS customer (
	id		bigserial PRIMARY KEY,    
	name	varchar(40) NOT NULL,
    note	text,
    enabled  boolean  NOT NULL DEFAULT TRUE,
    created timestamp DEFAULT current_timestamp
);

    