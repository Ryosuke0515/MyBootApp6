package jp.te4a.spring.boot.myapp11;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
public class BookValidate implements ConstraintValidator<BookValid,String>{
	String param;
	@Override
	public void initialize(BookValid bv){ param =  bv.param(); }
	@Override
	public boolean isValid(String in,ConstraintValidatorContext cxt){
		if(in == null){
			return false;
		}
		System.out.println(in.equals(param));
		return !in.equals(param);
	}
}
//@Data
//@NoArgsConstructor
//public class BookForm {
//private Integer id ;
//@NotNull
//@Size(min = 3)
//@BookValid(param = "abc")
//private String title;
//@Size(min = 3, max = 20)
//private String writter;
//private String publisher;
//@Min(0)
//private Integer price;
//}

