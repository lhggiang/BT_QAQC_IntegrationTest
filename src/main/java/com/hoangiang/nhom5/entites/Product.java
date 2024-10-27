package com.hoangiang.nhom5.entites;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    Long id;
    String name;
    int quantity;
}