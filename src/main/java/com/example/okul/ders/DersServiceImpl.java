package com.example.okul.ders;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service(value = "ders")
public class DersServiceImpl implements IDersService {

    private IDersRepo idersRepo;
    private ModelMapper modelMapper;

    @Autowired
    public DersServiceImpl(IDersRepo idersRepo, ModelMapper modelMapper) {
        this.idersRepo = idersRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DersDTO> tumunuGetir() {
        return modelMapper.map(idersRepo.findAll(),new TypeToken<List<DersDTO>>(){}.getType());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public DersDTO kaydet(DersDTO dersDTO) throws Exception {


        return modelMapper.map(idersRepo.save(modelMapper.map(dersDTO, Ders.class)),DersDTO.class);

    }

    @Override
    public DersDTO guncelle(DersDTO dersDTO) throws Exception {

        Ders ders = idersRepo.getOne(dersDTO.getId());
        //getId:guncelleştirmek istenilen id
        //getOne: istenilen id'nin bilgilerini veri tabanından çeker
        ders.setAdi(dersDTO.getAdi());
        return modelMapper.map(idersRepo.save(ders),DersDTO.class);

    }

    @Override
    public String sil(Long id) throws Exception {
        idersRepo.deleteById(id);
        if(idersRepo.getOne(id)==null){
            return "Başarılı bir şekilde silinmiştir.";
        }
        else {
            return "Silme işlemi başarısız.";
        }
    }
}
