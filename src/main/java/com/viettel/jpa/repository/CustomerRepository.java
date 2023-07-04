package com.viettel.jpa.repository;

import com.viettel.jpa.dto.OrderResponse;
import com.viettel.jpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository  extends JpaRepository<Customer, Integer> {
    @Query("SELECT new com.viettel.jpa.dto.OrderResponse(c.name , p.productName, p.price) FROM Customer c JOIN c.products p")
    public List<OrderResponse> getJoinInformation();
}
