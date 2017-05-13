package com.skripsi.Controller;

import com.skripsi.Domain.DonationEntity;
import com.skripsi.Domain.Wrapper;
import com.skripsi.Service.DonationService;
import com.skripsi.Service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Andri Kurniawan <andrikurniawan.id@gmail.com>
 * on 5/13/2017.
 */

@RestController
@RequestMapping("/donation")
public class DonationController {

    @Autowired
    private ProgramService programService;

    @Autowired
    private DonationService donationService;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public Wrapper create(@RequestParam("id") int id,
                          @RequestParam("name") String name,
                          @RequestParam("amount") int amount,
                          @RequestParam("pId") int pId){
        DonationEntity donationEntity = new DonationEntity();
        donationEntity.setId(id);
        donationEntity.setName(name);
        donationEntity.setAmount(amount);
        donationEntity.setpId(pId);
        DonationEntity hasil = donationService.save(donationEntity);

        if(hasil == null){
            return new Wrapper(501, "Gagal menyimpan program baru", null);
        }
        return new Wrapper(200, "Program berhasil disimpan", donationEntity);
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public Wrapper update(@RequestParam("id") int id,
                          @RequestParam("name") String name,
                          @RequestParam("amount") int amount,
                          @RequestParam("pId") int pId) {
        DonationEntity donationEntity = donationService.findById(id);
        donationEntity.setName(name);
        donationEntity.setAmount(amount);
        donationEntity.setpId(pId);
        DonationEntity hasil = donationService.save(donationEntity);

        if(hasil == null){
            return new Wrapper(501, "Gagal memperbaharui donasi", null);
        }
        return new Wrapper(200, "Donasi berhasil diperbaharui", donationEntity);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public Wrapper delete(@RequestParam("id") int id){
        List<DonationEntity> hasil = donationService.delete(id);
        if(hasil == null){
            return new Wrapper(501, "Gagal menghapus program", null);
        }
        return new Wrapper(200, "Berhasil menghapus program", hasil);
    }
}
