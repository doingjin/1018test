package controller.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.ActionForward;
import controller.action.DeleteAction;
import controller.action.EditAction;
import controller.action.InsertAction;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.MainAction;
import controller.action.PostAction;
import controller.action.QuitAction;
import controller.action.SignupAction;
import controller.action.UpdateAction;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		String action = uri.substring(cp.length());

		ActionForward forward = null;

		System.out.println("action: " + action);
		
		if(action.equals("/main.do")) {
			forward=new MainAction().execute(request, response);
		} else if(action.equals("/login.do")) {
			forward=new LoginAction().execute(request, response);
		} else if(action.equals("/logout.do")) {
			forward=new LogoutAction().execute(request, response);
		} else if(action.equals("/signup.do")) {
			forward=new SignupAction().execute(request, response);
		} else if(action.equals("/quit.do")) {
			forward=new QuitAction().execute(request, response);
		} else if(action.equals("/post.do")) {
			forward=new PostAction().execute(request, response);
		} else if(action.equals("/insert.do")) {
			forward=new InsertAction().execute(request, response);
		} else if(action.equals("/edit.do")) {
			forward=new EditAction().execute(request, response);
		} else if(action.equals("/update.do")) {
			forward=new UpdateAction().execute(request, response);
		} else if(action.equals("/delete.do")) {
			forward=new DeleteAction().execute(request, response);
		} else {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/error/error404.jsp");
		}
		
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
		
		
	}

}
