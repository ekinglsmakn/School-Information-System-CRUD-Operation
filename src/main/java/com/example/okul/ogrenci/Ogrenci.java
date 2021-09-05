package com.example.okul.ogrenci;
import com.example.okul.ders.Ders;
import com.example.okul.ortak.BaseEntity;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(initialValue = 1, name = "idGenerator", sequenceName = "ogrenciSequence")
public class Ogrenci extends BaseEntity {


    private String ad;
    private String soyad;
    private String tc;

    @ManyToMany(mappedBy = "ogrenci")
    private List<Ders> ders;
}