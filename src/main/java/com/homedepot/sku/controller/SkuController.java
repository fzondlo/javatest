package com.homedepot.sku.controller;

import com.homedepot.sku.dto.Sku;
import com.homedepot.sku.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SkuController {

    @Autowired
    SkuService skuService;

    @GetMapping(value = "/sku/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Sku>> getSkuDetails(@RequestParam("skus") List<Integer> skus) {
        List<Sku> skusResponse = skuService.getSkuDetails(skus);
        return new ResponseEntity<>(skusResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/sku/retail/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Sku>> updateSkuRetail(@RequestBody List<Sku> skuList) {
        List<Sku> skuResponse = skuService.updateSkuRetail(skuList);
        return new ResponseEntity<>(skuResponse, HttpStatus.OK);
    }
}
