package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.post.PostDAO;
import model.post.PostVO;

public class EditAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward=new ActionForward();
		
		
		int pnum=Integer.parseInt(request.getParameter("pnum"));
		
		PostDAO dao=new PostDAO();
		PostVO pvo=new PostVO();
		pvo.setPnum(pnum);
		
		PostVO data=dao.getP(pvo);
		request.setAttribute("data", data);
		
		forward.setRedirect(false);
		forward.setPath("update.jsp");
		return forward;
		
	}

}
