package com.yedam.app.customer;

import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 20, nullable = false)
    private String name;
    @Column(length = 20, nullable = false, unique = true)
    private String phone; 
    
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date enterDt;
//    
//    @UpdateTimestamp
//    private Date updateDt;
//    
//    @Transient
//    private String bigo;
}
