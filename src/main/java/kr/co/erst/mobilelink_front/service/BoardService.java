package kr.co.erst.mobilelink_front.service;

import kr.co.erst.mobilelink_front.entities.BoardEntity;

import java.util.List;
import java.util.Map;

public interface BoardService {

    List<BoardEntity> selectListBoardByStatus(Map<String, Object> map);

    int boardCountForStatus(int status);

    BoardEntity selectOneBoardById(int id);

    void readCountClickToBoard(int id);

    List<BoardEntity> selectBoardListByAll(Map<String, Object> map);

    int boardCountByAll(Map<String, Object> map);

    List<BoardEntity> selectBoardListByTitle(Map<String, Object> map);

    int boardCountByTitle(Map<String, Object> map);

    List<BoardEntity> selectBoardListByContent(Map<String, Object> map);

    int boardCountByContent(Map<String, Object> map);

}
