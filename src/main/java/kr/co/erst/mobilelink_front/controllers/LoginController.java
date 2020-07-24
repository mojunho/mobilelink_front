package kr.co.erst.mobilelink_front.controllers;

import kr.co.erst.mobilelink_front.entities.BoardEntity;
import kr.co.erst.mobilelink_front.entities.UserEntity;
import kr.co.erst.mobilelink_front.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping(value = {"", "/"})
public class LoginController {

    @Resource
    BoardService boardService;

    public static final int LIMIT = 10;

    // 로그인 페이지, 시작 페이지 ---------------------------------------------------------------------------------------------------
    @RequestMapping(value = {"", "/", "/login"}, method = RequestMethod.GET)
    public String login(HttpSession httpSession) throws Exception{
        httpSession.invalidate();
        return "views/login";
    }

    // 로그인 처리 후 홈페이지로 이동 / 홈버튼 -----------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "homeMain", method = RequestMethod.GET)
    public String homeMain(Model model, HttpSession httpSession) throws Exception {
        UserEntity userEntity = (UserEntity) httpSession.getAttribute("userEntity");
        if (userEntity != null) {
            model.addAttribute("id", userEntity.getId());
            model.addAttribute("userName", userEntity.getName());
            return "views/index";
        }
        return "views/login";
    }

    // 로그아웃 ----------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "logout" , method = RequestMethod.GET)
    public String logout(HttpSession httpSession) {
        UserEntity userEntity = (UserEntity)httpSession.getAttribute("userEntity");
        if (userEntity != null) {
            httpSession.invalidate();
        }
        return "redirect:/";
    }

