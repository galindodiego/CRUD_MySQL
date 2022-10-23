/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.UsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import DTO.FuncionarioDTO;
import VIEW.frmFuncionarioView;
import VIEW.frmLoginVIEW;

import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class FuncionarioDAO {
    
    Connection conn;
    PreparedStatement pstm;
    
    public void cadastrarFuncionario(FuncionarioDTO objFuncionarioDto) throws ClassNotFoundException{
        conn = new ConexaoDAO().conectaBD();
        String sql = "insert into funcionario (nome_funcionario, endereco_funcionario) values (?,?)";
        
        
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objFuncionarioDto.getNome_funcionario());
            pstm.setString(2, objFuncionarioDto.getEndereco_funcionario());
            
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Funcionário salvo !");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO "+erro);
        }
        
    }
}
