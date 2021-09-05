package com.example.okul.notlar;

import com.example.okul.ders.Ders;
import com.example.okul.ortak.BaseEntity;
import com.example.okul.enums.EnumNotTipi;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor /*parametresiz constructor*/
@AllArgsConstructor /*parametresiz constructor*/
@SequenceGenerator(initialValue = 1, name = "idGenerator", sequenceName = "dersNotuSequence") /*idleri sıralar*/
public class DersNotu extends BaseEntity {
    private Integer puan;

    @Enumerated
    private EnumNotTipi tip;

    @ManyToOne
    private Ders ders;

}
