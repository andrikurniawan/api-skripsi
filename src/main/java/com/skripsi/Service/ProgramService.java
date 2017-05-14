package com.skripsi.Service;

import com.skripsi.Domain.ProgramEntity;
import com.skripsi.Repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Andri Kurniawan <andrikurniawan.id@gmail.com>
 * on 5/13/2017.
 */

@Service
public class ProgramService {
    @Autowired
    private ProgramRepository programRepository;

    public ProgramEntity findById(int id){
        return programRepository.findById(id);
    }

    public ProgramEntity save(ProgramEntity program){
        return programRepository.save(program);
    }

    public int delete(int id){
        return programRepository.deleteById(id);
    }
}
