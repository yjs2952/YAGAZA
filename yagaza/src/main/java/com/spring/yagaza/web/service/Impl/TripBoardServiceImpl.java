package com.spring.yagaza.web.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.yagaza.web.domain.TripBoard;
import com.spring.yagaza.web.repository.TripBoardRepository;
import com.spring.yagaza.web.service.TripBoardService;

@Service
public class TripBoardServiceImpl implements TripBoardService {

	private TripBoardRepository boardRepository;

	public TripBoardServiceImpl(TripBoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	/**
	 * 여행게시판 목록 조회하기
	 */
	@Override
	public List<TripBoard> findByBoardList() {
		return boardRepository.findAll();
	}

	/**
	 * 여행게시판 상세페이지
	 */
	@Override
	public TripBoard findByBoardDetail(Long tripBoardNo) {
		return boardRepository.getOne(tripBoardNo);
	}
	

	
}
