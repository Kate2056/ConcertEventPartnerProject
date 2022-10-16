/**
 * @author Kaitlyn Briggs - krbriggs
 * CIS175 - Fall 2022
 * Oct 16, 2022
 */
package controller;


import java.sql.Time;
import java.time.LocalTime;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime, Time>{
	@Override 
	public Time convertToDatabaseColumn(LocalTime attribute) {
		//TODO Auto-generated method stub
		return (attribute == null ? null : Time.valueOf(attribute));
	}

	@Override
	public
	LocalTime convertToEntityAttribute(Time time) {
		//TODO Auto-generated method stub
		return(time == null ? null : time.toLocalTime());
	}
}
