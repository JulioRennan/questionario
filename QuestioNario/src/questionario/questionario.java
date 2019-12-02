/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questionario;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julio Rennan
 */
public class questionario {
    private final String cNome;
    private final int cleaning;
    private final int confort;
    private final int quality;
    private final int service;
    private final String email;
    private final String pergunta1;
    private final String pergunta2;
    private final String pergunta3;
    private final String pergunta4;

    public questionario(String cNome, int cleaning, int confort, int quality, int service, String email, String pergunta1, String pergunta2, String pergunta3, String pergunta4) {
        this.cNome = cNome;
        this.cleaning = cleaning;
        this.confort = confort;
        this.quality = quality;
        this.service = service;
        this.email = email;
        this.pergunta1 = pergunta1;
        this.pergunta2 = pergunta2;
        this.pergunta3 = pergunta3;
        this.pergunta4 = pergunta4;
       
    }

    void inserirBanco() {
      Connection conexao;
        try {
            conexao = FabricaConexao.getConexao();

            String sql = "INSERT INTO pirarucu  VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1,cNome);
            stmt.setInt(2, cleaning);
            stmt.setInt(3, confort);
            stmt.setInt(4, quality);
            stmt.setInt(5, service);
            stmt.setString(6, email);
            stmt.setString(7, pergunta1);
            stmt.setString(8, pergunta2);
            stmt.setString(9, pergunta3);
            stmt.setString(10, pergunta4);
            stmt.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(questionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(questionario.class.getName()).log(Level.SEVERE, null, ex);
        }
	
      
      
    }

   
    
}
