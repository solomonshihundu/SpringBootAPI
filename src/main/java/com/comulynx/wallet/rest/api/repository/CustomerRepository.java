package com.comulynx.wallet.rest.api.repository;

import java.util.List;
import java.util.Optional;

import com.comulynx.wallet.rest.api.model.JoinedInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.comulynx.wallet.rest.api.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByCustomerId(String customerId);
    Optional<Customer> findByCustomerIdOrEmail(String customerId, String email);

    // TODO : Implement the query and function below to delete a customer using Customer Id
    @Query(value = "DELETE FROM customers WHERE customer_id = ?;", nativeQuery = true)
    int deleteCustomerByCustomerId(String customer_id);

    // TODO : Implement the query and function below to update customer firstName using Customer Id
    @Query(value = "UPDATE FROM customers SET first_name=?1 WHERE customer_id = ?2;", nativeQuery = true)
    int updateCustomerByCustomerId(String firstName, String customer_id);

    // TODO : Implement the query and function below and to return all customers whose Email contains  'gmail'
    @Query(value = "SELECT * FROM customers WHERE email LIKE '%gmail.com';", nativeQuery = true)
    List<Customer> findAllCustomersWhoseEmailContainsGmail();
}
