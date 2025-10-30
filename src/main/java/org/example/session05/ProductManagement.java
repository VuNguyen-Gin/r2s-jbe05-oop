package org.example.session05;


public class ProductManagement {

    private Product[] products = new Product[10];

    private int productCount = 0;

    public void addProduct(Product product) {

        if (product == null) {

            throw new IllegalArgumentException("Sản phẩm không hợp lệ (null).");

        }

        if (productCount >= products.length) {

            throw new IllegalStateException("Kho đã đầy, không thể thêm sản phẩm.");

        }


        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductID() == product.getProductID()) {

                throw new IllegalArgumentException("Lỗi: ID sản phẩm '" + product.getProductID() + "' đã tồn tại.");

            }
        }

        products[productCount] = product;
        productCount++;
    }

    public Product getProductByID(int productID) throws ProductNotFoundException {
        // Duyệt qua các sản phẩm hiện có trong mảng
        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductID() == productID) {
                return products[i];
            }
        }

        throw new ProductNotFoundException("Product with ID " + productID + " not found.");
    }


    public void updateProductQuantity(int productID, int newQuantity)
            throws ProductNotFoundException {


        Product productToUpdate = getProductByID(productID);

        productToUpdate.setQuantityInStock(newQuantity);
    }
}
