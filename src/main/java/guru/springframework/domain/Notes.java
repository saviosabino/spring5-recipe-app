package guru.springframework.domain;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Notes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Recipe recipe;
	
	@Lob
	private String recipeNotes;

}
