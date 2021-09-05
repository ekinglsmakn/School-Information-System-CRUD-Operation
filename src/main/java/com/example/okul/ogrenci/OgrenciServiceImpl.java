package com.example.okul.ogrenci;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OgrenciServiceImpl implements IOgrenciService{
    private IOgrenciRepo ogrenciRepo;
    private ModelMapper modelMapper;

    @Autowired
    public OgrenciServiceImpl(IOgrenciRepo ogrenciRepo, ModelMapper modelMapper) {
        this.ogrenciRepo = ogrenciRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OgrenciDTO> findAll() {
        return modelMapper.map(ogrenciRepo.findAll(),new TypeToken<List<OgrenciDTO>>(){}.getType());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OgrenciDTO kaydet(OgrenciDTO ogrenciDTO) throws Exception {
        return modelMapper.map(ogrenciRepo.save(modelMapper.map(ogrenciDTO, Ogrenci.class)),OgrenciDTO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OgrenciDTO guncelle(OgrenciDTO ogrenciDTO) throws Exception {
        Ogrenci ogrenci = modelMapper.map(ogrenciDTO, Ogrenci.class);/*get set yapmamak için kullandık */

        return modelMapper.map(ogrenciRepo.save(ogrenci),OgrenciDTO.class);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String sil(Long id) throws Exception {
        ogrenciRepo.deleteById(id);
        if(ogrenciRepo.getOne(id)==null){

            return "Silme islemi basarili";
        }
        else {
            return "Silme işlemi başarısız.";
        }
    }
}
