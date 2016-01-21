------------------------------------------------------
-- DROP constrains and tables
------------------------------------------------------
alter table if exists  ATTEMPT
    drop constraint FK_1ste3u2qwonsnp6kxpwv0lriv;

alter table if exists  GRADE
    drop constraint FK_29dwsir0mat48xm1n2utgj429;

alter table if exists  GRADE_SYSTEM
    drop constraint FK_bj9hk9fwv6e371ivat9u9g3by;

alter table if exists GRADE_SYSTEM
    drop constraint FK_fwprd74gg04iiwt2x5d5h9739;

alter table if exists GRADE_SYSTEM
    drop constraint FK_hx223f4yyhuyh9alvcs2rwspm;

drop table if exists ATTEMPT cascade;

drop table if exists CRAG cascade;

drop table if exists GRADE cascade;

drop table if exists GRADE_SYSTEM cascade;

------------------------------------------------------
-- DROP create tables
------------------------------------------------------

create table ATTEMPT (
    ID int4 not null,
    DATE date not null,
    tries int4 not null,
    route_ID int4,
    primary key (ID)
);

create table CRAG (
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
    crag_ID int4,
    grade_ID int4,
    zone_ID int4,
    primary key (ID)
);

------------------------------------------------------
-- DROP add constrains
------------------------------------------------------

alter table GRADE_SYSTEM
    add constraint UK_61llrt37epy7wbfgihq5pgd0a unique (NAME);

alter table ATTEMPT
    add constraint FK_1ste3u2qwonsnp6kxpwv0lriv
    foreign key (route_ID)
    references ROUTE;

alter table GRADE
    add constraint FK_29dwsir0mat48xm1n2utgj429
    foreign key (gradeSystem_ID)
    references GRADE_SYSTEM;

alter table ROUTE
    add constraint FK_bj9hk9fwv6e371ivat9u9g3by
    foreign key (crag_ID)
    references CRAG;

alter table ROUTE
    add constraint FK_fwprd74gg04iiwt2x5d5h9739
    foreign key (grade_ID)
    references GRADE;

