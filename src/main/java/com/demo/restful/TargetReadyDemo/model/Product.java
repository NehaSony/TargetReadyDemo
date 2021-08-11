package com.demo.restful.TargetReadyDemo.model;


import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
*
* Any Product contains following attributes:-
- Product ID
- Product Name
- Selling Price
- Product Type(could be Own-Brand or External)
- Selling channel(online unique, store only, online and store)
- Discount Precent
Note: Discounts could change frequently and the Price should be calculated accordingly.
*
* */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @NotNull
    @Size(min = 11, max = 11,message = "Invalid size should be 11.")
    @Pattern(regexp="[0-9]*",message = "Should be a numeric value!")



    @JsonProperty("product_id")
    Integer productId;
    @JsonProperty("product_name")
    String productName;
    @JsonProperty("price")
    Double price;
    @JsonProperty("product_type")
    String productType;
    @JsonProperty("selling_channel")
    Enum sellingChannel;
    @JsonProperty("percentage")
    Float percentage;



    public Product(@NotNull @Size(min = 11, max = 11, message = "Invalid size should be 11.") @Pattern(regexp = "[0-9]*", message = "Should be a numeric value!") Integer productId, String productName, String productType, Enum sellingChannel, Float percentage) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.sellingChannel = sellingChannel;
        this.percentage = percentage;
    }

    public Product(@NotNull @Size(min = 11, max = 11, message = "Invalid size should be 11.") @Pattern(regexp = "[0-9]*", message = "Should be a numeric value!") Integer productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public Product() {
        super();
    }

    public List<Product> init(){
        List<Product> productList = new ArrayList<>();
        for(int i = 1 ; i<11;i++){
            productList.add(new Product(598748+i,"TestProduct"+i));
        }
        return productList;
    }
}
