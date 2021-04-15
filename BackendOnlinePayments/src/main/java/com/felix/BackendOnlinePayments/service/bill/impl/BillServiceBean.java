package com.felix.BackendOnlinePayments.service.bill.impl;

import com.felix.BackendOnlinePayments.service.bill.BillService;
import com.felix.BackendOnlinePayments.dto.BillDetailDto;
import com.felix.BackendOnlinePayments.dto.BillDto;
import com.felix.BackendOnlinePayments.dto.ProductQuantityDto;
import com.felix.BackendOnlinePayments.model.Bill;
import com.felix.BackendOnlinePayments.model.BillDetails;
import com.felix.BackendOnlinePayments.model.Product;
import com.felix.BackendOnlinePayments.model.User;
import com.felix.BackendOnlinePayments.repository.BillDetailRepositoryInterface;
import com.felix.BackendOnlinePayments.repository.BillRepositoryInterface;
import com.felix.BackendOnlinePayments.repository.ProductRepositoryInterface;
import com.felix.BackendOnlinePayments.repository.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BillServiceBean implements BillService {

    @Autowired
    private BillRepositoryInterface daoBill;

    @Autowired
    BillDetailRepositoryInterface daoBillDetail;

    @Autowired
    private UserRepositoryInterface daoUser;

    @Autowired
    private ProductRepositoryInterface daoProduct;

    @Override
    public Bill createBill(BillDto dto) {
        BillDetailDto billDetailDto = generateBillDetail(dto);
        List<BillDetails> billDetails = new ArrayList<>();
        Bill bill;
        Integer id = null;
        if (!billDetailDto.getDetalle().isEmpty()){
            bill = daoBill.save(billDetailDto.getFactura());
            id = bill.getId();
            billDetailDto.getDetalle().forEach(iD ->{
                iD.setBill(bill);
                billDetails.add(iD);
            });
            daoBillDetail.saveAll(billDetails);
        }
        return daoBill.findById(id).orElse(null);
    }


    private BillDetailDto generateBillDetail(BillDto dto){
        if (dto.getIdUser()==null){
            dto.setIdUser(1);
        }
        User user = daoUser.findById(dto.getIdUser()).orElse(null);

        double subTotal= 0.0;
        double total= 0.0;
        double iva= 0.0;
        double domicilio = 0.0;
        Bill bill = new Bill(LocalDateTime.now(),LocalDateTime.now(),user);
        List<BillDetails> billDetails = new ArrayList<>();
        if (dto.getProductsQuantitys() != null){
            for (ProductQuantityDto pQ : dto.getProductsQuantitys()) {
                Product product = daoProduct.findById(pQ.getProductId()).orElse(null);
                if (product != null) {
                    billDetails.add(new BillDetails( product, bill, pQ.getQuantity()));
                    subTotal = subTotal + (product.getPrice() * pQ.getQuantity());
                }else{
                    throw new RuntimeException("no se encontro ningun producto con el id:"+pQ.getProductId());
                }
            }
        }

        if (subTotal >100000){
            domicilio=0.0;
        }else {
            domicilio=5000.0;
        }
        iva = subTotal*0.19;
        total = subTotal+iva+domicilio;

        bill.setIva(iva);
        bill.setSubTotal(subTotal);
        bill.setTotal(total);
        bill.setIsDelivery(domicilio);
        bill.setIsCanceled(false);
        BillDetailDto billDetailDto = new BillDetailDto();

        billDetailDto.setFactura(bill);
        billDetailDto.setDetalle(billDetails);
        return billDetailDto;
    }


    @Override
    public Bill updateBill(BillDto dto) {

        Bill billInDb = daoBill.findById(dto.getId()).orElse(null);
        if (billInDb != null){
            LocalDateTime fechaActual = LocalDateTime.now();
            fechaActual = fechaActual.minusHours(5);
            if (billInDb.getCreationDate().isAfter(fechaActual)){
                List<BillDetails> detailsDelete=daoBillDetail.findByBillId(dto.getId());
                if (!detailsDelete.isEmpty()){
                    for (BillDetails e : detailsDelete) {
                        daoBillDetail.deleteById(e.getId());
                    }
                }
                BillDetailDto billDetailDto = generateBillDetail(dto);
                List<BillDetails> billDetails = new ArrayList<>();
                Bill bill;
                if (!billDetailDto.getDetalle().isEmpty()){
                    bill = billDetailDto.getFactura();
                    bill.setId(dto.getId());
                    bill = daoBill.save(bill);

                    billDetailDto.getDetalle().forEach(iD ->{
                        iD.setBill(new Bill(dto.getId()));
                        billDetails.add(iD);
                    });
                    daoBillDetail.saveAll(billDetails);
                }
            }else {
                throw new RuntimeException("no se puede editar el pedido");
            }
        }else {
            throw new RuntimeException("no se encontro ningun pedido con ese id");
        }

        return daoBill.findById(dto.getId()).orElse(null);

    }

    @Override
    public Bill cancelBill(Integer billId) {
        Bill bill = daoBill.findById (billId).orElse(null);
        if (bill != null){
            LocalDateTime fechaActual = LocalDateTime.now();
            fechaActual = fechaActual.minusHours(12);
            if (bill.getCreationDate().isAfter(fechaActual)){
                bill.setIsCanceled(true);
                bill.setTotal(bill.getTotal()*0.1);
                bill.setSubTotal(0.0);
                bill.setIva(0.0);
                bill.setIsDelivery(0.0);
            }else {
                bill.setIsCanceled(true);
            }
            return daoBill.save(bill);
        }else {
            throw new RuntimeException("no se encontro ningun pedido con ese id");
        }

    }


    @Override
    public Bill searchBillById(Integer billId) {
        Bill bill = daoBill.findById (billId).orElse(null);
        return bill;
    }
}
