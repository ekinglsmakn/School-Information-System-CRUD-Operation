package com.example.okul.hoca;
public interface IHocaService {

    HocaDTO kaydet(HocaDTO hocaDTO);
    HocaDTO guncelle(HocaDTO hocaDTO) ;
    String sil(Long id);
}



