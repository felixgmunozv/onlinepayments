package com.felix.BackendOnlinePayments.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "bill")
public class Bill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    private double subTotal;

    private double iva;

    private double total;

    private double isDelivery;

    private boolean isCanceled;

    public double getIsDelivery() {
        return isDelivery;
    }

    public boolean getIsCanceled() {
        return isCanceled;
    }

    public Bill(Integer id) {
        this.id = id;
    }

    public void setIsCanceled(boolean cancelado) {
        this.isCanceled = cancelado;
    }

    public void setIsDelivery(double domicilio) {
        this.isDelivery = domicilio;
    }

    public Bill() {
    }

    public Bill(LocalDateTime creationDate, LocalDateTime updateDate, User user) {

        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.user = user;

    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
