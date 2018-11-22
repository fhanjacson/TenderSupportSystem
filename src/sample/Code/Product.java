package sample.Code;

public class Product {
    private Integer product_index;
    private String product_name;
    private String product_material;
    private String product_category;
    private Double product_price;

    public Product(int id, String name, String material, String category, Double price) {
        this.setProduct_index(id);
        this.setProduct_name(name);
        this.setProduct_material(material);
        this.setProduct_category(category);
        this.setProduct_price(price);

    }

    public Integer getProduct_index() {
        return product_index;
    }

    public void setProduct_index(Integer product_index) {
        this.product_index = product_index;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_material() {
        return product_material;
    }

    public void setProduct_material(String product_material) {
        this.product_material = product_material;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }
}
