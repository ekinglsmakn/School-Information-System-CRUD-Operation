package com.example.okul.ders;
import com.example.okul.donem.Donem;
import com.example.okul.hoca.Hoca;
import com.example.okul.notlar.DersNotu;
import com.example.okul.ogrenci.Ogrenci;
import com.example.okul.ortak.BaseEntity;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(initialValue = 1, name = "idGenerator", sequenceName = "dersSequence", allocationSize = 1)
public class Ders extends BaseEntity {

    private String adi;

    @ManyToOne() //zorunlu alan olarak eklenmesi gerekir.
    private Donem donem;

    @ManyToMany
    private List<Ogrenci> ogrenci;

    @OneToMany
    private List<DersNotu> dersNotu;

    @ManyToMany(mappedBy = "dersler")
    private List<Hoca> hoca;

}