package sample.Code;

public class Product {
    private Integer product_index;
    private String product_name;
    private String product_material;
    private String product_category;
    private Double product_price;
    private Double product_discount;
    private Double product_markup;
    private Double product_labourcost;

    public Product(){}

    public Product(Integer product_index, String product_name, String product_material, String product_category, Double product_price, Double product_discount, Double product_markup, Double product_labourcost) {
        this.product_index = product_index;
        this.product_name = product_name;
        this.product_material = product_material;
        this.product_category = product_category;
        this.product_price = product_price;
        this.product_discount = product_discount;
        this.product_markup = product_markup;
        this.product_labourcost = product_labourcost;
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

    public Double getProduct_discount() {return product_discount;}
    public void setProduct_discount(Double product_discount) {this.product_discount = product_discount;}

    public Double getProduct_markup() {
        return product_markup;
    }
    public void setProduct_markup(Double product_markup) {
        this.product_markup = product_markup;
    }

    public Double getProduct_labourcost() {
        return product_labourcost;
    }
    public void setProduct_labourcost(Double product_labourcost) {
        this.product_labourcost = product_labourcost;
    }
}
