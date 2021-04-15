package com.felix.BackendOnlinePayments.repository;

import com.felix.BackendOnlinePayments.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepositoryInterface extends JpaRepository<Bill, Integer> {

}
