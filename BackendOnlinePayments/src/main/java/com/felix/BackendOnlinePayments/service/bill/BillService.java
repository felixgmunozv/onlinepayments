package com.felix.BackendOnlinePayments.service.bill;

import com.felix.BackendOnlinePayments.dto.BillDto;
import com.felix.BackendOnlinePayments.model.Bill;

public interface BillService {

    Bill createBill(BillDto dto);

    Bill updateBill(BillDto dto);

    Bill cancelBill(Integer billId);

    Bill searchBillById(Integer billId);
}
