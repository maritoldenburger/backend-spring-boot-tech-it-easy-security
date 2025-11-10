INSERT INTO users(username, password, enabled, apikey, email)
VALUES
    ('admin', '$2b$10$dHq1LRBjJuiJ1ptgaYJsjexPkYfdas251LkvjTvCY1B6v2mxII6aq', true, 'KEY1', 'admin@techiteasy.nl'),
    ('user', '$2b$10$GXy3qKLopfLCooKA9mtv2u5aEV0Vt9QNFjgVqCj9dDuoOVzD5T9xq', true, 'KEY2', 'user@techiteasy.nl');

INSERT INTO authorities(username, authority)
VALUES
    ('admin', 'ROLE_ADMIN'),
    ('admin', 'ROLE_USER'),
    ('user', 'ROLE_USER');