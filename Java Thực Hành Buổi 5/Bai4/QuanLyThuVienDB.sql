CREATE DATABASE QuanLyThuVienDB;
USE QuanLyThuVienDB;

-- 1. Tạo bảng Nhà xuất bản
CREATE TABLE tblPublisher (
    PublisherCode VARCHAR(100) PRIMARY KEY,
    PublisherName VARCHAR(255) NOT NULL,
    Address TEXT,
    Phone VARCHAR(50)
);

-- 2. Tạo bảng Sách
CREATE TABLE tblBook (
    BookCode VARCHAR(100) PRIMARY KEY,
    BookName TEXT NOT NULL,
    PublisherCode VARCHAR(100),
    FOREIGN KEY (PublisherCode) REFERENCES tblPublisher(PublisherCode)
);

-- 3. DML Scripts chèn dữ liệu giả
INSERT INTO tblPublisher VALUES 
('P020202021', 'Addison Wesley', '75 Arlington St., Suite 300, Boston, MA', '113-114-0115'),
('P020202022', 'John Wiley and Sons', '605 Third Ave., New York, NY', '113-112-0117'),
('P020202023', 'McGraw Hill', '121 Ave. of The Americas, New York, NY', '113-110-0118'),
('P020202024', 'Wrox', '10475 Crosspoint Blvd., Indianapolis, IN', '114-114-0119'),
('P020202025', 'Prentice Hall PTR', '49 Sandiego, USA', '110-115-0113');

INSERT INTO tblBook VALUES 
('B032120449', 'Introduction to The Design and Analysis of Algorithms', 'P020202021'),
('B032120450', 'Operating System Concepts', 'P020202022'),
('B032120451', 'Advanced Concepts in Operating Systems 6th', 'P020202023'),
('B032120452', 'Beginning XML 2nd', 'P020202024'),
('B032120453', 'Core Java 2 Volume II', 'P020202025'),
('B032120454', 'A Biography Compiled', 'P020202021'),
('B032120455', 'Academic Culture', 'P020202021'),
('B032120456', 'Achieving Broad Development', 'P020202021'),
('B032120457', 'Achieving a Productive Aging Society', 'P020202021'),
('B032120458', 'Portrait of a Marching Black', 'P020202021'),
('B032120459', 'Automatically Adaptable Software', 'P020202022'),
('B032120460', 'Problems in Psychology', 'P020202022'),
('B032120461', 'Human Relations in a Factory', 'P020202022'),
('B032120462', 'Admiral Halsey\'s Story', 'P020202023'),
('B032120463', 'Theoretical and Research Perspectives', 'P020202024'),
('B032120464', 'The Adolescent in Turmoil', 'P020202021'),
('B032120465', 'Adolphus, a Tale', 'P020202024'),
('B032120466', 'Adventures', 'P020202021'),
('B032120467', 'Aerogeology', 'P020202021');