package com.rentmate.rmloginservice.framework.dao.model;

import com.rentmate.rmloginservice.dao.model.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Authority. 2024/02/11 15:57
 * Description: customer role
 * Author: Ricky
 *
 * @version 1.0.0
 */
@Getter
@Setter
@Entity
@Table(name="customers_authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id", nullable = false)
    private Integer memberId;

    @Column(name = "authority", nullable = false)
    private String authority;

    @ManyToOne
    @JoinColumn(name = "member_id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "fk_customer"))
    private Customer customer;
}
