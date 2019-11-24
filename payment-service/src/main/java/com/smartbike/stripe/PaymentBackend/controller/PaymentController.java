package com.smartbike.stripe.PaymentBackend.controller;

import com.smartbike.stripe.PaymentBackend.StripeClient;
import com.smartbike.stripe.PaymentBackend.model.PaymentInfo;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/payment")
public class PaymentController {


    @Autowired
    private StripeClient stripeClient;

    @PostMapping("/charge")
    public  String chargeCard(@RequestBody PaymentInfo paymentInfo) throws Exception {
        String token = paymentInfo.getToken();
        int amount = paymentInfo.getAmount();
        System.out.println(token);
        Charge data = this.stripeClient.chargeCreditCard(token,amount);
        System.out.println(data);
        ResponseEntity<Charge>  charge = new ResponseEntity<Charge>(new Charge(), HttpStatus.OK);
        return data.toString();
    }



}
