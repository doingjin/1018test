package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.post.Pagination;
import model.post.Paging;
import model.post.PostVO;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward=new ActionForward();
		
		int totalCount; // 테이블마다 전체 데이터 개수 
		int page = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
		
		Pagination pgnt=new Pagination();
		totalCount = pgnt.getTotalCount();
		Paging paging = new Paging();
		paging.setPageNo(page);
		paging.setTotalCount(totalCount);
		
		page = ((page-1)*10)+1;
		paging.setPageSize(page+9); 
		ArrayList<PostVO> datas = pgnt.getPList(page,paging.getPageSize());
		request.setAttribute("datas", datas);
		request.setAttribute("paging", paging);
		
		forward.setRedirect(false);
		forward.setPath("main.jsp");		
		return forward;
	}

}
