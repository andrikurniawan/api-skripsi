package com.skripsi.Controller;

import com.skripsi.Domain.ProgramEntity;
import com.skripsi.Domain.Wrapper;
import com.skripsi.Service.*;
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
@RequestMapping("/program")
public class ProgramController {

    @Autowired
    private ProgramService programService;

    @Autowired
    private DonationService donationService;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public Wrapper create(@RequestParam("id") int id, @RequestParam("name") String name){
        ProgramEntity program = new ProgramEntity();
        program.setId(id);
        program.setName(name);
        ProgramEntity hasil = programService.save(program);

        if(hasil == null){
            return new Wrapper(501, "Gagal menyimpan program baru", null);
        }
        return new Wrapper(200, "Program berhasil disimpan", program);
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public Wrapper update(@RequestParam("id") int id, @RequestParam("name") String name){
        ProgramEntity program = programService.findById(id);
        program.setName(name);
        ProgramEntity hasil = programService.save(program);

        if(hasil == null){
            return new Wrapper(501, "Gagal menyimpan program baru", null);
        }
        return new Wrapper(200, "Program berhasil diperbaharui", program);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public Wrapper delete(@RequestParam("id") int id){
        List<ProgramEntity> hasil = programService.delete(id);
        if(hasil == null){
            return new Wrapper(501, "Gagal menghapus program", null);
        }
        return new Wrapper(200, "Berhasil menghapus program", hasil);
    }

    @RequestMapping(path = "/total-donation", method = RequestMethod.POST)
    public Wrapper totalDonation(@RequestParam("id") int id){
        int total = donationService.getTotalDonationOfProgram(id);
        return new Wrapper(200, "Berhasil", total);
    }
}
