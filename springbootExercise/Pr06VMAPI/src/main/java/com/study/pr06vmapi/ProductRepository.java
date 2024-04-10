package com.study.pr06vmapi;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Component
public class ProductRepository {
    public static List<Product> productList = new ArrayList<>();
}
