package com.example.okul.hoca;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Getter
@Setter
@NoArgsConstructor
@Service(value = "hocaService")
public class HocaServicesImpl implements IHocaService{

    private IHocaRepo hocaRepo;
    private ModelMapper modelMapper;

    @Autowired
    public HocaServicesImpl(IHocaRepo hocaRepo, ModelMapper modelMapper) {
        this.hocaRepo = hocaRepo;
        this.modelMapper = modelMapper;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public HocaDTO kaydet(HocaDTO hocaDTO) {

        Hoca hoca = modelMapper.map(hocaDTO,Hoca.class);
        return modelMapper.map(hocaRepo.save(hoca),HocaDTO.class);

      //  return modelMapper.map(hocaRepo.save(modelMapper.map(hocaDTO, Hoca.class)),HocaDTO.class);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public HocaDTO guncelle(HocaDTO hocaDTO) {
        Hoca hoca = hocaRepo.getOne(hocaDTO.getId());
        hoca.setAd(hoca.getAd());
        return modelMapper.map(hocaRepo.save(hoca), HocaDTO.class);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String sil(Long id)  {
        hocaRepo.deleteById(id);
        if(hocaRepo.getOne(id)==null){

            return "Silme islemi basarili";
        }
        else {
            return "Silme işlemi başarısız.";
        }
    }
}
