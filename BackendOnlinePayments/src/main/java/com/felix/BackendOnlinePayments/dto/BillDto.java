package com.felix.BackendOnlinePayments.dto;

import java.util.List;

public class BillDto {
    private Integer id;
    private Integer idUser;
    private List<ProductQuantityDto> productsQuantitys;

    public BillDto(Integer idUser, List<ProductQuantityDto> productQuantity) {

        this.idUser = idUser;
        this.productsQuantitys = productQuantity;
    }

    public BillDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public List<ProductQuantityDto> getProductsQuantitys() {
        return productsQuantitys;
    }

    public void setProductsQuantitys(List<ProductQuantityDto> productsQuantitys) {
        this.productsQuantitys = productsQuantitys;
    }
}
