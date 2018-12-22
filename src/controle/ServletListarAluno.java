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
import modelo.dominio.Aluno;

/**
 * Servlet implementation class ServletAlunoListar
 */
@WebServlet("/listarAlunos")
public class ServletListarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarAluno() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//criar instância do DAO para persistência
		AlunoDAO dao = new AlunoDAO();
		
		// carregar a lista de alunos do banco de dados...
		List<Aluno> lista = dao.listar();
		
		// enviando a lista de alunos para a página...
		request.setAttribute("lista", lista);
		
		// enviando o processamento para a página
		RequestDispatcher encaminhar = request.getRequestDispatcher("alunoListar.jsp");
		encaminhar.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
