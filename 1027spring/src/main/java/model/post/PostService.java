package model.post;

import java.util.List;

public interface PostService {
	void insertP(PostVO pvo);
	void updateP(PostVO pvo);
	void deleteP(PostVO pvo);
	PostVO getP(PostVO pvo);
	List<PostVO> getPList();
	int getTotalCount();
	List<PostVO> getPList(int startRow, int endRow);
}
