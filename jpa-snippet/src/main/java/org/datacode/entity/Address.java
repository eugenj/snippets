package org.datacode.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Address {
    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @Column(insertable = false, updatable = false)
    private Long dbId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "dbId", name="customer_db_id")
    private Customer customer;

    private String street;

    private String zip;

    public Address() {
    }

    public Address(Customer customer, String street, String zip) {
        this.customer = customer;
        this.street = street;
        this.zip = zip;
        id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", dbId=" + dbId +
                ", customerId=" + customer.getId() +
                ", street='" + street + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
