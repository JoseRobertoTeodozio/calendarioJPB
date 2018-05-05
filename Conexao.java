package com.calendariojpb.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static final String USUARIO = "root";
	private static final String SENHA = "jose";
	private static final String URL = "jdbc:mysql://localhost:3306/calendariojpb";

	public static Connection conectar() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}
	
	public static void main(String[] args) {
		try {
			Connection conexao = Conexao.conectar();
			System.out.println("Conectado com sucesso!");
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Não foi possivel realizar a conexão.");
			e.printStackTrace();
		}
	
	}
}
