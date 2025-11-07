package org.ecom.billingservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ecom.billingservice.models.Customer;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private long customerId;

    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;

    @Transient
    private Customer customer;
}
