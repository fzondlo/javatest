package com.homedepot.sku.dto;

import lombok.Data;

@Data
public class Sku {

    public Sku (String skuDescription, int skuNumber, int mVendorNumber, int retail) {
        this.skuDescription = skuDescription;
        this.skuNumber = skuNumber;
        this.mVendorNumber = mVendorNumber;
        this.retail = retail;
    }

    private String skuDescription;
    private int skuNumber;
    private int mVendorNumber;
    private int retail;
}
