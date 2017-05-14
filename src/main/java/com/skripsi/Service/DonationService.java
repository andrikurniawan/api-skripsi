package com.skripsi.Service;

import com.skripsi.Domain.DonationEntity;
import com.skripsi.Repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Andri Kurniawan <andrikurniawan.id@gmail.com>
 * on 5/13/2017.
 */

@Service
public class DonationService {
    @Autowired
    private DonationRepository donationRepository;

    public DonationEntity findById(int id){
        return donationRepository.findById(id);
    }

    public int getTotalDonationOfProgram(int p_id){
        return donationRepository.getTotalDonationOfProgram(p_id);
    }

    public List<DonationEntity> findByIdProgram(int p_id){
        return donationRepository.findBypId(p_id);
    }

    public DonationEntity save(DonationEntity donation){
        return donationRepository.save(donation);
    }

    public int delete(int id){
        return donationRepository.deleteById(id);
    }
}
