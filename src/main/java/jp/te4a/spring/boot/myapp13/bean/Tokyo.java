package jp.te4a.spring.boot.myapp13.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "tokyo_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tokyo {
	@Id
	private String machine_id ;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String model_number;
	@Column(nullable = false)
	private String maker;
	@Column(nullable = false)
	private String spec;
	//purchase_date
	private Date purchase_date;
	private Integer useful_life;
	private String depreciation;
	private Boolean availability;
	private Boolean loanability;
	@Column(nullable = false)
	private String location;
	//expiration_date
	private Date expiration_date;
	private Integer price;
}
