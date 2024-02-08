package com.simapp.firetec.currapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Currency;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyApiResponce {

    private Map<String , CurrencyData> data;

    public Map<String, CurrencyData> getData() {
        return data;
    }

    public void setData(Map<String, CurrencyData> data) {
        this.data = data;
    }

    public static class CurrencyData{
        private String code;
        private double value;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }
}
