package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.post.PostDAO;
import model.post.PostVO;



public class InsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward=new ActionForward();
		
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String mid=request.getParameter("mid");
		//System.out.println(content);
		
		PostDAO dao=new PostDAO();
		PostVO pvo=new PostVO();
		
		pvo.setTitle(title);
		pvo.setContent(content);
		pvo.setMid(mid);
		
		dao.insertP(pvo);
		
		forward.setRedirect(true);
		forward.setPath("main.do");
		return forward;
	}

}
