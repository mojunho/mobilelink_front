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
public class BoardController {

    @Resource
    BoardService boardService;

    // status
    public static final int STATUS_SKT = 1;
    public static final int STATUS_KT = 2;
    public static final int STATUS_LGT = 3;
    public static final int STATUS_INTERNET = 4;
    public static final int STATUS_LIFEMACHINE = 5;
    public static final int STATUS_EVENT = 6;

    // link
    public static final String SKT = "skt";
    public static final String KT = "kt";
    public static final String LGT = "lgt";
    public static final String INTERNET = "internet";
    public static final String LIFEMACHINE = "life_machine";
    public static final String EVENT = "event";

    // paging limit
    public static final int LIMIT = 10;

    // view로 보낼 데이터
    public List<Map<String, Object>> inputToBoardList(List<BoardEntity> boardList, List<Map<String, Object>> pList) {
        for (int i = 0; i < boardList.size(); i++) {
            Map<String, Object> pMap = new HashMap<String, Object>();
            pMap.put("id", boardList.get(i).getId());
            pMap.put("title", boardList.get(i).getTitle());
            pMap.put("regDate", boardList.get(i).getRegDate());
            pMap.put("readCount", boardList.get(i).getReadCount());
            pList.add(pMap);
        }
        return pList;
    }

    // boardList 조회 SQL 입력
    public Map<String, Object> inputToBoardInfo(int status, int offset, int limit, Map<String, Object> boardInfo) {
        boardInfo.put("status", status);
        boardInfo.put("offset", offset);
        boardInfo.put("limit", limit);
        return boardInfo;
    }

    // search boardList 조회 SQL 입력
    public Map<String, Object> inputToBoardInfo(int status, String keyword, int offset, int limit, Map<String, Object> boardInfo) {
        boardInfo.put("status", status);
        boardInfo.put("keyword", keyword);
        boardInfo.put("offset", offset);
        boardInfo.put("limit", limit);
        return boardInfo;
    }

    // model 결과값
    public String modelResult(Model model, List<BoardEntity> boardList, int maxPg, int pgNumber, String category) {
        List<Map<String, Object>> pList = new ArrayList<Map<String, Object>>();
        pList = inputToBoardList(boardList, pList);
        model.addAttribute("maxPg", maxPg);
        model.addAttribute("pn", pgNumber);
        model.addAttribute("boardList", pList);
        return "views/boards/" + category + "_board";
    }

    // search model 결과값
    public String modelResult(Model model, List<BoardEntity> boardList, int maxPg, int pgNumber, String condition, String category) {
        List<Map<String, Object>> pList = new ArrayList<Map<String, Object>>();
        pList = inputToBoardList(boardList, pList);
        model.addAttribute("maxPg", maxPg);
        model.addAttribute("pn", pgNumber);
        model.addAttribute("cd", condition);
        model.addAttribute("boardList", pList);
        return "views/boards/" + category + "_board";
    }

    // view model 결과값
    public String viewModelResult(Model model, BoardEntity boardEntity, String category) {
        model.addAttribute("boardTitle", boardEntity.getTitle());
        model.addAttribute("boardRegDate", boardEntity.getRegDate());
        model.addAttribute("boardReadCnt", boardEntity.getReadCount());
        model.addAttribute("boardContent", boardEntity.getContent());
        return "views/boards/boardview/" + category + "_view";
    }

