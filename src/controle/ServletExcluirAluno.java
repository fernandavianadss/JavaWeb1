package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.AlunoDAO;
import modelo.dominio.Aluno;

/**
 * Servlet implementation class ServletAlunoExcluir
 */
@WebServlet("/excluir")
public class ServletExcluirAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirAluno() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matriculaWeb = request.getParameter("matricula");
		Integer matricula = Integer.parseInt(matriculaWeb);

		// criar instância do DAO para persistência
		AlunoDAO dao = new AlunoDAO();

		// carregar o aluno escolhido do banco
		Aluno aluno = dao.alterar(matricula);

		// excluir o aluno do banco de dados
		dao.excluir(aluno);

		// fazer redirect para listar os alunos, a fim de evitar envios repetidos
		response.sendRedirect("listarAlunos");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
