package org.ecom.customerservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class TestConfigController {
    @Value("${global.params.p1}")
    private String p1;
    @Value("${global.params.p2}")
    private String p2;
    @Value("${customer.params.x}")
    private String x;
    @Value("${customer.params.y}")
    private String y;

    private CustomerConfigParams customerConfigParams;

    public TestConfigController(CustomerConfigParams customerConfigParams) {
        this.customerConfigParams = customerConfigParams;
    }

    @GetMapping("/test/config/global")
    public Map<String, String> testConfig(){
        return Map.of("p1", p1, "p2", p2);
    }

    @GetMapping("/test/config/customer/v2")
    public Map<String, String> testConfigV2(){
        return Map.of("x", x, "y", y);
    }

    // not work after actuator refresh because records are immutables
    @GetMapping("/test/config/customer")
    public CustomerConfigParams testCustomerConfig() {
        return customerConfigParams;
    }
}
