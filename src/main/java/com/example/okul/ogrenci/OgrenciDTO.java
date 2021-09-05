package com.example.okul.ogrenci;

import com.example.okul.ders.DersDTO;
import com.example.okul.ortak.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class OgrenciDTO extends BaseDTO {
    private String ad;
    private String soyad;
    private String tc;
    private List<DersDTO> ders;

}
