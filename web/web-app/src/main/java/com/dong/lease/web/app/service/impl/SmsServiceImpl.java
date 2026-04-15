package com.dong.lease.web.app.service.impl;

import com.aliyun.dysmsapi20180501.Client;
import com.aliyun.dysmsapi20180501.models.SendMessageToGlobeRequest;
import com.aliyun.dysmsapi20180501.models.SendMessageToGlobeResponse;
import com.dong.lease.web.app.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private Client client;

    @Override
    public void sendCode(String phone, String code) {

        SendMessageToGlobeRequest request = new SendMessageToGlobeRequest()
                .setTo(phone)
                .setMessage("Your verification code is " + code);

        try {
            SendMessageToGlobeResponse response = client.sendMessageToGlobe(request);

            // debug
            System.out.println("RequestId: " + response.getBody().getRequestId());


        } catch (Exception e) {
            throw new RuntimeException("SMS send failed", e);
        }
    }
}