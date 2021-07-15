package org.datacode.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@Entity
public class Customer implements Serializable {
    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(insertable = false, updatable = false)
    private Long dbId;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "customer")
    private Collection<Address> addresses;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public Collection<Address> getAddresses() {
        return Collections.unmodifiableCollection(addresses);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", dbId=" + dbId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", number of addresses = " + (addresses != null ? addresses.size() : 0)  +
                '}';
    }
}
