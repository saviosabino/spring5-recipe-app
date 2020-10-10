package guru.springframework.domain;

import java.math.BigDecimal;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(exclude = {"uom","recipe"})
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private BigDecimal amount;
	
	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMeasure uom;
	
	@ManyToOne
	private Recipe recipe;

	public Ingredient() {}
	
//	public Ingredient(String description, BigDecimal amount, 
//			 UnitOfMeasure eachUom, Recipe recipe) { 
//		this.description = description; this.amount = amount;
//		this.uom = eachUom; this.recipe = recipe; 
//	}
	
	public Ingredient(String description, BigDecimal amount, UnitOfMeasure eachUom) { 
		this.description=description; this.amount=amount; this.uom=eachUom; 
	}
	 

}
