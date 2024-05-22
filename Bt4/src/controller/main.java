package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.SinhVien;

public class main {
    private static final ArrayList<SinhVien> listSinhVien = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            boolean exit = false;
            
            while (!exit) {
                printMenu();
                int choice = sc.nextInt();
                sc.nextLine(); // Consume the newline character
                
                switch (choice) {
                    case 1 -> themSinhVien(sc);
                    case 2 -> xoaSinhVien(sc);
                    case 3 -> suaSinhVien(sc);
                    case 4 -> inThongTin();
                    case 5 -> inThongTinTheoGioiTinh("Nam");
                    case 6 -> inThongTinTheoGioiTinh("Nu");
                    case 7 -> {
                        System.out.println("Thoat chuong trinh.");
                        exit = true;
                    }
                    default -> System.out.println("Khong co lua chon nay, moi ban chon lai.");
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Them");
        System.out.println("2. Xoa");
        System.out.println("3. Sua");
        System.out.println("4. In tat ca");
        System.out.println("5. In Nam");
        System.out.println("6. In Nu");
        System.out.println("7. Thoat");
        System.out.println("Ban muon lam gi day: ");
    }
    
    private static void themSinhVien(Scanner sc) {
        System.out.print("Nhap ID: ");
        String id = sc.nextLine();
        System.out.print("Nhap ten: ");
        String name = sc.nextLine();
        System.out.print("Nhap gioi tinh: ");
        String gender = sc.nextLine();
        System.out.print("Nhap chuyen nganh: ");
        String major = sc.nextLine();
        SinhVien sv = new SinhVien(id, name, gender, major);
        listSinhVien.add(sv);
        System.out.println("Sinh vien da duoc them vao danh sach.");
    }

    private static void xoaSinhVien(Scanner sc) {
        System.out.print("Nhap ID sinh vien can xoa: ");
        String id = sc.nextLine();
        boolean removed = listSinhVien.removeIf(sv -> sv.getId().equals(id));
        if (removed) {
            System.out.println("Sinh vien da bi loai bo khoi danh sach.");
        } else {
            System.out.println("Khong co du lieu.");
        }
    }

    private static void suaSinhVien(Scanner sc) {
        System.out.print("Nhap ID sinh vien can sua: ");
        String id = sc.nextLine();
        for (SinhVien sv : listSinhVien) {
            if (sv.getId().equals(id)) {
                System.out.print("Nhap ten moi: ");
                String name = sc.nextLine();
                System.out.print("Nhap gioi tinh moi: ");
                String gender = sc.nextLine();
                System.out.print("Nhap chuyen nganh moi: ");
                String major = sc.nextLine();
                sv.setName(name);
                sv.setGender(gender);
                sv.setMajor(major);
                System.out.println("Thong tin sinh vien da duoc sua.");
                return;
            }
        }
        System.out.println("Khong co du lieu.");
    }

    private static void inThongTin() {
        for (SinhVien sv : listSinhVien) {
            System.out.println(sv);
        }
    }

    private static void inThongTinTheoGioiTinh(String gender) {
        for (SinhVien sv : listSinhVien) {
            if (sv.getGender().equalsIgnoreCase(gender)) {
                System.out.println(sv);
            }
        }
    }
}
