package com.luckyryan.sample.transformer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class Transformer {

//  private DozerBeanMapper mapper = new DozerBeanMapper();
//	UserCommandDTO dto = mapper.map(info, UserCommandDTO.class);
    
    public Long stringToLong(String id) {
    	return Long.valueOf(id);
    }
    
    public String stringToStr(String str) {
    	return str;
    }
    
    


}
