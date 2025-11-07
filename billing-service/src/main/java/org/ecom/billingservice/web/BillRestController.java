package org.ecom.billingservice.web;

import lombok.AllArgsConstructor;
import org.ecom.billingservice.entities.Bill;
import org.ecom.billingservice.models.Customer;
import org.ecom.billingservice.feign.CustomerServiceRestClient;
import org.ecom.billingservice.feign.ProductServiceRestClient;
import org.ecom.billingservice.repositories.BillingRepository;
import org.ecom.billingservice.repositories.ProductItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BillRestController {
    BillingRepository billingRepository;
    ProductItemRepository productItemRepository;
    CustomerServiceRestClient customerServiceRestClient;
    ProductServiceRestClient productServiceRestClient;

    @GetMapping("/bills/{id}")
    Bill getBillById(@PathVariable Long id) {
        Bill bill = billingRepository.findById(id).get();
        Customer customer = customerServiceRestClient.findCustomerById(bill.getCustomerId());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(
                    productServiceRestClient.findByProductId(productItem.getProductId())
            );
        });

        return bill;
//        bills.forEach(bill -> {
//            List<ProductItem> productItems = productItemRepository.findByBillId(bill.getId());
//            productItems.forEach(productItem -> {
//                productItem.setProduct(productServiceRestClient.findByProductId(productItem.getProductId()));
//            });
//            bill.setProductItems(productItems);
//        });
    }
}
