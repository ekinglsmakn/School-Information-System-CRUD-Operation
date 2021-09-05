package com.example.okul.notlar;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DersNotuServicesImpl implements IDersNotuService {
    private IDersNotuRepo dersNotuRepo;
    private ModelMapper modelMapper;


    @Autowired
    public DersNotuServicesImpl(IDersNotuRepo dersNotuRepo, ModelMapper modelMapper) {
        this.dersNotuRepo = dersNotuRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public DersNotuDTO kaydet(DersNotuDTO dersNotuDTO) throws Exception {
        return modelMapper.map(dersNotuRepo.save(modelMapper.map(dersNotuDTO, DersNotu.class)), DersNotuDTO.class);
    }

    @Override
    public DersNotuDTO guncelle(DersNotuDTO dersNotuDTO) throws Exception {
       /* Notlar notlar = modelMapper.map(notlarDTO, Notlar.class);*//*get set yapmamak için kullandık *//*
        notlarRepo.save(notlar);
        return notlarDTO;
        */

        dersNotuRepo.save(modelMapper.map(dersNotuDTO, DersNotu.class));
        return dersNotuDTO;
    }

    @Override
    public String sil(Long id) throws Exception {
        dersNotuRepo.deleteById(id);
        if(dersNotuRepo.getOne(id)==null){

            return "Silme islemi basarili";
        }
        else {
            return "Silme işlemi başarısız.";
        }
    }


}
