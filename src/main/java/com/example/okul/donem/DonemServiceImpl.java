package com.example.okul.donem;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "donemService")
public class DonemServiceImpl implements IDonemService {
    private IDonemRepo donemRepo;
    private ModelMapper modelMapper;

    @Autowired
    public DonemServiceImpl(IDonemRepo donemRepo, ModelMapper modelMapper) {
        this.donemRepo = donemRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public DonemDTO kaydet(DonemDTO donemDTO) throws Exception {
        Donem donem = modelMapper.map(donemDTO, Donem.class);
        return modelMapper.map(donemRepo.save(donem),DonemDTO.class);

        //return modelMapper.map(donemRepo.save(modelMapper.map(donemDTO, Donem.class)), DonemDTO.class); bu şekilde de yazabiliriz.

    }

    @Override
    public DonemDTO guncelle(DonemDTO donemDTO) throws Exception {

        Donem donem = donemRepo.getOne(donemDTO.getId()); //id'yi aldık
        donem.setAd(donemDTO.getAd());
        return modelMapper.map(donemRepo.save(donem),DonemDTO.class);


        /*Donem donem = modelMapper.map(donemDTO, Donem.class);
        donemRepo.save(donem);
        return donemDTO;*/
    }

    @Override
    public String sil(Long id) throws Exception {
        donemRepo.deleteById(id);
        if(donemRepo.getOne(id)==null){
            return "Başarılı bir şekilde silinmiştir.";
        }
        else {
            return "Silme işlemi başarısız.";
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<DonemDTO> tumunuGetir() {

        return modelMapper.map(donemRepo.findAll(),new TypeToken<List<DonemDTO>>(){}.getType());
    }

}