    // SKT 게시판 페이지 ---------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/sktBoard", method = RequestMethod.GET)
    public String sktBoard(Model model, String condition, String keyword,
                           @RequestParam(value = "pn", required = false, defaultValue = "1") int pgNumber) throws Exception{
        int offset = (pgNumber - 1) * LIMIT;
        if (condition == null) {
            int boardListCnt = boardService.boardCountForStatus(STATUS_SKT);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:sktBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_SKT, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectListBoardByStatus(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, SKT);
            } else {
                return "redirect:sktBoard";
            }
        } else if (condition.equals("title")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", STATUS_SKT);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByTitle(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:sktBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_SKT, keyword, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectBoardListByTitle(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, condition, SKT);
            } else {
                return "redirect:sktBoard";
            }
        } else if (condition.equals("content")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", STATUS_SKT);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByContent(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:sktBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_SKT, keyword, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectBoardListByContent(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, condition, SKT);
            } else {
                return "redirect:sktBoard";
            }
        } else if (condition.equals("all")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", STATUS_SKT);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByAll(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:sktBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_SKT, keyword, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectBoardListByAll(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, condition, SKT);
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
            return viewModelResult(model, boardEntity, SKT);
        } else {
            return "sktBoard";
        }
    }

    // KT 게시판 페이지 ---------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/ktBoard", method = RequestMethod.GET)
    public String ktBoard(Model model, String condition, String keyword,
                           @RequestParam(value = "pn", required = false, defaultValue = "1") int pgNumber) throws Exception{
        int offset = (pgNumber - 1) * LIMIT;
        if (condition == null) {
            int boardListCnt = boardService.boardCountForStatus(STATUS_KT);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:ktBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_KT, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectListBoardByStatus(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, KT);
            } else {
                return "redirect:ktBoard";
            }
        } else if (condition.equals("title")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", STATUS_KT);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByTitle(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:ktBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_KT, keyword, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectBoardListByTitle(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, condition, KT);
            } else {
                return "redirect:ktBoard";
            }
        } else if (condition.equals("content")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", STATUS_KT);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByContent(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:ktBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_KT, keyword, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectBoardListByContent(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, condition, KT);
            } else {
                return "redirect:ktBoard";
            }
        } else if (condition.equals("all")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", STATUS_KT);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByAll(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:ktBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_KT, keyword, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectBoardListByAll(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, condition, KT);
            } else {
                return "redirect:ktBoard";
            }
        } else {
            return "redirect:ktBoard";
        }
    }
    @RequestMapping(value = "/ktView", method = RequestMethod.GET)
    public String ktView(int id, Model model) throws Exception{
        boardService.readCountClickToBoard(id);
        BoardEntity boardEntity = boardService.selectOneBoardById(id);
        if (boardEntity != null) {
            return viewModelResult(model, boardEntity, KT);
        } else {
            return "ktBoard";
        }
    }

    // LGT 게시판 페이지 ---------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/lgtBoard", method = RequestMethod.GET)
    public String lgtBoard(Model model, String condition, String keyword,
                           @RequestParam(value = "pn", required = false, defaultValue = "1") int pgNumber) throws Exception{
        int offset = (pgNumber - 1) * LIMIT;
        if (condition == null) {
            int boardListCnt = boardService.boardCountForStatus(STATUS_LGT);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:lgtBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_LGT, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectListBoardByStatus(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, LGT);
            } else {
                return "redirect:lgtBoard";
            }
        } else if (condition.equals("title")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", STATUS_LGT);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByTitle(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:lgtBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_LGT, keyword, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectBoardListByTitle(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, condition, LGT);
            } else {
                return "redirect:lgtBoard";
            }
        } else if (condition.equals("content")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", STATUS_LGT);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByContent(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:lgtBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_LGT, keyword, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectBoardListByContent(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, condition, LGT);
            } else {
                return "redirect:lgtBoard";
            }
        } else if (condition.equals("all")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", STATUS_LGT);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByAll(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:lgtBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_LGT, keyword, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectBoardListByAll(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, condition, LGT);
            } else {
                return "redirect:lgtBoard";
            }
        } else {
            return "redirect:lgtBoard";
        }
    }
    @RequestMapping(value = "/lgtView", method = RequestMethod.GET)
    public String lgtView(int id, Model model) throws Exception{
        boardService.readCountClickToBoard(id);
        BoardEntity boardEntity = boardService.selectOneBoardById(id);
        if (boardEntity != null) {
            return viewModelResult(model, boardEntity, LGT);
        } else {
            return "lgtBoard";
        }
    }

    // INTERNET 게시판 페이지 ---------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/internetBoard", method = RequestMethod.GET)
    public String internetBoard(Model model, String condition, String keyword,
                           @RequestParam(value = "pn", required = false, defaultValue = "1") int pgNumber) throws Exception{
        int offset = (pgNumber - 1) * LIMIT;
        if (condition == null) {
            int boardListCnt = boardService.boardCountForStatus(STATUS_INTERNET);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:internetBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_INTERNET, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectListBoardByStatus(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, INTERNET);
            } else {
                return "redirect:internetBoard";
            }
        } else if (condition.equals("title")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", STATUS_INTERNET);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByTitle(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:internetBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_INTERNET, keyword, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectBoardListByTitle(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, condition, INTERNET);
            } else {
                return "redirect:internetBoard";
            }
        } else if (condition.equals("content")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", STATUS_INTERNET);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByContent(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:internetBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_INTERNET, keyword, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectBoardListByContent(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, condition, INTERNET);
            } else {
                return "redirect:internetBoard";
            }
        } else if (condition.equals("all")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", STATUS_INTERNET);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByAll(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:internetBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_INTERNET, keyword, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectBoardListByAll(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, condition, INTERNET);
            } else {
                return "redirect:internetBoard";
            }
        } else {
            return "redirect:internetBoard";
        }
    }
    @RequestMapping(value = "/internetView", method = RequestMethod.GET)
    public String internetView(int id, Model model) throws Exception{
        boardService.readCountClickToBoard(id);
        BoardEntity boardEntity = boardService.selectOneBoardById(id);
        if (boardEntity != null) {
            return viewModelResult(model, boardEntity, INTERNET);
        } else {
            return "internetBoard";
        }
    }

    // LIFEMACHINE 게시판 페이지 ---------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/lifeMachineBoard", method = RequestMethod.GET)
    public String lifeMachineBoard(Model model, String condition, String keyword,
                           @RequestParam(value = "pn", required = false, defaultValue = "1") int pgNumber) throws Exception{
        int offset = (pgNumber - 1) * LIMIT;
        if (condition == null) {
            int boardListCnt = boardService.boardCountForStatus(STATUS_LIFEMACHINE);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:lifeMachineBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_LIFEMACHINE, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectListBoardByStatus(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, LIFEMACHINE);
            } else {
                return "redirect:lifeMachineBoard";
            }
        } else if (condition.equals("title")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", STATUS_LIFEMACHINE);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByTitle(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:lifeMachineBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_LIFEMACHINE, keyword, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectBoardListByTitle(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, condition, LIFEMACHINE);
            } else {
                return "redirect:lifeMachineBoard";
            }
        } else if (condition.equals("content")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", STATUS_LIFEMACHINE);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByContent(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:lifeMachineBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_LIFEMACHINE, keyword, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectBoardListByContent(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, condition, LIFEMACHINE);
            } else {
                return "redirect:lifeMachineBoard";
            }
        } else if (condition.equals("all")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", STATUS_LIFEMACHINE);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByAll(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:lifeMachineBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_LIFEMACHINE, keyword, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectBoardListByAll(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, condition, LIFEMACHINE);
            } else {
                return "redirect:lifeMachineBoard";
            }
        } else {
            return "redirect:lifeMachineBoard";
        }
    }
    @RequestMapping(value = "/lifeMachineView", method = RequestMethod.GET)
    public String lifeMachineView(int id, Model model) throws Exception{
        boardService.readCountClickToBoard(id);
        BoardEntity boardEntity = boardService.selectOneBoardById(id);
        if (boardEntity != null) {
            return viewModelResult(model, boardEntity, LIFEMACHINE);
        } else {
            return "lifeMachineBoard";
        }
    }

    // EVENT 게시판 페이지 ---------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/eventBoard", method = RequestMethod.GET)
    public String eventBoard(Model model, String condition, String keyword,
                           @RequestParam(value = "pn", required = false, defaultValue = "1") int pgNumber) throws Exception{
        int offset = (pgNumber - 1) * LIMIT;
        if (condition == null) {
            int boardListCnt = boardService.boardCountForStatus(STATUS_EVENT);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:eventBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_EVENT, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectListBoardByStatus(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, EVENT);
            } else {
                return "redirect:eventBoard";
            }
        } else if (condition.equals("title")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", STATUS_EVENT);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByTitle(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:eventBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_EVENT, keyword, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectBoardListByTitle(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, condition, EVENT);
            } else {
                return "redirect:eventBoard";
            }
        } else if (condition.equals("content")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", STATUS_EVENT);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByContent(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:eventBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_EVENT, keyword, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectBoardListByContent(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, condition, EVENT);
            } else {
                return "redirect:eventBoard";
            }
        } else if (condition.equals("all")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", STATUS_EVENT);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByAll(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:eventBoard?pn=1";
            }
            Map<String, Object> boardInfo = new HashMap<String, Object>();
            boardInfo = inputToBoardInfo(STATUS_EVENT, keyword, offset, LIMIT, boardInfo);
            List<BoardEntity> boardList = boardService.selectBoardListByAll(boardInfo);
            if (boardList != null) {
                return modelResult(model, boardList, maxPg, pgNumber, condition, EVENT);
            } else {
                return "redirect:eventBoard";
            }
        } else {
            return "redirect:eventBoard";
        }
    }
    @RequestMapping(value = "/eventView", method = RequestMethod.GET)
    public String eventView(int id, Model model) throws Exception{
        boardService.readCountClickToBoard(id);
        BoardEntity boardEntity = boardService.selectOneBoardById(id);
        if (boardEntity != null) {
            return viewModelResult(model, boardEntity, EVENT);
        } else {
            return "eventBoard";
        }
    }

}
