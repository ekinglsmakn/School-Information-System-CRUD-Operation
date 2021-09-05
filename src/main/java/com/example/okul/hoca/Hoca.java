package com.example.okul.hoca;

import com.example.okul.ders.Ders;
import com.example.okul.ortak.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(initialValue = 1, name = "idGenerator", sequenceName = "hocaSequence")
public class Hoca extends BaseEntity {

    private String ad;
    private String soyad;
    private String tckn;

    @ManyToMany()
     private List<Ders> dersler;

}


