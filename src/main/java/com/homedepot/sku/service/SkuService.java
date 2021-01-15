package com.homedepot.sku.service;

import com.homedepot.sku.dto.Sku;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SkuService {

    public List<Sku> getSkuDetails(List<Integer> skusInput) {
        List<Sku> defaultSkuList = createDefaultSkuList();
        List<Sku> responseSkus = new ArrayList<>();

        for (int i = 0; i < skusInput.size(); i++) {
            for (int j = 0; j < defaultSkuList.size(); j++) {
                if (skusInput.get(i) == defaultSkuList.get(j).getSkuNumber()) {
                    responseSkus.add(defaultSkuList.get(j));
                }
            }
        }

        return responseSkus;
    }

    public List<Sku> updateSkuRetail(List<Sku> skusInput) {
        List<Sku> defaultSkuList = createDefaultSkuList();
        List<Sku> updatedSkuList = new ArrayList<>();

        for (int i = 0; i < skusInput.size(); i++) {
            for (int j = 0; j < defaultSkuList.size(); j++) {
                if (skusInput.get(i).getSkuNumber() == defaultSkuList.get(j).getSkuNumber() && (skusInput.get(i).getMVendorNumber() == defaultSkuList.get(j).getMVendorNumber())) {
                    // Mock DB call to update / set the SKU's retail
                    defaultSkuList.get(j).setRetail(skusInput.get(i).getRetail());
                    updatedSkuList.add(defaultSkuList.get(j));
                }
            }
        }

        return updatedSkuList;
    }

    private List<Sku> createDefaultSkuList() {
        List<Sku> skuList = new ArrayList<>();
        skuList.add(new Sku("SKU 111111", 111111, 101010, 100));
        skuList.add(new Sku("SKU 222222", 222222, 202020, 150));
        skuList.add(new Sku("SKU 333333", 333333, 303030, 45));
        skuList.add(new Sku("SKU 444444", 444444, 404040, 70));
        skuList.add(new Sku("SKU 555555", 555555, 505050, 250));
        skuList.add(new Sku("SKU 666666", 555555, 606060, 175));
        return skuList;
    }
}
