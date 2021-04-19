package com.adote.me.repository;

import com.adote.me.dtl.publication.PublicationOutputDTO;
import com.adote.me.model.Publication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PublicationRepository extends MongoRepository<Publication, String> {

    @Override
    <S extends Publication> S save(S entity);

    @Override
    Optional<Publication> findById(String s);

    @Override
    void deleteById(String s);

    @Query("{ ':#{#localization}': :#{#value} }")
    List<PublicationOutputDTO> findByPublicationByLocalization(@Param("localization") String localization, @Param("value") String value);

}
