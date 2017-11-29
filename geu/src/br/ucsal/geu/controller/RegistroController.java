package br.ucsal.geu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.geu.dao.BlocoDAO;
import br.ucsal.geu.dao.EspacoDAO;
import br.ucsal.geu.dao.TipoDAO;
import br.ucsal.geu.dao.UsuarioDAO;
import br.ucsal.geu.model.Bloco;
import br.ucsal.geu.model.Espaco;
import br.ucsal.geu.model.Tipo;
import br.ucsal.geu.model.Usuario;

/**
 * Servlet implementation class RegistroController
 */
@WebServlet("/registro")
public class RegistroController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    UsuarioDAO userDAO = new UsuarioDAO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroController() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	String nome = request.getParameter("nome");
	String login = request.getParameter("login");
	String senha = request.getParameter("senha");

	Usuario usuario = new Usuario();

	usuario.setNome(nome);
	usuario.setLogin(login);
	usuario.setSenha(senha);

	UsuarioDAO userDAO = new UsuarioDAO();

	userDAO.cadastrar(usuario);

	request.setAttribute("listaUsuarios", userDAO.listar());
	request.getRequestDispatcher("usuariolist.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.getWriter().append("Served at: ").append(request.getContextPath());
    }

}
