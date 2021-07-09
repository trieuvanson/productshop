package com.demo.laptopshop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "category_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cate_name")
    private String cate_name;

    @Column(name = "cate_slug")
    private String cate_slug;

    @Column(name = "cate_banner")
    private String cate_banner;

    @Column(name = "parent_id")
    private int parent_id;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    @Column(name = "create_at")
    private Date create_at;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    @Column(name = "update_at")
    private Date update_at;




}
