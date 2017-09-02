package testes;

import br.com.dao.AdmBanco;
import controles.JogosDao;

public class testesBase {

	public static void main(String[] args) {
		AdmBanco banco = new AdmBanco();
		banco.conectar();

	}

}
