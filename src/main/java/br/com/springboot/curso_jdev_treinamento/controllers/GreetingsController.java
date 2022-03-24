package br.com.springboot.curso_jdev_treinamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.curso_jdev_treinamento.model.Usuario;
import br.com.springboot.curso_jdev_treinamento.repository.UsuarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
    /**
     *
     * @param name the name to greet
     * @return greeting text
//     */
//    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public String greetingText(@PathVariable String name) {
//        return "Hello " + name + "!";
//    }
    
    @GetMapping(value = "/usuarios")
    @ResponseBody
    public ResponseEntity<List<Usuario>> listarUsuarios(){
    	
    	List<Usuario> ususarios = usuarioRepository.findAll();
    	
    	return new ResponseEntity<List<Usuario>>(ususarios, HttpStatus.OK);
    	
    }
    
    @PostMapping(value = "/usuario")
    @ResponseBody
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario){
    	
    	Usuario user = usuarioRepository.save(usuario);
    	
    	return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
    	
    }
    
    @PutMapping(value = "/usuario")
    @ResponseBody
    public ResponseEntity<?> atualizaUsuario(@RequestBody Usuario usuario){
    	
//    	if(usuario.getId() == null) {
//    		
//    		return new ResponseEntity<String>("Usuario não encontrado ou id informado errado, para atualização.", HttpStatus.OK);
//    		
//    	}
    	
    	Usuario user = usuarioRepository.saveAndFlush(usuario);
    	
    	return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
    	
    }
    
    @DeleteMapping(value = "/usuario")
    @ResponseBody
    public ResponseEntity<String> deleteUsuario(@RequestParam (name = "idUsuario") Long idUsuario){
    	
    	usuarioRepository.deleteById(idUsuario);
    	
    	return new ResponseEntity<String>("Usuario deletado com sucesso", HttpStatus.OK);
    	
    }
    
    @GetMapping(value = "/usuario-por-id")
    @ResponseBody
    public ResponseEntity<Usuario> buscarUsuarioId(@RequestParam(name = "idUsuario") Long idUsuario){
    	
    	Usuario user = usuarioRepository.findById(idUsuario).get();
    	
    	return new ResponseEntity<Usuario>(user, HttpStatus.OK);
    	
    }
    
    @GetMapping(value = "/usuario-por-nome")
    @ResponseBody
    public ResponseEntity<List<Usuario>> buscarUsuarioNome(@RequestParam(name = "nome") String nome){
    	
    	List<Usuario> usuarios = usuarioRepository.buscarPorNome(nome.toUpperCase());
    	
    	return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    	
    }
    
    
    
}
