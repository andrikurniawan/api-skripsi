package com.skripsi.Repository;

import com.skripsi.Domain.ProgramEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Andri Kurniawan <andrikurniawan.id@gmail.com>
 * on 5/13/2017.
 */
@Repository
public interface ProgramRepository extends CrudRepository<ProgramEntity, Integer> {
    ProgramEntity findById(int id);
    @Transactional
    Integer deleteById(int id);
}
