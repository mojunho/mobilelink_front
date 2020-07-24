package kr.co.erst.mobilelink_front.controllers;

import kr.co.erst.mobilelink_front.entities.BoardEntity;
import kr.co.erst.mobilelink_front.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

    @Resource
    BoardService boardService;

    public static final int LIMIT = 10;

    // SKT 게시판 페이지 ---------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/sktBoard", method = RequestMethod.GET)
    public String sktBoard(Model model, String condition, String keyword,
                           @RequestParam(value = "pn", required = false, defaultValue = "1") int pgNumber) throws Exception{
        int offset = (pgNumber - 1) * LIMIT;
        final int status = 1;
        if (condition == null) {
            int boardListCnt = boardService.boardCountForStatus(status);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:sktBoard?pn=1";
            }
            HashMap<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo.put("status", status);
            boardInfo.put("offset", offset);
            boardInfo.put("limit", LIMIT);
            List<BoardEntity> boardList = boardService.selectListBoardByStatus(boardInfo);
            if (boardList != null) {
                List<Map<String, Object>> pList = new ArrayList<Map<String, Object>>();
                for (int i = 0; i < boardList.size(); i++) {
                    Map<String, Object> pMap = new HashMap<String, Object>();
                    pMap.put("id", boardList.get(i).getId());
                    pMap.put("title", boardList.get(i).getTitle());
                    pMap.put("regDate", boardList.get(i).getRegDate());
                    pMap.put("readCount", boardList.get(i).getReadCount());
                    pList.add(pMap);
                }
                model.addAttribute("maxPg", maxPg);
                model.addAttribute("pn", pgNumber);
                model.addAttribute("boardList", pList);
                model.addAttribute("boardSize", boardList.size());
                return "views/boards/skt_board";
            } else {
                return "redirect:sktBoard";
            }
        } else if (condition.equals("title")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", status);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByTitle(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:sktBoard?pn=1";
            }
            HashMap<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo.put("status", status);
            boardInfo.put("keyword", keyword);
            boardInfo.put("offset", offset);
            boardInfo.put("limit", LIMIT);
            List<BoardEntity> boardList = boardService.selectBoardListByTitle(boardInfo);
            if (boardList != null) {
                List<Map<String, Object>> pList = new ArrayList<Map<String, Object>>();
                for (int i = 0; i < boardList.size(); i++) {
                    Map<String, Object> pMap = new HashMap<String, Object>();
                    pMap.put("id", boardList.get(i).getId());
                    pMap.put("title", boardList.get(i).getTitle());
                    pMap.put("regDate", boardList.get(i).getRegDate());
                    pMap.put("readCount", boardList.get(i).getReadCount());
                    pList.add(pMap);
                }
                model.addAttribute("maxPg", maxPg);
                model.addAttribute("pn", pgNumber);
                model.addAttribute("cd", condition);
                model.addAttribute("boardList", pList);
                model.addAttribute("boardSize", boardList.size());
                return "views/boards/skt_board";
            } else {
                return "redirect:sktBoard";
            }
        } else if (condition.equals("content")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", status);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByContent(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:sktBoard?pn=1";
            }
            HashMap<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo.put("status", status);
            boardInfo.put("keyword", keyword);
            boardInfo.put("offset", offset);
            boardInfo.put("limit", LIMIT);
            List<BoardEntity> boardList = boardService.selectBoardListByContent(boardInfo);
            if (boardList != null) {
                List<Map<String, Object>> pList = new ArrayList<Map<String, Object>>();
                for (int i = 0; i < boardList.size(); i++) {
                    Map<String, Object> pMap = new HashMap<String, Object>();
                    pMap.put("id", boardList.get(i).getId());
                    pMap.put("title", boardList.get(i).getTitle());
                    pMap.put("regDate", boardList.get(i).getRegDate());
                    pMap.put("readCount", boardList.get(i).getReadCount());
                    pList.add(pMap);
                }
                model.addAttribute("maxPg", maxPg);
                model.addAttribute("pn", pgNumber);
                model.addAttribute("cd", condition);
                model.addAttribute("boardList", pList);
                model.addAttribute("boardSize", boardList.size());
                return "views/boards/skt_board";
            } else {
                return "redirect:sktBoard";
            }
        } else if (condition.equals("all")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", status);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByAll(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:sktBoard?pn=1";
            }
            HashMap<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo.put("status", status);
            boardInfo.put("keyword", keyword);
            boardInfo.put("offset", offset);
            boardInfo.put("limit", LIMIT);
            List<BoardEntity> boardList = boardService.selectBoardListByAll(boardInfo);
            if (boardList != null) {
                List<Map<String, Object>> pList = new ArrayList<Map<String, Object>>();
                for (int i = 0; i < boardList.size(); i++) {
                    Map<String, Object> pMap = new HashMap<String, Object>();
                    pMap.put("id", boardList.get(i).getId());
                    pMap.put("title", boardList.get(i).getTitle());
                    pMap.put("regDate", boardList.get(i).getRegDate());
                    pMap.put("readCount", boardList.get(i).getReadCount());
                    pList.add(pMap);
                }
                model.addAttribute("maxPg", maxPg);
                model.addAttribute("pn", pgNumber);
                model.addAttribute("cd", condition);
                model.addAttribute("boardList", pList);
                model.addAttribute("boardSize", boardList.size());
                return "views/boards/skt_board";
            } else {
                return "redirect:sktBoard";
            }
        } else {
            return "redirect:sktBoard";
        }
    }
    @RequestMapping(value = "/sktView", method = RequestMethod.GET)
    public String sktView(int id, Model model) throws Exception{
        boardService.readCountClickToBoard(id);
        BoardEntity boardEntity = boardService.selectOneBoardById(id);
        if (boardEntity != null) {
            model.addAttribute("boardTitle", boardEntity.getTitle());
            model.addAttribute("boardRegDate", boardEntity.getRegDate());
            model.addAttribute("boardReadCnt", boardEntity.getReadCount());
            model.addAttribute("boardContent", boardEntity.getContent());
            return "views/boards/boardview/skt_view";
        } else {
            return "sktBoard";
        }
    }

}
