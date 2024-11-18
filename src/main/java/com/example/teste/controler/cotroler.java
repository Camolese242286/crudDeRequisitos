package com.example.teste.controler;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.jdev.model.Requisitos;
import com.example.jdev.repository.RequsitosRepository;

@RestController
public class cotroler {
	
	
	@Autowired
	private RequsitosRepository requisitosRepositoy;
	
	
	@RequestMapping(value="mostrarnome/{nome}",method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String greetingText(@PathVariable String nome) {
		
		
		Requisitos usuario = new Requisitos();
		usuario.setNome(nome);
		
		requisitosRepositoy.save(usuario);
		
		return "nome " + nome ;
	}


	@GetMapping(value= "listtatodos")
	@ResponseBody
	public ResponseEntity< java.util.List<Requisitos> > listaUsuario(){
		
	java.util.List<Requisitos> usuarios=	requisitosRepositoy.findAll();
	
	return new ResponseEntity<java.util.List<Requisitos>>(usuarios, HttpStatus.OK);
	}


	@PostMapping(value= "salvar")
	@ResponseBody
	public ResponseEntity<Requisitos> salvar (@RequestBody Requisitos usuario){
		
	Requisitos user=requisitosRepositoy.save(usuario);
	
	return  new ResponseEntity<Requisitos>(user, HttpStatus.OK);
	}
	
	@DeleteMapping(value= "delete")
	@ResponseBody
	public ResponseEntity<String> deletar (@RequestParam long iduser){
		
		requisitosRepositoy.deleteById(iduser);
	
	return  new ResponseEntity<String>("user deletado com suceso ", HttpStatus.OK);
	}
	
	
	
	@GetMapping(value= "atualizar")
	@ResponseBody
	public ResponseEntity<Requisitos> atualizar (@RequestParam Requisitos usuario){
		
    Requisitos user = requisitosRepositoy.save(usuario);
	
	return  new ResponseEntity<Requisitos>(user, HttpStatus.OK);
	}	

	
	@PutMapping(value= "buscaruserid")
	@ResponseBody
	public ResponseEntity<Requisitos> buscaruserid (@RequestParam(name="iduser") long iduser){
		
    Requisitos usuario =  requisitosRepositoy.findById(iduser).get();
	
	return  new ResponseEntity<Requisitos>(usuario, HttpStatus.OK);
	}
	
	
	@PutMapping(value= "buscarPorNome")
	@ResponseBody
	public ResponseEntity<java.util.List<Requisitos>> buscarPorNome (@RequestParam(name="nome") String nome){
		
    java.util.List<Requisitos> usuario =  requisitosRepositoy.buscarPorNome(nome);
	
	return  new ResponseEntity<java.util.List<Requisitos>>(usuario, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	public RequsitosRepository getUsuarioRepositoy() {
		return requisitosRepositoy;
	}


	public void setUsuarioRepositoy(RequsitosRepository usuarioRepositoy) {
		this.requisitosRepositoy = usuarioRepositoy;
	}

}
