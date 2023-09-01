package Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "usuarios")
    @JsonIgnore
    private List<Chat> chats;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Mensagem> mensagens;  // Change typo "mensagems" -> "mensagens"
}

