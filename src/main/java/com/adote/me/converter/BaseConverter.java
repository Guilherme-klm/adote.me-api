package com.adote.me.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseConverter {

     abstract Object dtoToEntity();

     abstract Object entityToDto();

     public String getCurrentDateTime () {
          var dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
          var date = new Date();
          return dateFormat.format(date);
     }
}
