package br.ucsal.geu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.geu.model.Bloco;
import br.ucsal.geu.model.Espaco;
import br.ucsal.geu.model.Reserva;
import br.ucsal.geu.model.Tipo;
import br.ucsal.util.Conexao;

public class ReservaDAO {

	private Conexao conexao;

	public ReservaDAO() {
		this.conexao = Conexao.getConexao();
	}

	public List<Reserva> listar() {
		Statement stmt;
		List<Reserva> reservas = new ArrayList<>();
		try {
			stmt = conexao.getConnection().createStatement();

			ResultSet rs = stmt.executeQuery(
					"select reservas.id,titulo,descricao,justificativa,solicitante,telefone,data,horainicio,horafim,espaco_id,identificacao,andar,bloco_id,nome,letra,latitude,longitude,tipo_id,tipos.nome as nometipo, tipos.descricao from reservas,espacos,blocos,tipos where reservas.espaco_id = espacos.id and espacos.bloco_id = blocos.id and espacos.tipo_id = tipos.id");
			while (rs.next()) {
				Reserva r = new Reserva();
				r.setId(rs.getInt("id"));
				r.setTitulo(rs.getString("titulo"));
				r.setDescricao(rs.getString("descricao"));
				r.setJustificativa(rs.getString("justificativa"));
				r.setSolicitante(rs.getString("solicitante"));
				r.setTelefone(rs.getString("telefone"));
				r.setData(rs.getDate("data").toLocalDate());
				r.setHoraInicio(rs.getTime("horaInicio").toLocalTime());
				r.setHoraFim(rs.getTime("horafim").toLocalTime());

				Espaco espaco = new Espaco();
				espaco.setId(rs.getInt("espaco_id"));
				espaco.setIdentificacao(rs.getString("identificacao"));
				espaco.setAndar(rs.getString("andar"));

				Bloco bloco = new Bloco();
				bloco.setId(rs.getInt("bloco_id"));
				bloco.setNome(rs.getString("nome"));
				bloco.setLetra(rs.getString("letra"));
				bloco.setLatitude(rs.getString("latitude"));
				bloco.setLongitude(rs.getString("longitude"));

				Tipo tipo = new Tipo();
				tipo.setId(rs.getInt("tipo_id"));
				tipo.setNome(rs.getString("nometipo"));
				tipo.setDescricao(rs.getString("descricao"));

				r.setEspaco(espaco);

				reservas.add(r);
			}

			stmt.close();

		} catch (

		SQLException e) {
			e.printStackTrace();
		}

		return reservas;
	}

	public void inserir(Reserva reserva) {
		try {

			PreparedStatement ps = conexao.getConnection().prepareStatement(
					"insert into reservas (titulo, descricao, justificativa, solicitante, telefone, data, horaInicio, horaFim, espaco_id) values (?,?,?,?,?,?,?,?,?);");
			ps.setString(1, reserva.getTitulo());
			ps.setString(2, reserva.getDescricao());
			ps.setString(3, reserva.getJustificativa());
			ps.setString(4, reserva.getSolicitante());
			ps.setString(5, reserva.getTelefone());
			ps.setDate(6, java.sql.Date.valueOf(reserva.getData()));
			ps.setTime(7, java.sql.Time.valueOf(reserva.getHoraInicio()));
			ps.setTime(8, java.sql.Time.valueOf(reserva.getHoraFim()));
			ps.setInt(9, reserva.getEspaco().getId());

			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
