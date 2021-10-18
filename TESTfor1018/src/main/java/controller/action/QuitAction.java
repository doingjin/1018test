package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.member.MemberDAO;
import model.member.MemberVO;

public class QuitAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ActionForward forward=new ActionForward();
		
		HttpSession session=request.getSession();
		String mid=(String)session.getAttribute("mem");
		
		MemberDAO dao=new MemberDAO();
		MemberVO mvo=new MemberVO();
		mvo.setMid(mid);
		
		dao.deleteM(mvo);
		
		forward.setRedirect(true);
		forward.setPath("logout.do");
		return forward;
	}

}
