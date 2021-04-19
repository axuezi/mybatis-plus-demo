/* 雇员表 */
create table t_employee
(
    id            bigint       not null comment 'ID'
        primary key,
    sp_code       varchar(50) null comment '机构编码',
    employee_name varchar(128) NOT NULL COMMENT '雇员姓名',
    address       varchar(256) COMMENT '雇员住址',
    department_id bigint unsigned NOT NULL COMMENT '部门id',
    version       bigint default 1 null comment '版本',
    create_time   datetime null comment '创建时间',
    create_by     varchar(50) null comment '创建人',
    update_time   datetime null comment '修改时间',
    update_by     varchar(50) null comment '修改人',
    is_deleted    tinyint(1) default 0 null comment '状态：0、未删除，1、删除'
) engine = InnoDB DEFAULT charset = utf8mb4 comment '雇员表';

/* 部门表 */
/* DROP TABLE IF EXISTS `t_department`; */
create table t_department
(
    id          bigint       not null comment 'ID'
        primary key,
    sp_code     varchar(50) null comment '机构编码',
    name        varchar(128) NOT NULL COMMENT '部门名称',
    version     bigint default 1 null comment '版本',
    create_time datetime null comment '创建时间',
    create_by   varchar(50) null comment '创建人',
    update_time datetime null comment '修改时间',
    update_by   varchar(50) null comment '修改人',
    is_deleted  tinyint(1) default 0 null comment '状态：0、未删除，1、删除'
) engine = InnoDB DEFAULT charset = utf8mb4 comment '部门表';

