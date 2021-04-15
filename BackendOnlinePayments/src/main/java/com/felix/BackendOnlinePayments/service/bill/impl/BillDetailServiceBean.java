package com.felix.BackendOnlinePayments.service.bill.impl;

import com.felix.BackendOnlinePayments.service.bill.BillDetailService;
import com.felix.BackendOnlinePayments.model.BillDetails;
import com.felix.BackendOnlinePayments.repository.BillDetailRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillDetailServiceBean implements BillDetailService {

    @Autowired
    BillDetailRepositoryInterface daoBillDetail;

    @Override
    public List<BillDetails> getAll() {
        return daoBillDetail.findAll();
    }

    @Override
    public List<BillDetails> getByBill(Integer id) {
        return daoBillDetail.findByBillId(id);
    }
}
