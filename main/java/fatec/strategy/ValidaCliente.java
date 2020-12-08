package fatec.strategy;

import fatec.model.Cliente;
import fatec.model.EntidadeDominio;
import fatec.repository.ClienteRepository;
import fatec.repository.EnderecoRepository;

public class ValidaCliente implements IStrategy {

	private ClienteRepository clienteRepository;
	private EnderecoRepository enderecoRepository;
	
	public ValidaCliente(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository)
	{
		this.clienteRepository = clienteRepository;
		this.enderecoRepository= enderecoRepository;
	}
	
	@Override
	public String processar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente) entidade;
		StringBuilder sb = new StringBuilder();
		
		if(cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
			sb.append("Campo nome não pode ser vazio");
		}			
		Cliente existe = clienteRepository.findByCpf(cliente.getCpf());
		if(existe != null)
		{
			sb.append("Cliente com cpf ja cadastrado");
			System.err.println(cliente.getCpf());
		}
		if(cliente.getCpf() == null || cliente.getCpf().trim().isEmpty()) {
			sb.append("Campo CPF não pode ser vazio");
		}	
		
		if(cliente.getEndereco().getLogradouro() == null || cliente.getEndereco().getLogradouro().trim().isEmpty()) {
			sb.append("Campo Logradouro não pode ser vazio");
		}
		
		if(cliente.getEndereco().getCep() == null || cliente.getEndereco().getCep().trim().isEmpty()) {
			sb.append("Campo Cep não pode ser vazio");
		}
		
		if(cliente.getEndereco().getComplemento() == null || cliente.getEndereco().getComplemento().trim().isEmpty()) {
			sb.append("Campo Complemento não pode ser vazio");
		}
		
		if(cliente.getEndereco().getNumero() == null || cliente.getEndereco().getNumero().trim().isEmpty()) {
			sb.append("Campo Numero não pode ser vazio");
		}
	
		return sb.toString();
	}

}

