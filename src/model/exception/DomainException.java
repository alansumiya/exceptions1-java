package model.exception;
//usando exception vc é obrigado a tratar o erro
public class DomainException extends Exception {

	//o exception precisa ter uma versão, no caso uma padrão de versão é esse 1L
	private static final long serialVersionUID = 1L;

	//permite que eu possa instanciar a classe passando uma mensagem para ela
	//essa mensagem vai ficar armazenada dentro na seção
	public DomainException(String msg) {
		super(msg);
	}
}
