// package br.ucsal.geu.filter;
//
// import java.io.IOException;
// import javax.servlet.Filter;
// import javax.servlet.FilterChain;
// import javax.servlet.FilterConfig;
// import javax.servlet.ServletException;
// import javax.servlet.ServletRequest;
// import javax.servlet.ServletResponse;
// import javax.servlet.annotation.WebFilter;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
//
// import br.ucsal.geu.model.Usuario;
//
/// ****
// * Servlet Filter implementation**
// *
// * class LogFilter
// */
// @WebFilter("/*")
// public class LogFilter implements Filter {
//
// /**
// * Default constructor.
// */
// public LogFilter() {
// // TODO Auto-generated constructor stub
// }
//
// /**
// * @see Filter#destroy()
// */
// public void destroy() {
// // TODO Auto-generated method stub
// }
//
// /**
// * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
// */
// public void doFilter(ServletRequest request, ServletResponse response,
// FilterChain chain)
// throws IOException, ServletException {
//
// HttpServletRequest httprequest = (HttpServletRequest) request;
// HttpServletResponse httpresponse = (HttpServletResponse) response;
// Object usuario = httprequest.getSession().getAttribute("usuario");
//
// // HttpServletResponse httpresponse = (HttpServletResponse) response;
// // HttpServletRequest http = (HttpServletRequest) request;
// // Usuario u = (Usuario) http.getSession().getAttribute("nome");
//
// boolean regra1 = httprequest.getRequestURI().endsWith("login");
// boolean regra2 = httprequest.getRequestURI().endsWith(".css");
// boolean regra3 = httprequest.getRequestURI().endsWith(".js");
//
// if (usuario == null && !(regra1 || regra2 || regra3)) {
// httpresponse.sendRedirect("/geu/login");
// }
// System.out.println("Filtrando");
// chain.doFilter(request, response);
// }
//
// /**
// * @see Filter#init(FilterConfig)
// */
// public void init(FilterConfig fConfig) throws ServletException {
// // TODO Auto-generated method stub
// }
//
// }
