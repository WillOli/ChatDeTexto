package Controller;

import Entity.Chat;
import Entity.Mensagem;
import Entity.Usuario;
import Repository.ChatRepository;
import Repository.MensagemRepository;
import Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value = "/chats")
public class ChatController {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private MensagemRepository mensagemRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    @PostMapping("/{idUser1}/{idUser2}")
    public ResponseEntity<?> criarChat(@PathVariable Long idUser1, @PathVariable Long idUser2){
        Optional<Usuario> usuarioOptional1 = usuarioRepository.findById(idUser1);
        Optional<Usuario> usuarioOptional2 = usuarioRepository.findById(idUser2);
        if (usuarioOptional1.isPresent() && usuarioOptional2.isPresent()) {
            Usuario user1 = usuarioOptional1.get();
            Usuario user2 = usuarioOptional2.get();
            List<Usuario> listUser = new ArrayList<>();
            listUser.add(user1);
            listUser.add(user2);
            Chat chat = new Chat();
            chat.setUsuarios(listUser);

            return ResponseEntity.status(HttpStatus.CREATED).body(chatRepository.save(chat));
        } else {
            String errorMessage = "Um ou ambos os IDs de usuário não foram encontrados: " +
                    "ID1: " + idUser1 + ", ID2: " + idUser2;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }



    @PostMapping("/chat/{idChat}/user/{idUser}")
    public ResponseEntity<?> enviarMensagem(@PathVariable Long idChat, @PathVariable Long idUser, @RequestBody Mensagem mensagem){
        Optional<Chat> chatOptional = chatRepository.findById(idChat);
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUser);
        if(chatOptional.isPresent() && usuarioOptional.isPresent()){
            mensagem.setChat(chatOptional.get());
            mensagem.setUsuario(usuarioOptional.get());
            mensagemRepository.save(mensagem);
            return ResponseEntity.status(HttpStatus.CREATED).body(chatOptional.get());
        } else {
            String errorMessage = "Chat ou usuário não encontrado para os IDs fornecidos: " +
                    "ID do Chat: " + idChat + ", ID do Usuário: " + idUser;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }


    @GetMapping("/chat/{id}")
    public ResponseEntity<?> verChat(@PathVariable Long id){
        Optional<Chat> optionalChat = chatRepository.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(optionalChat.get());
    }

}

