package com.example.CokeStudios.controller;

import com.example.CokeStudios.Service.RazorpayService;
import com.razorpay.Order;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private RazorpayService razorpayService;



    @PostMapping("/createOrder")
    public Map<String, String> createOrder(@RequestBody Map<String, Object> orderDetails) {
        int amount = (Integer) orderDetails.get("amount");
        try {
            Order order = razorpayService.createOrder(amount);
            Map<String, String> response = Map.of("id", order.get("id"));
            return response;
        } catch (RazorpayException e) {
            throw new RuntimeException("Error creating Razorpay order", e);
        }
    }


}
