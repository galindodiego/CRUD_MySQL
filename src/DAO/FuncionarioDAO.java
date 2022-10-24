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
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class FuncionarioDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<FuncionarioDTO> listaFuncionario = new ArrayList<>();

    /**
     *
     * @param objFuncionarioDto
     * @throws ClassNotFoundException cadastra funcionario no banco de dados
     */
    public void cadastrarFuncionario(FuncionarioDTO objFuncionarioDto) throws ClassNotFoundException {
        conn = new ConexaoDAO().conectaBD();
        String sql = "insert into funcionario (nome_funcionario, endereco_funcionario) values (?,?)";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objFuncionarioDto.getNome_funcionario());
            pstm.setString(2, objFuncionarioDto.getEndereco_funcionario());

            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado !");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO " + erro);
        }

    }

    public ArrayList<FuncionarioDTO> pesquisarFuncionario() throws ClassNotFoundException {
        String sql = "select * from funcionario";
        conn = new ConexaoDAO().conectaBD();
        try {

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                FuncionarioDTO objFuncionarioDto = new FuncionarioDTO();
                objFuncionarioDto.setId_funcionario(rs.getInt("id_funcionario"));
                objFuncionarioDto.setNome_funcionario(rs.getString("nome_funcionario"));
                objFuncionarioDto.setEndereco_funcionario(rs.getString("endereco_funcionario"));
                listaFuncionario.add(objFuncionarioDto);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO" + erro);
        }
        return listaFuncionario;
    }

    public void alterarFuncionario(FuncionarioDTO objFuncionarioDto) throws ClassNotFoundException   {
        conn = new ConexaoDAO().conectaBD();
        String sql = "update funcionario set nome_funcionario = ?, endereco_funcionario =? where id_funcionario = ?";
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objFuncionarioDto.getNome_funcionario());
            pstm.setString(2, objFuncionarioDto.getEndereco_funcionario());
            pstm.setInt(3, objFuncionarioDto.getId_funcionario());
            
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Funcionário atualizado !");
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,"FuncionarioDAO Alterar "+erro);
        }
    }
    
    public void deletarFuncionario(FuncionarioDTO objFuncionarioDto) throws ClassNotFoundException{
        conn = new ConexaoDAO().conectaBD();
        String sql = "delete from funcionario where id_funcionario = ?";
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objFuncionarioDto.getId_funcionario());
            pstm.execute();
            pstm.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,"FuncionarioDAO Deletar "+erro);
        }
    }
}
