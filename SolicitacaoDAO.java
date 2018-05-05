package com.calendariojpb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.calendariojpb.domain.Solicitacao;
import com.calendariojpb.factory.Conexao;

public class SolicitacaoDAO {

	public void salvar(Solicitacao sol) throws SQLException {
		String sql = "insert into solicitacao(nome,endereco,email,telefone,descricao) value(?,?,?,?,?)";
		
			Connection conexao = Conexao.conectar();
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, sol.getNome());
			pst.setString(2, sol.getEndereco());
			pst.setString(3, sol.getEmail());
			pst.setString(4, sol.getTelefone());
			pst.setString(5, sol.getDescricao());
			
			pst.executeUpdate();
	}
	
	public static void main(String[] args) {
		Solicitacao sol = new Solicitacao();
		sol.setNome("Jose");
		sol.setEndereco("Rua Edmundo Filho nº 841 - B.São Jose");
		sol.setEmail("jose@.com");
		sol.setTelefone("9999-9999");
		sol.setDescricao("Esgoto entupido na avenida principal");
		
		SolicitacaoDAO solD = new SolicitacaoDAO();
		try {
			solD.salvar(sol);
			System.out.println("Salvo com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao salvar!");
			e.printStackTrace();
		}
	}
}
