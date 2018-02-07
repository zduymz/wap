package edu.mum.wap.dao;

import java.util.HashMap;
import java.util.Map;

public class PriceDAO {
    private Map<String, Float> priceMap = new HashMap<>();
    {
        priceMap.put("adult", new Float(10.00));
        priceMap.put("child", new Float(13.00));
        priceMap.put("senio", new Float(10.00));
    }

    public Float getPrice(String type) {
        return priceMap.get(type);
    }
}
