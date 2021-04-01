package com.adote.me.repository;

import com.adote.me.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Override
    <S extends Address> S save(S entity);

    @Override
    Optional<Address> findById(Long aLong);

    @Override
    void deleteById(Long aLong);

}
