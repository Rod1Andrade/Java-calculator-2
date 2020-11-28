package domain.usecases;

/**
 * 
 * @author Rodrigo M.P Andrade
 *
 * @param <T> Tipo qualquer de retorno para o método make.
 */
public interface Usecase<T> {
	
	/**
	 * Executa caso de uso.
	 * 
	 * @return
	 */
	T make();
}
