drop table if exists member;
drop table if exists lecture;
drop table if exists grade;

create table member
(
    member_id    bigint       not null auto_increment,
    id_number    integer(255) not null,
    password     varchar(255) not null,
    name         varchar(255) not null,
    phone_number varchar(255) not null,
    role_type    varchar(255) not null,
    primary key (member_id)
) engine=InnoDB default charset=utf8mb4;

create table lecture
(
    lecture_id   bigint       not null auto_increment,
    professor_id bigint       not null,
    name         varchar(255) not null,
    credit       integer      not null,
    primary key (lecture_id)
) engine=InnoDB default charset=utf8mb4;

CREATE TABLE grade
(
    grade_id   bigint auto_increment,
    lecture_id bigint,
    student_id bigint,
    grade      float,
    primary key (grade_id)
) engine=InnoDB default charset=utf8mb4;
