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
public class Street {

    @Id
    @Column(name = "street_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String street_id;

    private String name;

    //Bağlı olduğu mahalle ile arasındaki bağlantı kodu
    @JoinColumn(name = "neigbourhood_id",referencedColumnName = "neigbourhood_id")
    @ManyToOne(fetch = FetchType.LAZY)
    Neigbourhood neigbourhood = new Neigbourhood();

}
