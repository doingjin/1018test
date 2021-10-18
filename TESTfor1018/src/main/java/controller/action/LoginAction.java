package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.member.MemberDAO;
import model.member.MemberVO;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward=null;
		
		String mid=request.getParameter("mid");
		String mpw=request.getParameter("mpw");
		
		MemberDAO dao=new MemberDAO();
		MemberVO mvo=new MemberVO();
		mvo.setMid(mid);
		mvo.setMpw(mpw);
		
		if(dao.getM(mvo)!=null) {
			if(dao.getM(mvo).getMpw().equals(mpw)) {
				forward=new ActionForward();
				HttpSession session=request.getSession();
				session.setAttribute("mem", mvo.getMid());
				forward=new ActionForward();
				forward.setRedirect(false);
				forward.setPath("main.do");
			}
			else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>alert('Check your PASSWORD!');history.go(-1);</script>");
			}
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>alert('Check your ID!!');history.go(-1);</script>");
		}
		
		return forward;
	}

}
