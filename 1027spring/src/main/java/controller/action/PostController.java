package controller.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import model.post.Paging;
import model.post.PostService;
import model.post.PostVO;

@Controller
public class PostController {
	
	@Autowired
	private PostService ps;
	
	@RequestMapping("/post.do")
	public String getPost(HttpServletRequest request, PostVO pvo, Model model) throws Exception {
		
		PostVO data=ps.getP(pvo);
		
		model.addAttribute("data", data);
		return "post.jsp";
	}
	
	@RequestMapping("/insert.do")
	public String insertPost(HttpServletRequest request, PostVO pvo) throws Exception {
		
		MultipartFile img=pvo.getImg();
		if(!img.isEmpty()) {
			String imgName=img.getOriginalFilename();
			System.out.println("file name: "+imgName);
			img.transferTo(new File("D:\\JIN_0622\\img\\"+imgName));
			pvo.setImgname("\\img\\"+imgName);
		}
		System.out.println("pvo 내에 이미지네임: "+pvo.getImgname());
		ps.insertP(pvo);
		return "redirect:main.do";
	}
	
	@RequestMapping("/edit.do")
	public String edit(PostVO pvo, Model model) throws Exception {
		
		PostVO data=ps.getP(pvo);
		
		model.addAttribute("data", data);
		return "update.jsp";
	}
	
	@RequestMapping("/update.do")
	public String update(PostVO pvo, Model model) throws Exception {

		ps.updateP(pvo);
		
		model.addAttribute("pnum", pvo.getPnum());
		return "redirect:post.do";
	}
	
	@RequestMapping("/delete.do")
	public String deletePost(PostVO pvo) throws Exception {
		
		ps.deleteP(pvo);
		
		return "redirect:main.do";
	}
	
	@RequestMapping("/main.do")
	public String handleRequest(HttpServletRequest request, Paging paging, Model model) throws Exception {
		
		int totalCount; // 테이블마다 전체 데이터 개수 
		int page = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
		
		totalCount = ps.getTotalCount();
		paging.setPageNo(page);
		paging.setTotalCount(totalCount);
		
		page = ((page-1)*10)+1;
		paging.setPageSize(page+9);
		List<PostVO> datas = ps.getPList(page, paging.getPageSize());
		// request.setAttribute("datas", datas);
		// request.setAttribute("paging", paging);
		
		//List<PostVO> datas=ps.getPList();
		
		
		model.addAttribute("datas", datas);
		model.addAttribute("paging", paging);
		return "main.jsp";
	}
}
