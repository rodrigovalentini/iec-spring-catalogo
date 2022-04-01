package pro.gsilva.catalogo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
@Data
@Getter
@Setter
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private final int nameMinLength = 1;
    private final int nameMaxLength = 30;

    @Size(min = nameMinLength, message = "O Nome não pode ser vazio")
    @Size(max = nameMaxLength, message = "O Nome não pode ter mais de "+nameMaxLength+" caracteres")
    @Column(name = "nome", length = nameMaxLength, nullable = false )
    private String nome;

    @OneToMany(mappedBy="categoria")
    private Set<Musica> musicas;
}
