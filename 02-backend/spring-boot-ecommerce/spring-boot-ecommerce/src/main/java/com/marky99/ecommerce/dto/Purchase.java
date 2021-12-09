package com.marky99.ecommerce.dto;

import com.marky99.ecommerce.entity.Address;
import com.marky99.ecommerce.entity.Customer;
import com.marky99.ecommerce.entity.Order;
import com.marky99.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
