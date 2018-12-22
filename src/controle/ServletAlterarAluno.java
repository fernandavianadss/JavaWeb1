package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.AlunoDAO;
import modelo.dao.TurnoDAO;
import modelo.dominio.Aluno;
import modelo.dominio.Turno;

/**
 * Servlet implementation class ServletAbrirAlteracao
 */
@WebServlet("/alterar")
public class ServletAlterarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlterarAluno() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matriculaWeb = request.getParameter("matricula");
		Integer matricula = Integer.parseInt(matriculaWeb);
		
		//criar instância do DAO para persistencia
		AlunoDAO dao = new AlunoDAO();
		
		//carregar o aluno escolhido do banco
		Aluno aluno = dao.alterar(matricula);		
		
		//guardar o aluno no request para ser lido pela página
		request.setAttribute("aluno", aluno);
		
		TurnoDAO daoTurno = new TurnoDAO();
		
		//carregar a lista do banco
		List<Turno> listaTurno = daoTurno.listar();
		
		request.setAttribute("listaTurno", listaTurno);
		
		//criar um objeto para despachar a requisição
		RequestDispatcher encaminhar = request.getRequestDispatcher("alunoEditar.jsp");
		
		//encaminhar para o servlet ou página selecionada
		encaminhar.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
