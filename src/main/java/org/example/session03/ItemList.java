package org.example.session03;
import java.util.Scanner; // Cần cho phương thức updateItem


public class ItemList {

    private Item[] list;
    private int numOfItem;
    private final int MAX = 100;


    public static final String VASE = "Vase";
    public static final String STATUE = "Statue";
    public static final String PAINTING = "Painting";



    public ItemList() {
        list = new Item[MAX];
        numOfItem = 0;
    }


    public boolean addItem(Item item) {

        if (item == null || numOfItem >= MAX) {
            System.err.println("Lỗi: Không thể thêm item (null hoặc danh sách đầy).");
            return false;
        }

        for (int i = 0; i < numOfItem; i++) {
            if (list[i].getId().equalsIgnoreCase(item.getId())) {
                System.err.println("Lỗi: ID '" + item.getId() + "' đã tồn tại. Không thể thêm.");
                return false;
            }
        }


        list[numOfItem] = item;
        numOfItem++;
        return true;
    }


    public void displayAll() {
        if (numOfItem == 0) {
            System.out.println("Danh sách trống.");
            return;
        }
        System.out.println("\n--- DANH SÁCH TẤT CẢ ITEM ---");
        for (int i = 0; i < numOfItem; i++) {

            System.out.println(list[i]);
        }
    }


    public Item findItem(String creator) {
        if (creator == null || creator.trim().isEmpty()) {
            return null;
        }
        for (int i = 0; i < numOfItem; i++) {

            if (list[i].getCreator().equalsIgnoreCase(creator.trim())) {
                return list[i];
            }
        }
        return null;
    }


    public boolean updateItem(String id, Scanner sc) {
        if (id == null || id.trim().isEmpty()) {
            System.err.println("Lỗi: ID để cập nhật không được rỗng.");
            return false;
        }

        int foundIndex = -1; // Biến lưu vị trí tìm thấy
        for (int i = 0; i < numOfItem; i++) {
            if (list[i].getId().equalsIgnoreCase(id.trim())) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {

            System.out.println("Tìm thấy Item. Vui lòng nhập thông tin mới:");
            Item itemToUpdate = list[foundIndex];


            itemToUpdate.input(sc);

            System.out.println("Cập nhật thành công!");
            return true;
        } else {

            System.err.println("Lỗi: Không tìm thấy Item với ID '" + id.trim() + "'.");
            return false;
        }
    }

    public void displayItemsByType(String type) {
        if (numOfItem == 0) {
            System.out.println("Danh sách trống.");
            return;
        }

        boolean found = false;
        System.out.println("\n--- DANH SÁCH ITEM LOẠI: " + type + " ---");

        if (VASE.equalsIgnoreCase(type)) {
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Vase) {
                    System.out.println(list[i]);
                    found = true;
                }
            }
        } else if (STATUE.equalsIgnoreCase(type)) {
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Statue) {
                    System.out.println(list[i]);
                    found = true;
                }
            }
        } else if (PAINTING.equalsIgnoreCase(type)) {
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Painting) {
                    System.out.println(list[i]);
                    found = true;
                }
            }
        } else {
            System.out.println("Loại Item không hợp lệ: " + type);
            return;
        }


        if (!found) {
            System.out.println("Không tìm thấy Item nào thuộc loại '" + type + "'.");
        }
    }
}