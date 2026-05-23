-- 1. Tạo database tên là test
CREATE DATABASE test;

-- 2. Chọn database test để làm việc
USE test;

-- 3. Tạo bảng person giống cấu trúc trong code Java của bạn
CREATE TABLE person (
    id_person INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL
);

-- 4. Chèn thử 1 dòng dữ liệu để lát nữa Java in ra dữ liệu công việc
INSERT INTO person(name) VALUES ('Charly');