package guru.springframework.commands;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import guru.springframework.domain.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;
    
    @NotBlank
    @Size(min = 3, max = 255)
    private String description;
    
    @NotNull
    @Min(1)
    @Max(999)
    private Integer prepTime;
    
    @NotNull
    @Min(1)
    @Max(999)
    private Integer cookTime;
    
    @NotNull
    @Min(1)
    @Max(9999)
    private Integer servings;
    private String source;
    
    @URL
    private String url;
    
    @NotBlank
    private String directions;
    
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private Byte[] image;
    private Difficulty difficulty;
    private NotesCommand notes;
    private Set<CategoryCommand> categories = new HashSet<>();
}
