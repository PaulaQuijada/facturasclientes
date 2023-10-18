package com.facturacionclientes.Repository;

import com.facturacionclientes.Domain.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
    List<Receipt> findByMesAndAnyo(int mes, int anyo);
}
