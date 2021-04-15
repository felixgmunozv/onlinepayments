package com.felix.BackendOnlinePayments.repository;

import com.felix.BackendOnlinePayments.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryInterface extends JpaRepository<User,Integer> {
}
