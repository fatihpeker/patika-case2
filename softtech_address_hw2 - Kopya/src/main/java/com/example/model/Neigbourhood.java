package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Neigbourhood {

    @Id
    @Column(name = "neigbourhood_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String neigbourhood_id;

    private String name;

    //Bağlı olduğu ilçe ile arasındaki bağlantı kodu
    @JoinColumn(name = "district_id",referencedColumnName = "district_id")
    @ManyToOne(fetch = FetchType.LAZY)
    District district = new District();

}
