package com.skripsi.Repository;

import com.skripsi.Domain.DonationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Andri Kurniawan <andrikurniawan.id@gmail.com>
 * on 5/13/2017.
 */
@Repository
public interface DonationRepository extends CrudRepository<DonationEntity, Integer> {
    DonationEntity findById(int id);
    List<DonationEntity> findBypId(int p_id);

    @Transactional
    Integer deleteById(int id);

    @Query(value = "Select sum(amount) from donation where p_id = :p_id",
            nativeQuery = true)
    Integer getTotalDonationOfProgram(@Param("p_id") int p_id);
}
