package org.radonc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


public class ControllerServlet extends HttpServlet {

	@Resource(name="jdbc/fitDataSource")
	private DataSource ds;

	
	public void init() throws ServletException {
	 
	}
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//create new session
		HttpSession session = request.getSession(true);
		List<String> dbObject = new ArrayList<String>();
		dbObject.add("string1");
		dbObject.add("string2");
		dbObject.add("string3");
		
		request.setAttribute("myListRequest", "some request attribute");
		
		//get Data from a database
		 try {
			Connection connection = ds.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from activity");
			session.setAttribute("resultSet", rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("myListSession", dbObject);
		String nextJSP = "/pages/main.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request,response);
		
	}

	public void destroy() {
		// do nothing.
	}

}
