package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.UUID;

@Table(name = "DanhSachYeuThich")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DanhSachYeuThich {
    @Id
    @Column(name = "MaDanhSach")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID maDanhSach;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgayCapNhap")
    private Date ngayCapNhap;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @ManyToOne
    @JoinColumn(name = "NguoiSoHuu")
    private KhachHang khachHang;
}
