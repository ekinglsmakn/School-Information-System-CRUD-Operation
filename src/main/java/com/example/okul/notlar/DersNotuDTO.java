package com.example.okul.notlar;

import com.example.okul.ders.DersDTO;
import com.example.okul.ortak.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DersNotuDTO extends BaseDTO {
    private Integer puan;
    private DersDTO dersDTO;
}
