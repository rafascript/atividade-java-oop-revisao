package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Livro;

public class LivroDAO {
	private Connection conexao;
	private PreparedStatement statement;
	
	public void salvar(Livro livros) {
		try{
			ConexaoBD conexaoDB = new ConexaoBD();
			conexao = conexaoDB.getCon();
			conexao.setAutoCommit(false);

			//Preparando a consulta SQL
			String sql = "INSERT INTO livros values(0,?,?,?,?,?)";
			statement = conexao.prepareStatement(sql);
			//Mapeamento Relacional
			statement.setInt(1, livros.getAno());
			statement.setInt(2, livros.getEdicao());
			statement.setString(3, livros.getTitulo());
			statement.setString(4, livros.getLocal());
			statement.setString(5, livros.getEditora());
			//Execu��o do SQL
			statement.executeUpdate();

		}
		catch(Exception ex){
			try {
				conexao.rollback();
			} catch (SQLException e) {
				ex.printStackTrace();
			}
			ex.printStackTrace();
		}
		finally{
			try{
				conexao.setAutoCommit(true);
				statement.close();
				conexao.close();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}


public void alterar(Livro livros) {
	try{
		ConexaoBD conexaoDB = new ConexaoBD();
		conexao = conexaoDB.getCon();
		conexao.setAutoCommit(false);

		//Preparando a consulta SQL
		String sql = "UPDATE livros SET ano = ?, edicao = ?, titulo = ?, local = ?, editora = ? WHERE id = ?";
		statement = conexao.prepareStatement(sql);
		//Mapeamento Relacional
		statement.setInt(1, livros.getAno());
		statement.setInt(2, livros.getEdicao());
		statement.setString(3, livros.getTitulo());
		statement.setString(4, livros.getLocal());
		statement.setString(5, livros.getEditora());
		statement.setInt(6, livros.getId());
		//Execu��o do SQL
		statement.executeUpdate();

	}
	catch(Exception ex){
		try {
			conexao.rollback();
		} catch (SQLException e) {
			ex.printStackTrace();
		}
		ex.printStackTrace();
	}
	finally{
		try{
			conexao.setAutoCommit(true);
			statement.close();
			conexao.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

public void deletar(int id) {
	try{
		ConexaoBD conexaoDB = new ConexaoBD();
		conexao = conexaoDB.getCon();
		conexao.setAutoCommit(false);

		//Preparando a consulta SQL
		String sql = "DELETE FROM livros WHERE id = ?";
		statement = conexao.prepareStatement(sql);
		//Mapeamento Relacional
		statement.setInt(1, id);
		//Execu��o do SQL
		statement.executeUpdate();

	}
	catch(Exception ex){
		try {
			conexao.rollback();
		} catch (SQLException e) {
			ex.printStackTrace();
		}
		ex.printStackTrace();
	}
	finally{
		try{
			conexao.setAutoCommit(true);
			statement.close();
			conexao.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

public List<Livro> listar(){
	try{
		//Inst�ncia de conex�o com o BD
		ConexaoBD conexaoDB = new ConexaoBD();
		conexao = conexaoDB.getCon();
		conexao.setAutoCommit(false);

		//Prepara��o da Consulta SQL
		String sql = "SELECT id, ano, edicao, titulo, local, editora from livros";
		statement = conexao.prepareStatement(sql);
		//Execu��o da Consulta SQL
		ResultSet result = statement.executeQuery();

		List<Livro> listaLivros = new ArrayList<Livro>();
		while(result.next()){
			Livro livros = new Livro();
			livros.setId(result.getInt(1));
			livros.setAno(result.getInt(2));
			livros.setEdicao(result.getInt(3));
			livros.setTitulo(result.getString(4));
			livros.setLocal(result.getString(5));
			livros.setEditora(result.getString(6));
			listaLivros.add(livros);
		}
		return listaLivros;
	}
	catch(Exception ex){
		try {
			conexao.rollback();
		} catch (SQLException e) {
			ex.printStackTrace();
		}
		ex.printStackTrace();
		return null;
	}
	finally{
		try{
			conexao.setAutoCommit(true);
			statement.close();
			conexao.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

}