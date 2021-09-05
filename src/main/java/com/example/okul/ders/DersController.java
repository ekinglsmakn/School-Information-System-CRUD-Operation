package com.example.okul.ders;
import com.example.okul.ortak.BaseResponse;
import com.example.okul.ortak.Util;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/ders")
@RestController
public class DersController {

    private IDersService dersService;
    public DersController(IDersService dersService) { //Constructor

        this.dersService=dersService;
    }

    @RequestMapping(value = "/kaydet",method = RequestMethod.POST)
    public DersDTO kaydet(@RequestBody DersDTO dersDTO) throws Exception {

       return dersService.kaydet(dersDTO);
    }

    @RequestMapping(value = "/guncelle",method = RequestMethod.PUT)
    public DersDTO guncelle(@RequestBody DersDTO dersDTO) throws Exception {

        return dersService.guncelle(dersDTO);
    }

    @RequestMapping(value = "/sil/{id}",method = RequestMethod.DELETE)
    public String sil(@PathVariable Long id) throws Exception {
        return dersService.sil(id);
    }

    @RequestMapping(value = "/tumunuGetir", method = RequestMethod.GET)
    public BaseResponse tumunuGetir() {
        try {
            return Util.islemSonucGetir(dersService.tumunuGetir());
        }   catch (Exception ex) {
            return Util.islemSonucGetir(ex);
        }
    }

}
