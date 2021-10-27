package controller.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.member.MemberDAO;
import model.member.MemberService;
import model.member.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	@RequestMapping("/login.do")
	public String login(HttpSession session, MemberVO mvo, MemberDAO dao) throws Exception {
		
		MemberVO data=ms.getM(mvo);
		
		if(data!=null) {
			session.setAttribute("mem", mvo.getMid());
			
			return "redirect:main.do";
		} else {
			return "redirect:index.jsp";
		}

		/*String mid=request.getParameter("mid");
		String mpw=request.getParameter("mpw");
		
		mvo.setMid(mid);
		mvo.setMpw(mpw);
		
		if(dao.getM(mvo)!=null) {
			if(dao.getM(mvo).getMpw().equals(mpw)) {
				HttpSession session=request.getSession();
				session.setAttribute("mem", mvo.getMid());
				
				return "redirect:main.do"; // VR의 설정을 무시하고 
			}
			else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>alert('Check your PASSWORD!');history.go(-1);</script>");
				return "redirect:index.jsp";
				// PRINTOUT CHECK!!!
			}
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>alert('Check your ID!!');history.go(-1);</script>");
			return "redirect:index.jsp";
			// PRINTOUT CHECK!!!
		}*/
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) throws Exception {
		
		session.invalidate();
		
		return "redirect:index.jsp";
	}
	
	@RequestMapping("/quit.do")
	public String quitM(HttpSession session, MemberVO mvo, MemberDAO dao) throws Exception {
		
		ms.deleteM(mvo);
		
		return "redirect:logout.do";
	}
	
}
