CREATE DATABASE QuanAnNhanhDB;
USE QuanAnNhanhDB;

-- 1. Bảng Món Ăn
CREATE TABLE MonAn (
    ma_mon INT AUTO_INCREMENT PRIMARY KEY,
    ten_mon VARCHAR(100) NOT NULL,
    gia DOUBLE NOT NULL
);

-- 2. Bảng Phiếu Order
CREATE TABLE PhieuOrder (
    ma_order INT AUTO_INCREMENT PRIMARY KEY,
    so_ban INT NOT NULL,
    thoi_gian TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    trang_thai VARCHAR(50) DEFAULT 'Đang xử lý'
);

-- 3. Bảng Chi Tiết Order
CREATE TABLE ChiTietOrder (
    ma_chi_tiet INT AUTO_INCREMENT PRIMARY KEY,
    ma_order INT,
    ma_mon INT,
    so_luong INT NOT NULL,
    FOREIGN KEY (ma_order) REFERENCES PhieuOrder(ma_order),
    FOREIGN KEY (ma_mon) REFERENCES MonAn(ma_mon)
);

-- 4. Các Món Ăn
INSERT INTO MonAn (ten_mon, gia) VALUES 
('Gà Rán Giòn Tan', 35000),
('Khoai Tây Chiên', 20000),
('Hamburger Bò', 45000),
('Coca Cola', 15000);