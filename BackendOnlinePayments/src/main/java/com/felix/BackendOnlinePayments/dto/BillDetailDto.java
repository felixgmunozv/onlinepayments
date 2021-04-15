package com.felix.BackendOnlinePayments.dto;

import com.felix.BackendOnlinePayments.model.Bill;
import com.felix.BackendOnlinePayments.model.BillDetails;

import java.util.List;

public class BillDetailDto {
    private Bill Factura ;
    private List<BillDetails> detalle;

    public Bill getFactura() {
        return Factura;
    }

    public void setFactura(Bill factura) {
        Factura = factura;
    }

    public List<BillDetails> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<BillDetails> detalle) {
        this.detalle = detalle;
    }
}