    // KT 게시판 페이지 ---------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "ktBoard", method = RequestMethod.GET)
    public String ktBoard(Model model, String condition, String keyword,
                           @RequestParam(value = "pn", required = false, defaultValue = "1") int pgNumber) throws Exception{
        int offset = (pgNumber - 1) * LIMIT;
        final int status = 2;
        if (condition == null) {
            int boardListCnt = boardService.boardCountForStatus(status);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:ktBoard?pn=1";
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
                return "views/boards/kt_board";
            } else {
                return "redirect:ktBoard";
            }
        } else if (condition.equals("title")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", status);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByTitle(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:ktBoard?pn=1";
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
                return "views/boards/kt_board";
            } else {
                return "redirect:ktBoard";
            }
        } else if (condition.equals("content")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", status);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByContent(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:ktBoard?pn=1";
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
                return "views/boards/kt_board";
            } else {
                return "redirect:ktBoard";
            }
        } else if (condition.equals("all")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", status);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByAll(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:ktBoard?pn=1";
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
                return "views/boards/kt_board";
            } else {
                return "redirect:ktBoard";
            }
        } else {
            return "redirect:ktBoard";
        }
    }
    @RequestMapping(value = "ktView", method = RequestMethod.GET)
    public String ktView(int id, Model model) throws Exception{
        boardService.readCountClickToBoard(id);
        BoardEntity boardEntity = boardService.selectOneBoardById(id);
        if (boardEntity != null) {
            model.addAttribute("boardTitle", boardEntity.getTitle());
            model.addAttribute("boardRegDate", boardEntity.getRegDate());
            model.addAttribute("boardReadCnt", boardEntity.getReadCount());
            model.addAttribute("boardContent", boardEntity.getContent());
            return "views/boards/boardview/kt_view";
        } else {
            return "ktBoard";
        }
    }

    // LGT 게시판 페이지 ---------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "lgtBoard", method = RequestMethod.GET)
    public String lgtBoard(Model model, String condition, String keyword,
                          @RequestParam(value = "pn", required = false, defaultValue = "1") int pgNumber) throws Exception{
        int offset = (pgNumber - 1) * LIMIT;
        final int status = 3;
        if (condition == null) {
            int boardListCnt = boardService.boardCountForStatus(status);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:lgtBoard?pn=1";
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
                return "views/boards/lgt_board";
            } else {
                return "redirect:lgtBoard";
            }
        } else if (condition.equals("title")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", status);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByTitle(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:lgtBoard?pn=1";
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
                return "views/boards/lgt_board";
            } else {
                return "redirect:lgtBoard";
            }
        } else if (condition.equals("content")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", status);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByContent(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:lgtBoard?pn=1";
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
                return "views/boards/lgt_board";
            } else {
                return "redirect:lgtBoard";
            }
        } else if (condition.equals("all")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", status);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByAll(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:lgtBoard?pn=1";
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
                return "views/boards/lgt_board";
            } else {
                return "redirect:lgtBoard";
            }
        } else {
            return "redirect:lgtBoard";
        }
    }
    @RequestMapping(value = "lgtView", method = RequestMethod.GET)
    public String lgtView(int id, Model model) throws Exception{
        boardService.readCountClickToBoard(id);
        BoardEntity boardEntity = boardService.selectOneBoardById(id);
        if (boardEntity != null) {
            model.addAttribute("boardTitle", boardEntity.getTitle());
            model.addAttribute("boardRegDate", boardEntity.getRegDate());
            model.addAttribute("boardReadCnt", boardEntity.getReadCount());
            model.addAttribute("boardContent", boardEntity.getContent());
            return "views/boards/boardview/lgt_view";
        } else {
            return "lgtBoard";
        }
    }

    // 인터넷 게시판 페이지 ---------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "internetBoard", method = RequestMethod.GET)
    public String internetBoard(Model model, String condition, String keyword,
                           @RequestParam(value = "pn", required = false, defaultValue = "1") int pgNumber) throws Exception{
        int offset = (pgNumber - 1) * LIMIT;
        final int status = 4;
        if (condition == null) {
            int boardListCnt = boardService.boardCountForStatus(status);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:internetBoard?pn=1";
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
                return "views/boards/internet_board";
            } else {
                return "redirect:internetBoard";
            }
        } else if (condition.equals("title")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", status);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByTitle(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:internetBoard?pn=1";
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
                return "views/boards/internet_board";
            } else {
                return "redirect:internetBoard";
            }
        } else if (condition.equals("content")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", status);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByContent(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:internetBoard?pn=1";
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
                return "views/boards/internet_board";
            } else {
                return "redirect:internetBoard";
            }
        } else if (condition.equals("all")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", status);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByAll(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:internetBoard?pn=1";
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
                return "views/boards/internet_board";
            } else {
                return "redirect:internetBoard";
            }
        } else {
            return "redirect:internetBoard";
        }
    }
    @RequestMapping(value = "internetView", method = RequestMethod.GET)
    public String internetView(int id, Model model) throws Exception{
        boardService.readCountClickToBoard(id);
        BoardEntity boardEntity = boardService.selectOneBoardById(id);
        if (boardEntity != null) {
            model.addAttribute("boardTitle", boardEntity.getTitle());
            model.addAttribute("boardRegDate", boardEntity.getRegDate());
            model.addAttribute("boardReadCnt", boardEntity.getReadCount());
            model.addAttribute("boardContent", boardEntity.getContent());
            return "views/boards/boardview/internet_view";
        } else {
            return "internetBoard";
        }
    }

    // 생활가전 게시판 페이지 ---------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "lifeMachineBoard", method = RequestMethod.GET)
    public String lifeMachineBoard(Model model, String condition, String keyword,
                           @RequestParam(value = "pn", required = false, defaultValue = "1") int pgNumber) throws Exception{
        int offset = (pgNumber - 1) * LIMIT;
        final int status = 5;
        if (condition == null) {
            int boardListCnt = boardService.boardCountForStatus(status);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:lifeMachineBoard?pn=1";
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
                return "views/boards/life_machine_board";
            } else {
                return "redirect:lifeMachineBoard";
            }
        } else if (condition.equals("title")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", status);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByTitle(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:lifeMachineBoard?pn=1";
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
                return "views/boards/life_machine_board";
            } else {
                return "redirect:lifeMachineBoard";
            }
        } else if (condition.equals("content")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", status);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByContent(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:lifeMachineBoard?pn=1";
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
                return "views/boards/life_machine_board";
            } else {
                return "redirect:lifeMachineBoard";
            }
        } else if (condition.equals("all")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", status);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByAll(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:lifeMachineBoard?pn=1";
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
                return "views/boards/life_machine_board";
            } else {
                return "redirect:lifeMachineBoard";
            }
        } else {
            return "redirect:lifeMachineBoard";
        }
    }
    @RequestMapping(value = "lifeMachineView", method = RequestMethod.GET)
    public String lifeMachineView(int id, Model model) throws Exception{
        boardService.readCountClickToBoard(id);
        BoardEntity boardEntity = boardService.selectOneBoardById(id);
        if (boardEntity != null) {
            model.addAttribute("boardTitle", boardEntity.getTitle());
            model.addAttribute("boardRegDate", boardEntity.getRegDate());
            model.addAttribute("boardReadCnt", boardEntity.getReadCount());
            model.addAttribute("boardContent", boardEntity.getContent());
            return "views/boards/boardview/life_machine_view";
        } else {
            return "lifeMachineBoard";
        }
    }

    // 이벤트 게시판 페이지 ---------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "eventBoard", method = RequestMethod.GET)
    public String eventBoard(Model model, String condition, String keyword,
                           @RequestParam(value = "pn", required = false, defaultValue = "1") int pgNumber) throws Exception{
        int offset = (pgNumber - 1) * LIMIT;
        final int status = 6;
        if (condition == null) {
            int boardListCnt = boardService.boardCountForStatus(status);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:eventBoard?pn=1";
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
                return "views/boards/event_board";
            } else {
                return "redirect:eventBoard";
            }
        } else if (condition.equals("title")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", status);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByTitle(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:eventBoard?pn=1";
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
                return "views/boards/event_board";
            } else {
                return "redirect:eventBoard";
            }
        } else if (condition.equals("content")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", status);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByContent(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:eventBoard?pn=1";
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
                return "views/boards/event_board";
            } else {
                return "redirect:eventBoard";
            }
        } else if (condition.equals("all")) {
            HashMap<String, Object> boardCount = new HashMap<String, Object>();
            boardCount.put("status", status);
            boardCount.put("keyword", keyword);
            int boardListCnt = boardService.boardCountByAll(boardCount);
            int maxPg = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
            if (pgNumber > maxPg || pgNumber <= 0) {
                System.out.println("잘못된 페이지 번호: " + pgNumber);
                return "redirect:eventBoard?pn=1";
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
                return "views/boards/event_board";
            } else {
                return "redirect:eventBoard";
            }
        } else {
            return "redirect:eventBoard";
        }
    }
    @RequestMapping(value = "eventView", method = RequestMethod.GET)
    public String eventView(int id, Model model) throws Exception{
        boardService.readCountClickToBoard(id);
        BoardEntity boardEntity = boardService.selectOneBoardById(id);
        if (boardEntity != null) {
            model.addAttribute("boardTitle", boardEntity.getTitle());
            model.addAttribute("boardRegDate", boardEntity.getRegDate());
            model.addAttribute("boardReadCnt", boardEntity.getReadCount());
            model.addAttribute("boardContent", boardEntity.getContent());
            return "views/boards/boardview/event_view";
        } else {
            return "eventBoard";
        }
    }

    // 회사 소개 페이지 ---------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "company", method = RequestMethod.GET)
    public String company() throws Exception{
        return "views/common/company";
    }

    // 알림 설정 페이지 ---------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "alarm", method = RequestMethod.GET)
    public String alarm() throws Exception{
        return "views/common/alarm";
    }

    // 마이 페이지 ---------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "mypage", method = RequestMethod.GET)
    public String mypage() throws Exception{
        return "views/common/mypage";
    }

    // 이용약관 페이지 ---------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "companyUse", method = RequestMethod.GET)
    public String companyUse() throws Exception{
        return "views/common/company_use";
    }

    // 개인정보 취급 페이지 ---------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "companyPerson", method = RequestMethod.GET)
    public String companyPerson() throws Exception{
        return "views/common/company_person";
    }

}
