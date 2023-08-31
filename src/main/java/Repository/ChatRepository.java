package Repository;

import Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Usuario, Long> {
}
