package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.post.PostDAO;
import model.post.PostVO;

public class UpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward=new ActionForward();
		
		int pnum=Integer.parseInt(request.getParameter("pnum"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		PostDAO dao=new PostDAO();
		PostVO pvo=new PostVO();
		pvo.setPnum(pnum);
		pvo.setTitle(title);
		pvo.setContent(content);
		
		dao.updateP(pvo);
		
		forward.setRedirect(true);
		forward.setPath("post.do?pnum="+pnum);
		return forward;
	}

}
