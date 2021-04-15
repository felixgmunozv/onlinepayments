package com.felix.BackendOnlinePayments.repository;

import com.felix.BackendOnlinePayments.model.BillDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BillDetailRepositoryInterface extends JpaRepository<BillDetails, Integer> {

    @Query(nativeQuery = true,value = "DELETE FROM bill_DETAILS where bill_ID = ?1")
    void deleteByBill_Id(Integer billId);

   // @Query(nativeQuery = true,value = "SELECT * FROM bill_DETAILS WHERE bill_ID = ?1")
    List<BillDetails> findByBillId(Integer id);

}
