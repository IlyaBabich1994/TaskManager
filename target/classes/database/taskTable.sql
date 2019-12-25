
CREATE TABLE taskTable.tasktable (
                                     id INT(8) NOT NULL AUTO_INCREMENT,
                                     start TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                     end TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                     status BIT(1) NOT NULL DEFAULT b'0',
                                     target VARCHAR(100) NOT NULL,
                                     comment VARCHAR(255) NOT NULL,
                                     PRIMARY KEY (`id`))
    COLLATE='utf8_general_ci';