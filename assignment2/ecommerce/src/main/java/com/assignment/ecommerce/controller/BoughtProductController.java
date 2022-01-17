package com.assignment.ecommerce.controller;

import com.assignment.ecommerce.dto.BoughtProductDto;
import com.assignment.ecommerce.service.BoughtProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/buy")
@Tag(name = "Buy")
public class BoughtProductController {

    @Autowired
    BoughtProductService boughtProductService;

    @PostMapping("/buyProduct")
    public BoughtProductDto buyProduct(@Valid @RequestBody BoughtProductDto boughtProductDto) {
        return boughtProductService.buyProduct(boughtProductDto);
    }

    @GetMapping("/history")
    public List<BoughtProductDto> getHistory() {
        return boughtProductService.getHistory();
    }
}
