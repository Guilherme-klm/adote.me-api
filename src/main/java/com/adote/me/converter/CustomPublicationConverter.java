package com.adote.me.converter;

import com.adote.me.dtl.publication.PublicationOutputDTO;

import java.util.List;

public interface CustomPublicationConverter extends BaseConverter {

    List<PublicationOutputDTO> entityListToDtoList();
}
