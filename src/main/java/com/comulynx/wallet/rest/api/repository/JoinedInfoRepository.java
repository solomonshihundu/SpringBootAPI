package com.comulynx.wallet.rest.api.repository;

import com.comulynx.wallet.rest.api.model.JoinedInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JoinedInfoRepository extends JpaRepository<JoinedInfo, String> {
    @Query(value = "SELECT cu.customer_id, ac.account_no, cu.first_name, cu.last_name, ac.balance FROM customers cu" +
            " INNER JOIN " +
            "accounts ac ON ac.customer_id = cu.customer_id  WHERE ac.customer_id = ?", nativeQuery = true)
    Optional<JoinedInfo> accountByCustomerId(String customer_id);
}
