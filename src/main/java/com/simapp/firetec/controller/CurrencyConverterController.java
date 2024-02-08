package com.simapp.firetec.controller;

import com.simapp.firetec.currapi.CurrencyApiResponce;
import com.simapp.firetec.model.ConversionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/currency")
public class CurrencyConverterController {

    @PostMapping("/convert")
    public double convertCurrency(@RequestBody ConversionRequest request){

        String apiKey = "cur_live_FkMXZ2IayyX6eLyK4JFZRbAa1PJysqBUNv8Xmm58";
        String apiUrl = "https://api.currencyapi.com/v3/latest";

        String url = apiUrl + "?apikey=" + apiKey + "&base_currency=" + request.getSourceCurrency()  + "&currencies=" + request.getTargetCurrency();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CurrencyApiResponce> response = restTemplate.getForEntity(url, CurrencyApiResponce.class);

        CurrencyApiResponce currencyApiResponce = response.getBody();
        if (currencyApiResponce != null && currencyApiResponce.getData() != null){
            Double exchangeRate = currencyApiResponce.getData().get(request.getTargetCurrency()).getValue();
            double convertedAmount = request.getAmount() * exchangeRate;
            return convertedAmount;
        } else {
            return -1;
        }
    }
}
