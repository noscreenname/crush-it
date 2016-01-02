------------------------------------------------------
-- DROP constrains and tables
------------------------------------------------------
alter table ATTEMPT
    drop constraint FK_1ste3u2qwonsnp6kxpwv0lriv;

alter table GRADE
    drop constraint FK_29dwsir0mat48xm1n2utgj429;

alter table GRADE_SYSTEM
    drop constraint FK_bj9hk9fwv6e371ivat9u9g3by;

alter table GRADE_SYSTEM
    drop constraint FK_fwprd74gg04iiwt2x5d5h9739;

alter table GRADE_SYSTEM
    drop constraint FK_hx223f4yyhuyh9alvcs2rwspm;

alter table ZONE
    drop constraint FK_iyunjbbf80j2sbhvu3cliaa7p;

drop table if exists ATTEMPT cascade;

drop table if exists CRAIG cascade;

drop table if exists GRADE cascade;

drop table if exists GRADE_SYSTEM cascade;

drop table if exists ZONE cascade;

------------------------------------------------------
-- DROP create tables
------------------------------------------------------

create table ATTEMPT (
    ID int4 not null,
    DATE date not null,
    tries int4 not null,
    routes_ID int4,
    primary key (ID)
);

create table CRAIG (
    ID int4 not null,
    NAME varchar(255) not null,
    primary key (ID)
);

create table GRADE (
    ID int4 not null,
    NAME varchar(255) not null,
    TECH_VALUE int4 not null,
    gradeSystem_ID int4,
    primary key (ID)
);

create table GRADE_SYSTEM (
    ID int4 not null,
    NAME varchar(255) not null,
    primary key (ID)
);

create table ROUTE (
    ID int4 not null,
    NAME varchar(255),
    DESCRIPTION varchar(255),
    craig_ID int4,
    grade_ID int4,
    zone_ID int4,
    primary key (ID)
);

create table ZONE (
    ID int4 not null,
    NAME int4,
    craig_ID int4,
    primary key (ID)
);

------------------------------------------------------
-- DROP add constrains
------------------------------------------------------

alter table GRADE_SYSTEM
    add constraint UK_61llrt37epy7wbfgihq5pgd0a unique (NAME);

alter table ATTEMPT
    add constraint FK_1ste3u2qwonsnp6kxpwv0lriv
    foreign key (routes_ID)
    references ROUTE;

alter table GRADE
    add constraint FK_29dwsir0mat48xm1n2utgj429
    foreign key (gradeSystem_ID)
    references GRADE_SYSTEM;

alter table ROUTE
    add constraint FK_bj9hk9fwv6e371ivat9u9g3by
    foreign key (craig_ID)
    references CRAIG;

alter table ROUTE
    add constraint FK_fwprd74gg04iiwt2x5d5h9739
    foreign key (grade_ID)
    references GRADE;

alter table ROUTE
    add constraint FK_hx223f4yyhuyh9alvcs2rwspm
    foreign key (zone_ID)
    references ZONE;

alter table ZONE
    add constraint FK_iyunjbbf80j2sbhvu3cliaa7p
    foreign key (craig_ID)
    references CRAIG;
