package co.kr.spring.srv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.kr.spring.vo.BbsVo;

@Mapper
public interface BbsMapper {
	public List<BbsVo> getBbs();
}
