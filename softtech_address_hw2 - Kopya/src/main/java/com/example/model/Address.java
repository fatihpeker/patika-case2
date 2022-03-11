package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String address_id;

    private int buildingNumber;

    private int doorNumber;

    /**
     * Address içeriğinde country, city, district, neigbourhood, street bilgilerini tutuyor.
     * aşağıda gerekli ilişkiler kurulmuştur
     */

    @JoinColumn(name = "country_id",referencedColumnName = "country_id")
    @ManyToOne(fetch = FetchType.LAZY)
    Country country = new Country();

    @JoinColumn(name = "city_id",referencedColumnName = "city_id")
    @ManyToOne(fetch = FetchType.LAZY)
    City city = new City();

    @JoinColumn(name = "district_id",referencedColumnName = "district_id")
    @ManyToOne(fetch = FetchType.LAZY)
    District district = new District();

    @JoinColumn(name = "neigbourhood_id",referencedColumnName = "neigbourhood_id")
    @ManyToOne(fetch = FetchType.LAZY)
    Neigbourhood neigbourhood = new Neigbourhood();

    @JoinColumn(name = "street_id",referencedColumnName = "street_id")
    @ManyToOne(fetch = FetchType.LAZY)
    Street street = new Street();
}
