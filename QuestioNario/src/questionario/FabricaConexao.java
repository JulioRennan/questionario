/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questionario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class FabricaConexao {
	public static Connection getConexao() throws SQLException, IOException {
		//nao vai verificar certificado mas vai fazer conexao segura
		try {
		Properties prop = getProperties();
		final String url =prop.getProperty("banco.url");
		final String usuario = prop.getProperty("banco.usuario");
		final String senha = prop.getProperty("banco.senha");
		Connection conexao;
	
			conexao = DriverManager.getConnection(url,usuario,senha);
			return conexao;
		} catch (Error e) {
			throw new RuntimeErrorException(e);
		}
		
	}
	private static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		String caminho = "/conexao.properties";
		prop.load(FabricaConexao.class.getResourceAsStream(caminho));
		return prop;
	}
}
