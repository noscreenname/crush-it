create table GRADE_SYSTEM (
   id SERIAL,
   name VARCHAR(20),

   PRIMARY KEY (id),
   CONSTRAINT grade_system_name_uniq UNIQUE (name)
);