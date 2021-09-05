package com.example.okul.hoca;
import com.example.okul.ortak.BaseResponse;
import com.example.okul.ortak.Util;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/hoca")
@RestController
public class HocaController {

    private IHocaService hocaService;
    public HocaController(IHocaService hocaService) {
        this.hocaService=hocaService;
    }

    @RequestMapping(value = "/kaydet",method = RequestMethod.POST)
    public BaseResponse kaydet(@RequestBody HocaDTO hocaDTO) throws Exception {
        try{
            return Util.islemSonucGetir(hocaService.kaydet(hocaDTO));
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "/guncelle",method = RequestMethod.PUT)
    public BaseResponse guncelle(@RequestBody HocaDTO hocaDTO)  {
        try{
            return Util.islemSonucGetir(hocaService.guncelle(hocaDTO));
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "/sil/{id}",method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable Long id)  {
        try{
            return Util.islemSonucGetir(hocaService.sil(id));
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }
}
