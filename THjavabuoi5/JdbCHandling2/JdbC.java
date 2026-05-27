package communitiuni.com;

public class Main {

    public static void main(String[] args) {

        // DAO
        KhoaDAO kdao = new KhoaDAO();
        GiaoVienDAO gvdao = new GiaoVienDAO();

        // thêm khoa
        Khoa k1 = new Khoa(
                "CNTT",
                "Cong Nghe TT",
                "2020-01-01",
                "GV01"
        );

        // thêm giáo viên
        GiaoVien gv1 = new GiaoVien(
                "GV10",
                "Nguyen Van A",
                "Tien Si",
                "Pho Giao Su",
                "Nam",
                3.5,
                15000000,
                "CNTT"
        );

        // chạy chức năng
        // kdao.insertKhoa(k1);

        gvdao.insertGV(gv1);

        gvdao.displayGV();

        gvdao.updateLuong();

        gvdao.deleteGV();

        gvdao.lietKeNamCNTT();
    }
}