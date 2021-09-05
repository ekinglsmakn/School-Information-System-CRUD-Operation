package com.example.okul.donem;

import java.util.List;

public interface IDonemService {
    DonemDTO kaydet(DonemDTO donemDTO) throws Exception;
    DonemDTO guncelle(DonemDTO donemDTO) throws Exception;
    String sil(Long id) throws Exception;
    List<DonemDTO> tumunuGetir();

}
