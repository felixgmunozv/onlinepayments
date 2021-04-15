package com.felix.BackendOnlinePayments.controller;

import com.felix.BackendOnlinePayments.service.bill.BillService;
import com.felix.BackendOnlinePayments.dto.BillDto;
import com.felix.BackendOnlinePayments.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/onlinepayments/api")
public class BillRestController {

    @Autowired
    private BillService service;
    //Consultar factura de pedido por usuario
    @GetMapping("/bill/{id}")
    public Bill findByUserId(@PathVariable Integer id){
        return service.searchBillById(id);
    }

    //Cancelar pedido
    @PutMapping("/bill/cancelar/{id}")
    public Bill cancelarPedido(@PathVariable Integer id){
        return service.cancelBill(id);
    }

    //Actualizar factura de pedido
    @PutMapping("/bill/{id}")
    public Bill update(@PathVariable Integer id, @RequestBody BillDto bill){
        bill.setId(id);
        return service.updateBill(bill);
    }

    //Guardar facturaa de pedido
    @PostMapping("/bill")
    public Bill guardar(@RequestBody BillDto bill){

        return service.createBill(bill);
    }
}
