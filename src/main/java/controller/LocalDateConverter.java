/**
 * @author Kaitlyn Briggs - krbriggs
 * CIS175 - Fall 2022
 * Oct 16, 2022
 */
package controller;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {
@Override 
public Date convertToDatabaseColumn(LocalDate attribute) {
	//TODO Auto-generated method stub
	return (attribute == null ? null : Date.valueOf(attribute));
}

@Override
public
LocalDate convertToEntityAttribute(Date date) {
	//TODO Auto-generated method stub
	return(date == null ? null : date.toLocalDate());
}


}
