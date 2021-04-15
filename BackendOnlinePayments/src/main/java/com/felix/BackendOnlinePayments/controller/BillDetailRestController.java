package com.felix.BackendOnlinePayments.controller;

import com.felix.BackendOnlinePayments.service.bill.BillDetailService;
import com.felix.BackendOnlinePayments.model.BillDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/onlinepayments/api")
public class BillDetailRestController {

    @Autowired
    private BillDetailService service;

    //Obtener Detalles de una factura
    @GetMapping("/billDetail/{id}")
    public List<BillDetails> findByUserId(@PathVariable Integer id){
        return service.getByBill(id);
    }

    //Obtener todos los detalles de las facturas en el sistema
    @GetMapping("/billDetail")
    public List<BillDetails> getAll(){
        return service.getAll();
    }
}
