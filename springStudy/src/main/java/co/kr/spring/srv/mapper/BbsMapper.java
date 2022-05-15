package co.kr.spring.srv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.kr.spring.vo.BbsVo;
import co.kr.spring.vo.Paging;

@Mapper
public interface BbsMapper {
	public List<BbsVo> getBbs(Paging paging);
	public BbsVo selectBbs(int seq);
	public int getTotal();
	public void insertBbs(BbsVo vo);
	public void updatePost(BbsVo vo);
	public List<BbsVo> comSel(int seq);
	public void comInsert(BbsVo vo);
	public BbsVo thisCom(int comSeq);
	public void comUpdate(BbsVo vo);
}
