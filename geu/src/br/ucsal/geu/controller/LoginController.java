package br.ucsal.geu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.geu.dao.UsuarioDAO;
import br.ucsal.geu.model.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UsuarioDAO u = new UsuarioDAO();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	Usuario user = new Usuario();

	String login = request.getParameter("login");
	String senha = request.getParameter("senha");

	user.setLogin(login);
	user.setSenha(senha);

	HttpSession session = request.getSession();
	session.setAttribute("player", user);
	response.sendRedirect("index.jsp");
	// if (!u.Autenticar(user)) {
	// RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	// request.setAttribute("erro", "Usuario e/ou senha incorretas.");
	// rd.include(request, response);
	// } else {
	// HttpSession session = request.getSession();
	// session.setAttribute("player", user);
	// // setting session to expire in 30 mins
	// session.setMaxInactiveInterval(30 * 60);
	// response.sendRedirect("index.jsp");
	// }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
