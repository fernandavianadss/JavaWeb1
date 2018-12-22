package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.TurnoDAO;
import modelo.dominio.Aluno;
import modelo.dominio.Turno;



/**
 * Servlet implementation class ServletAbrirInclusao
 */
@WebServlet("/abrirInclusao")
public class ServletAbrirInclusao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAbrirInclusao() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// criando um novo objeto da Classe Aluno
			Aluno aluno = new Aluno();
		
		//  enviando o novo aluno para a página
			request.setAttribute("aluno", aluno);
			
			TurnoDAO daoTurno = new TurnoDAO();
			
			// carregar a lista do banco
			List<Turno> listaTurno = daoTurno.listar();
			
			// guardar a lista no request
			request.setAttribute("listaTurno", listaTurno);
			
		// enviando o processamento para a página
			RequestDispatcher encaminhar = request.getRequestDispatcher("alunoEditar.jsp");
			encaminhar.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
