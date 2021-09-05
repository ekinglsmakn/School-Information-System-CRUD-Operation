package com.example.okul.notlar;


public interface IDersNotuService {
    DersNotuDTO kaydet(DersNotuDTO dersNotuDTO) throws Exception;
    DersNotuDTO guncelle(DersNotuDTO dersNotuDTO) throws Exception;
    String sil(Long id) throws Exception;
}
