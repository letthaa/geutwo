package br.ucsal.geu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.geu.model.Tipo;
import br.ucsal.geu.model.Usuario;
import br.ucsal.util.Conexao;

public class UsuarioDAO {
    private Conexao conexao;

    public UsuarioDAO() {
	this.conexao = Conexao.getConexao();
    }

    public List<Usuario> listar() {
	Statement stmt;
	List<Usuario> usuarios = new ArrayList<>();
	try {
	    stmt = conexao.getConnection().createStatement();
	    ResultSet rs = stmt.executeQuery("select id,nome,login,senha from usuarios;");
	    while (rs.next()) {
		Usuario u = new Usuario();
		u.setId_usuario(rs.getInt("id"));
		u.setNome(rs.getString("nome"));
		u.setLogin(rs.getString("login"));
		u.setSenha(rs.getString("senha"));
		usuarios.add(u);
	    }
	    stmt.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return usuarios;
    }

    public boolean verificarUsuario(String login, String pass) {
  	try {
  	    ResultSet valores = connection.createStatement()
  		    .executeQuery("select login,pass from users where login='" + login + "' and pass='" + pass + "'");
  	    return valores.next();
  	} catch (SQLException e) {
  	    e.printStackTrace();
  	}
  	return false;
      }
    
    public boolean Autenticar(Usuario user) {
	boolean autenticador = false;

	try {
	    PreparedStatement ps = conexao.getConnection()
		    .prepareStatement("select * from usuarios where login=(?) and senha=(?)");
	    ps.setString(1, user.getLogin());
	    ps.setString(2, user.getSenha());
	    ResultSet rs = ps.executeQuery();

	    if (rs.next()) {
		autenticador = true;
	    }
	    rs.close();
	    ps.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return autenticador;
    }

    public void cadastrar(Usuario user) {
	try {
	    PreparedStatement stmt = conexao.getConnection()
		    .prepareStatement("insert into usuarios (nome,login,senha) values (?,?,?)");

	    stmt.setString(1, user.getNome());
	    stmt.setString(2, user.getLogin());
	    stmt.setString(3, user.getSenha());

	    stmt.execute();
	    stmt.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
}
