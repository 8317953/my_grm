package com.haut.grm.model;

public class Product {
	private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 产品名称 */
    private String name;

    /** 产品型号 */
    private String productClass;

    /** 产品ID */
    private String productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductClass() {
        return productClass;
    }

    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", productClass="
                + productClass + ", productId=" + productId + "]";
    }
}
