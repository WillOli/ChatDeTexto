package Repository;

import Entity.Mensagem;
import Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
}
