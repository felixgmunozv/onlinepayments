package com.felix.BackendOnlinePayments.service.bill;

import com.felix.BackendOnlinePayments.model.BillDetails;

import java.util.List;

public interface BillDetailService {

    List<BillDetails> getAll();
    List<BillDetails> getByBill(Integer id);
}
