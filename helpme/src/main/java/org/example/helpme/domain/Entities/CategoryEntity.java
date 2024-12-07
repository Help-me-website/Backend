package org.example.helpme.domain.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    private Long category_id;
    private String name;
    private String description;
    private Date created_at;
}
