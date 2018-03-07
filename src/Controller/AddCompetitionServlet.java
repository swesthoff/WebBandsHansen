package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Competition;

/**
 * Servlet implementation class AddCompetitionServlet
 */
@WebServlet("/AddCompetitionServlet")
public class AddCompetitionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCompetitionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String competitionIdStr = request.getParameter("competition id");
		String bandIdStr = request.getParameter("band id");  
		
		int competitionId = Integer.valueOf(competitionIdStr);
		int bandId = Integer.valueOf(bandIdStr);
 
		Competition li = new Competition(competitionId, bandId);
		CompetitionHelper dao = new CompetitionHelper();
		dao.insertBands(li);

		getServletContext().getRequestDispatcher("/addCompetition.html").forward(request, response);
	}

}