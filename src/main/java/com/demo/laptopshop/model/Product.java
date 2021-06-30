package com.demo.laptopshop.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "categoryId")
    private Long categoryId;
    @Temporal(TemporalType.DATE)
    @Column(name = "createdate")
    private Date createdate= new java.sql.Date(new Date().getTime());
    @Column(name = "beforePrice")
    private Double beforePrice;
    @Column(name = "currentPrice")
    private Double currentPrice;
    @Column(name = "avaiable")
    private Boolean avaiable;
    @Column(name = "images")
    private String images;


}
