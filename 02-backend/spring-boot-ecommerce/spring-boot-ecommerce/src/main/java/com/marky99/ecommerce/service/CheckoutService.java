package com.marky99.ecommerce.service;

import com.marky99.ecommerce.dto.Purchase;
import com.marky99.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
