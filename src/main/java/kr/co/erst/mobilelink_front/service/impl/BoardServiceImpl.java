package kr.co.erst.mobilelink_front.service.impl;

import kr.co.erst.mobilelink_front.dao.BoardDAO;
import kr.co.erst.mobilelink_front.entities.BoardEntity;
import kr.co.erst.mobilelink_front.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDAO boardDAO;

    @Override
    public List<BoardEntity> selectListBoardByStatus(Map<String, Object> map) {
        List<BoardEntity> board = boardDAO.selectListBoardByStatus(map);
        return board;
    }

    @Override
    public int boardCountForStatus(int status) {
        int cnt = boardDAO.boardCountForStatus(status);
        return cnt;
    }

    @Override
    public BoardEntity selectOneBoardById(int id) {
        BoardEntity boardEntity = boardDAO.selectOneBoardById(id);
        return boardEntity;
    }

    @Override
    public void readCountClickToBoard(int id) {
        boardDAO.readCountClickToBoard(id);
    }

    @Override
    public List<BoardEntity> selectBoardListByAll(Map<String, Object> map) {
        List<BoardEntity> board = boardDAO.selectBoardListByAll(map);
        return board;
    }

    @Override
    public int boardCountByAll(Map<String, Object> map) {
        int cnt = boardDAO.boardCountByAll(map);
        return cnt;
    }

    @Override
    public List<BoardEntity> selectBoardListByTitle(Map<String, Object> map) {
        List<BoardEntity> board = boardDAO.selectBoardListByTitle(map);
        return board;
    }

    @Override
    public int boardCountByTitle(Map<String, Object> map) {
        int cnt = boardDAO.boardCountByTitle(map);
        return cnt;
    }

    @Override
    public List<BoardEntity> selectBoardListByContent(Map<String, Object> map) {
        List<BoardEntity> board = boardDAO.selectBoardListByContent(map);
        return board;
    }

    @Override
    public int boardCountByContent(Map<String, Object> map) {
        int cnt = boardDAO.boardCountByContent(map);
        return cnt;
    }

}
