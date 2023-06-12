package com.multi.fourtunes.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multi.fourtunes.model.dto.CommentDto;
import com.multi.fourtunes.model.dto.CommunityDto;
import com.multi.fourtunes.model.mapper.CommunityMapper;

@Repository
public class CommunityDaoImpl implements CommunityDao {

	@Autowired
	private CommunityMapper communityMapper;

	@Override
	public List<CommunityDto> getAll() {
		// List<CommunityDto> temp = communityMapper.getAll();
		// for (CommunityDto dto : temp) {
		// System.out.println(dto.toString());
		// }
		return communityMapper.getAll();
	}

	@Override
	public CommunityDto get(int boardNo) {
		return communityMapper.get(boardNo);
	}

	@Override
	public int insert(CommunityDto community) {
		return communityMapper.insert(community);
	}

	@Override
	public int update(CommunityDto community) {
		return communityMapper.update(community);
	}

	@Override
	public int delete(int boardNo) {
		return communityMapper.delete(boardNo);
	}

	@Override
	public int incrementViewCount(int boardNo) {
		return communityMapper.incrementViewCount(boardNo);
	}

	@Override
	public List<CommentDto> getComments(int boardNo) {
	    return communityMapper.getComments(boardNo);
	}
	
	@Override
	public int addComment(CommentDto comment) {
		return communityMapper.addComment(comment);
		
	}
	
	

	
	

//    @Override
//    public void updateReportCount(int boardNo) {
//        communityMapper.updateReportCount(boardNo);
//    }
//
//    @Override
//    public int checkDuplicateReport(int boardNo, int userNo) {
//        return communityMapper.checkDuplicateReport(boardNo, userNo);
//    }
	
}
