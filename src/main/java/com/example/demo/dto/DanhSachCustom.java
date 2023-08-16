package com.example.demo.dto;

import java.sql.Date;

public interface DanhSachCustom {
    String getMaDanhSach();

    Date getNgayTao();

    Date getNgayCapNhap();

    String getGhiChu();

    Integer getTrangThai();

    String getTenKhachHang();

    Boolean getGioiTinh();
}
