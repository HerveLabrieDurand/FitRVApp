DROP TABLE IF EXISTS exercise CASCADE;
CREATE TABLE IF NOT EXISTS exercise (
    exercise_id             SERIAL          PRIMARY KEY,
    name                    VARCHAR(255)    NOT NULL,
    description             VARCHAR(2000)    NOT NULL,

    CONSTRAINT unique_exercise_name         UNIQUE (name)
);

DROP TABLE IF EXISTS main_muscle_group CASCADE;
CREATE TABLE IF NOT EXISTS main_muscle_group (
    main_muscle_group_id    SERIAL          PRIMARY KEY,
    name                    VARCHAR(255)    NOT NULL,
    description             VARCHAR(2000)    NOT NULL,

  CONSTRAINT unique_main_muscle_group_name  UNIQUE (name)
);

DROP TABLE IF EXISTS muscle_group CASCADE;
CREATE TABLE IF NOT EXISTS muscle_group (
    muscle_group_id         SERIAL          PRIMARY KEY,
    main_muscle_group_id    SERIAL          NOT NULL,
    name                    VARCHAR(255)    NOT NULL,
    description             VARCHAR(2000)   NOT NULL,

    CONSTRAINT unique_muscle_group_name     UNIQUE (name),
    CONSTRAINT main_muscle_group_id_constraint FOREIGN KEY (main_muscle_group_id) references main_muscle_group (main_muscle_group_id)
  );

DROP TABLE IF EXISTS exercise_muscle_group CASCADE;
CREATE TABLE IF NOT EXISTS exercise_muscle_group (
    id                      SERIAL          PRIMARY KEY,
    exercise_id             SERIAL          NOT NULL,
    muscle_group_id         SERIAL          NOT NULL,

    CONSTRAINT exercise_id_constraint FOREIGN KEY (exercise_id) references exercise (exercise_id),
    CONSTRAINT muscle_group_id_constraint FOREIGN KEY (muscle_group_id) references muscle_group (muscle_group_id)
);

DROP TABLE IF EXISTS training_log CASCADE;
CREATE TABLE IF NOT EXISTS training_log (
    training_log_id         SERIAL                  PRIMARY KEY,
    title                   VARCHAR(155)            NOT NULL
);

DROP TABLE IF EXISTS training_log_entry CASCADE;
CREATE TABLE IF NOT EXISTS training_log_entry (
    entry_id                SERIAL          PRIMARY KEY,
    exercise_id             SERIAL          NOT NULL,
    training_log_id         SERIAL          NOT NULL,
    sets                    INTEGER         NOT NULL,
    reps                    INTEGER         NOT NULL,
    weight                  DECIMAL(6,2)    NOT NULL,
    intensity               INTEGER         NOT NULL,
    date                    DATE            NOT NULL,
    notes                   TEXT,

    CONSTRAINT exercise_id_constraint FOREIGN KEY (exercise_id) references exercise (exercise_id),
    CONSTRAINT training_log_id_constraint FOREIGN KEY (training_log_id) references training_log (training_log_id)
);
