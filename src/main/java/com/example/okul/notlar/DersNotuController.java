package com.example.okul.notlar;


import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/dersNotu")
@RestController
public class DersNotuController {

    private IDersNotuService dersNotuService;
    public DersNotuController(IDersNotuService dersNotuService) {
        this.dersNotuService=dersNotuService;
    }

    @RequestMapping(value = "/kaydet",method = RequestMethod.POST)
    public DersNotuDTO kaydet(@RequestBody DersNotuDTO dersNotuDTO) throws Exception {
        return dersNotuService.kaydet(dersNotuDTO);
    }

    @RequestMapping(value = "/guncelle",method = RequestMethod.PUT)
    public DersNotuDTO guncelle(@RequestBody DersNotuDTO dersNotuDTO) throws Exception {
        return dersNotuService.guncelle(dersNotuDTO);
    }

    @RequestMapping(value = "/sil/{id}",method = RequestMethod.DELETE)
    public String sil(@PathVariable Long id) throws Exception {
        return dersNotuService.sil(id);
    }

}
