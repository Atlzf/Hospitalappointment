CREATE DATABASE HospitalSystem;

USE HospitalSystem;

-- 存储用户信息
CREATE TABLE User (
                      id INT PRIMARY KEY AUTO_INCREMENT,-- 用户id作为主键，自动增长
                      username VARCHAR(50) NOT NULL,-- 用户名
                      password VARCHAR(50) NOT NULL,-- 用户密码
                      contact VARCHAR(50)           -- 联系方式
);

-- 存储医生信息
CREATE TABLE Doctor (
                        id INT PRIMARY KEY AUTO_INCREMENT, -- 医生ID，主键，自动增长
                        name VARCHAR(50) NOT NULL,          -- 医生姓名
                        specialty VARCHAR(50),          -- 医生专长
                        available_time VARCHAR(50)      -- 医生的可用时间
);

-- 存储预约信息
CREATE TABLE Appointment (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             user_id INT,
                             doctor_id INT,
                             appointment_time DATETIME,-- 预约时间
                             FOREIGN KEY (user_id) REFERENCES User(id),
                             FOREIGN KEY (doctor_id) REFERENCES Doctor(id)
);

-- 存储用户对医生的评价信息
CREATE TABLE Review (
                        id INT PRIMARY KEY AUTO_INCREMENT,-- 预约ID，主键，自动增长
                        user_id INT,                      -- 用户ID，外键，引用User表的id
                        doctor_id INT,
                        content TEXT,                     -- 评价内容
                        FOREIGN KEY (user_id) REFERENCES User(id),
                        FOREIGN KEY (doctor_id) REFERENCES Doctor(id)-- 医生ID，外键，引用Doctor表的id
);

-- 存储管理员信息
CREATE TABLE Admin (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       username VARCHAR(50) NOT NULL,
                       password VARCHAR(50) NOT NULL
);
ALTER TABLE Doctor
    ADD username VARCHAR(50),
    ADD password VARCHAR(50);