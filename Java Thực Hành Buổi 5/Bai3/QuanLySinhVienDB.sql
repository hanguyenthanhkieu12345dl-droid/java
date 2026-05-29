CREATE DATABASE QuanLySinhVienDB;
USE QuanLySinhVienDB;

-- 1. Bảng KHOA
CREATE TABLE KHOA (
    MaKhoa VARCHAR(6) PRIMARY KEY,
    TenKhoa VARCHAR(30) NOT NULL
);

-- 2. Bảng SinhVien
CREATE TABLE SinhVien (
    MaSo INT PRIMARY KEY,
    HoTen VARCHAR(50) NOT NULL,
    NgaySinh DATETIME,
    GioiTinh BIT, -- 1: Nam, 0: Nữ
    DiaChi VARCHAR(50),
    DienThoai INT,
    MaKhoa VARCHAR(6),
    FOREIGN KEY (MaKhoa) REFERENCES KHOA(MaKhoa)
);

-- 3. Bảng Mon
CREATE TABLE Mon (
    MaMH VARCHAR(6) PRIMARY KEY,
    TenMH VARCHAR(50) NOT NULL,
    SoTiet INT
);

-- 4. Bảng KetQua
CREATE TABLE KetQua (
    MaSo INT,
    MaMH VARCHAR(6),
    Diem INT,
    PRIMARY KEY (MaSo, MaMH),
    FOREIGN KEY (MaSo) REFERENCES SinhVien(MaSo),
    FOREIGN KEY (MaMH) REFERENCES Mon(MaMH)
);

-- Chèn dữ liệu mẫu ban đầu để chạy ứng dụng
INSERT INTO KHOA VALUES ('CNTT', 'Công nghệ thông tin'), ('KT', 'Kế toán');
INSERT INTO SinhVien VALUES (101, 'Nguyen Van A', '2005-01-15', 1, 'TP HCM', 987654321, 'CNTT');
INSERT INTO Mon VALUES ('JA', 'Lap trinh Java', 45), ('DB', 'Co so du lieu', 30);
INSERT INTO KetQua VALUES (101, 'JA', 9), (101, 'DB', 8);