package org.example.session03;

import java.util.Scanner;


public class AntiqueShop {

    public static void main(String[] args) {

        ItemList itemList = new ItemList();
        Scanner sc = new Scanner(System.in);
        int choice = 0;


        do {
            System.out.println("\n======= MENU CỬA HÀNG ĐỒ CỔ =======");
            System.out.println("1. Thêm một Bình hoa (Vase) mới");
            System.out.println("2. Thêm một Bức tượng (Statue) mới");
            System.out.println("3. Thêm một Bức tranh (Painting) mới");
            System.out.println("4. Hiển thị tất cả các món đồ");
            System.out.println("5. Tìm món đồ theo tác giả");
            System.out.println("6. Cập nhật món đồ theo ID");
            System.out.println("7. Hiển thị các Bình hoa (Vase)");
            System.out.println("8. Hiển thị các Bức tượng (Statue)");
            System.out.println("9. Hiển thị các Bức tranh (Painting)");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1: // Thêm Vase
                        Item vase = new Vase();
                        vase.input(sc);
                        if (itemList.addItem(vase)) {
                            System.out.println("Đã thêm Bình hoa thành công!");
                        }
                        break;
                    case 2:
                        Item statue = new Statue();
                        statue.input(sc);
                        if (itemList.addItem(statue)) {
                            System.out.println("Đã thêm Bức tượng thành công!");
                        }
                        break;
                    case 3:
                        Item painting = new Painting();
                        painting.input(sc);
                        if (itemList.addItem(painting)) {
                            System.out.println("Đã thêm Bức tranh thành công!");
                        }
                        break;
                    case 4: // Hiển thị tất cả
                        itemList.displayAll();
                        break;
                    case 5: // Tìm theo tác giả
                        System.out.print("Nhập tên tác giả cần tìm: ");
                        String creator = sc.nextLine();
                        Item foundItem = itemList.findItem(creator);
                        if (foundItem != null) {
                            System.out.println("Tìm thấy Item:");
                            System.out.println(foundItem);
                        } else {
                            System.out.println("Không tìm thấy Item nào của tác giả '" + creator + "'.");
                        }
                        break;
                    case 6: // Cập nhật theo ID
                        System.out.print("Nhập ID của Item cần cập nhật: ");
                        String idToUpdate = sc.nextLine();
                        itemList.updateItem(idToUpdate, sc);
                        break;
                    case 7:
                        itemList.displayItemsByType(ItemList.VASE);
                        break;
                    case 8:
                        itemList.displayItemsByType(ItemList.STATUE);
                        break;
                    case 9:
                        itemList.displayItemsByType(ItemList.PAINTING);
                        break;
                    case 0:
                        System.out.println("Đang thoát chương trình...");
                        break;
                    default:
                        System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 0 đến 9.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Lỗi: Vui lòng nhập một số cho lựa chọn menu.");
                choice = -1;
            } catch (Exception e) {

                System.err.println("Đã xảy ra lỗi: " + e.getMessage());

            }

        } while (choice != 0);

        sc.close();
        System.out.println("Đã thoát.");
    }
}