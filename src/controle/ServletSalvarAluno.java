package controle;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class ServletSalvarAluno
 */
@WebServlet("/salvarAluno")
public class ServletSalvarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSalvarAluno() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendError(403, "Acesso negado. Use o formul�rio para enviar os dados");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List <String> falhas = new ArrayList<String>();
		
		// pegando os parâmetros do request
		String matriculaWeb = request.getParameter("matricula");
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String dataNascimento = request.getParameter("dataNascimento");
		String serieWeb = request.getParameter("serie");
		String turnoWeb = request.getParameter("turno");
		String endereco = request.getParameter("endereco");
		
		
		//converter os tipos númericos
		
		Integer matricula;
		try {
			matricula = Integer.parseInt(matriculaWeb);
		} catch (NumberFormatException e) {
			matricula = null;
		}
		
		
		Integer serie;
		try {
			serie = Integer.parseInt(serieWeb);
		} catch (NumberFormatException e) {
			serie = null;
		}
		
		Integer idTurno;
		Turno turno;
		try {
			idTurno = Integer.parseInt(turnoWeb);
			
			TurnoDAO turnoDao = new TurnoDAO();
			// carregar o turno escolhido
			turno = turnoDao.alterar(idTurno);
			
		} catch (NumberFormatException e) {
			idTurno = null;
			turno = null;
		}
		
		// Verificando possíveis falhas no formulário
		
		if (nome.matches("[!@#$%Â¨&*()-_+Â§=/Â°?;:.>,<\\|[{]}ÂºÂªÂ¹Â²Â³Â£Â¢Â¬]*") || nome.trim().length() == 0)
			falhas.add("Os dados digitados no campo nome são inválidos.");
		
		if (serie == null)
			falhas.add("Os dados digitados no campo série são inválidos.");
		
		if (turno == null)
			falhas.add("O turno escolhido é inválido.");
		
		if (endereco.matches("[!@#$%Â¨&*()-_+Â§=/Â°?;:.>,<\\|[{]}ÂºÂªÂ¹Â²Â³Â£Â¢Â¬]*") || endereco.trim().length() == 0)
			falhas.add("Os dados digitados no campo endereço são inválidos.");
        
		
		
		// Criar instância do DAO para persistência 
		
		AlunoDAO dao = new AlunoDAO();
		
		// Passar os dados para o objeto do Modelo
		Aluno aluno = null;
		
		if (matricula == null)
			aluno = new Aluno(); // cria um registro novo
		else
			aluno = dao.alterar(matricula); // ler o aluno existente
		
		//preencher campos do aluno
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setDataNascimento(dataNascimento);
		aluno.setSerie(serie);
		
		//relacionar o turno selecionado com o aluno
		aluno.setTurno(turno);
				
		aluno.setEndereco(endereco);
		
		
		// testar se os dados enviados estão corretos
		if (falhas.size() == 0)
		{
			
			//salvar o objeto no banco de dados
			dao.salvar(aluno);

			// criar um objeto para despachar a requisição
			response.sendRedirect("listarAlunos");
		}
		else
		{
			// guardando o aluno no request para ser lido pela pagina
			request.setAttribute("aluno", aluno);
			request.setAttribute("falhas", falhas);
			
			TurnoDAO daoTurno = new TurnoDAO();
			
			// carregar lista do banco
			List <Turno> listaTurno = daoTurno.listar();
			
			//guardar lista no request
			request.setAttribute("listaTurno", listaTurno);
			
			// criando um objeto para despachar a requisição
			RequestDispatcher encaminhar = request.getRequestDispatcher("alunoEditar.jsp");
			
			// encaminhando para o servlet ou página selecionada
			encaminhar.forward(request, response);
		}
	}

}
