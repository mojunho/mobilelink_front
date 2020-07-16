package kr.co.erst.mobilelink_front.service.impl;

import kr.co.erst.mobilelink_front.dao.BoardDAO;
import kr.co.erst.mobilelink_front.entities.BoardEntity;
import kr.co.erst.mobilelink_front.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDAO boardDAO;

    @Override
    public BoardEntity selectOneBoard() {
        BoardEntity board = boardDAO.selectOneBoard();
        return board;
    }
}
