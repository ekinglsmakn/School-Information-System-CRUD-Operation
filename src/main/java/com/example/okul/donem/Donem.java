package com.example.okul.donem;

import com.example.okul.ders.Ders;
import com.example.okul.ortak.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(initialValue = 1, name = "idGenerator", sequenceName = "donemSequence", allocationSize = 1)
public class Donem extends BaseEntity {

    private String ad;

    @OneToMany(mappedBy = "donem")
    private List<Ders> dersler;

}
