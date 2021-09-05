package com.example.okul.donem;
import com.example.okul.ortak.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DonemDTO extends BaseDTO{
   private  String ad;

   //@JsonIgnore //Zorunlu alanlarda sürekli iç içe yazmasın (döngüye girmesin) diye yazarız
  // private List<DersDTO> dersler;
}
