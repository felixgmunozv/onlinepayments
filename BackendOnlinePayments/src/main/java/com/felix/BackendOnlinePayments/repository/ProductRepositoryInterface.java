package com.felix.BackendOnlinePayments.repository;

import com.felix.BackendOnlinePayments.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryInterface extends JpaRepository<Product, Integer> {
}
