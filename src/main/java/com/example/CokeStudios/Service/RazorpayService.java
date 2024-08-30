package com.example.CokeStudios.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RazorpayService {

    @Value("${razorpay.key.id}")
    private String razorpayKeyId;

    @Value("${razorpay.key.secret}")
    private String razorpayKeySecret;

    private RazorpayClient getClient() throws RazorpayException {
        return new RazorpayClient(razorpayKeyId, razorpayKeySecret);
    }

    public Order createOrder(int amount) throws RazorpayException {
        RazorpayClient client = getClient();
        Map<String, Object> orderParams = new HashMap<>();
        orderParams.put("amount", amount); // amount in paise
        orderParams.put("currency", "INR");
        orderParams.put("receipt", "receipt#1");
        JSONObject orderParamsJson = new JSONObject(orderParams);
        return client.orders.create(orderParamsJson);
    }
}

