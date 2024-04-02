package com.simpleProject.tajilProductManagement.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TajilProductModule {
    private UUID productId;
    private String productName;
    private String productDesciption;
    private String productCategory;
    private Integer productPrice;
    private Integer productStock;
}
