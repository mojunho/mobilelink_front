package kr.co.erst.mobilelink_front.entities;

import java.util.Date;

public class BoardEntity {
    private static final long serialVersionUID = -6375567936022237503L;

    private int id; // 게시판 순서 번호
    private String title; // 게시글 제목
    private String content; // 게시글 내용
    private Date regDate; // 게시글 등록 날짜
    private int readCount; // 게시글 조회수
    private int status; // 게시글 분야(1. SKT, 2. KT, 3. LGT, 4. 유선/인터넷, 5. 생활가전, 6. 이벤트)
    private int mbId; // 게시글 작성자

    public BoardEntity() {}
    public BoardEntity(String title, String content, int mbId) {
        this(0, title, content, null, 0, 1, mbId);
    }
    public BoardEntity(int id, String title, String content, Date regDate, int readCount, int status, int mbId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.readCount = readCount;
        this.status = status;
        this.mbId = mbId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMbId() {
        return mbId;
    }

    public void setMbId(int mbId) {
        this.mbId = mbId;
    }

    @Override
    public String toString() {
        return "BoardEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", regDate=" + regDate +
                ", readCount=" + readCount +
                ", status=" + status +
                ", mbId=" + mbId +
                '}';
    }
}
