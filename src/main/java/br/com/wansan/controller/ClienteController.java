package br.com.wansan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.wansan.model.Cliente;
import br.com.wansan.repsitory.filter.ClienteFilter;
import br.com.wansan.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	private static String CADASTRO_VIEW = "CadastroCliente";
	
	@RequestMapping
	public ModelAndView pesquisar(@ModelAttribute("filtro") ClienteFilter filtro){
		List<Cliente> clientes = clienteService.searchFor(filtro);
		ModelAndView mv = new ModelAndView("Clientes");	
		mv.addObject("clientes",clientes);
		return mv;	
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Cliente());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Cliente cliente, Errors errors,RedirectAttributes attributes){
		if(errors.hasErrors()){
			return CADASTRO_VIEW;
		}
		
		try{
			clienteService.create(cliente);
			attributes.addFlashAttribute("mensagem", "Cliente salvo com sucesso");
			return "redirect:/clientes/novo";
		}catch(RuntimeException e){
			return CADASTRO_VIEW;
		}
	}
	
	@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes){
		clienteService.delete(codigo);
		attributes.addFlashAttribute("Mensagem", "Cliente excluido com sucesso");
		return "redirect:/clientes";
	}
	
	@RequestMapping(value = "{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Cliente cliente){
		ModelAndView mv = new ModelAndView("CadastroCliente");
		mv.addObject(cliente);
		return mv;
	}
		
	
}
