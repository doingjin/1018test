package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.member.MemberDAO;
import model.member.MemberVO;

public class SignupController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String mid=request.getParameter("mid");
		String mpw=request.getParameter("mpw");
		
		MemberDAO dao=new MemberDAO();
		MemberVO mvo=new MemberVO();
		mvo.setMid(mid);
		mvo.setMpw(mpw);
		
		dao.insertM(mvo);
		
		// 아이디 중복 체크 구현 필요!!
		/*response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<script>alert('Successfully created your account ✌🏻');window.close();</script>");*/
		return null;
		// PRINTOUT CHECK!!!
	}

}
