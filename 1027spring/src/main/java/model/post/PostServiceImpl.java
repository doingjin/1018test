package model.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("PostService")
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostDAO pdao;
	
	
	@Override
	public void insertP(PostVO pvo) {
		pdao.insertP(pvo);
	}

	@Override
	public void updateP(PostVO pvo) {
		pdao.updateP(pvo);
	}

	@Override
	public void deleteP(PostVO pvo) {
		pdao.deleteP(pvo);
	}

	@Override
	public PostVO getP(PostVO pvo) {
		return pdao.getP(pvo);
	}

	@Override
	public List<PostVO> getPList() {
		return pdao.getPList();
	}
	
	public int getTotalCount() {
		return pdao.getTotalCount();
	}

	@Override
	public List<PostVO> getPList(int startRow, int endRow) {
		return pdao.getPList(startRow, endRow);
	}

}
