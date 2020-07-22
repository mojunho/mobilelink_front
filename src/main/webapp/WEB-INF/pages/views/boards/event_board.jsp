<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%--<?--%>
<%--include "include/header.php";--%>
<%--?>--%>
<%@ include file="../include/header.jsp"%>

<%--<?--%>
<%--include "include/header_main.php";--%>
<%--?>--%>
<%@ include file="../include/header_main.jsp"%>

<div class="location">
    <div class="centerThis">
        <span>이벤트 공지</span> &gt; <span>이벤트</span> &gt; <strong>목록</strong>
    </div>
</div>
<div id="content_inner">

    <div class="subSec">
        <div class="centerThis">
            <div class="popTt">
                <h2>이벤트</h2>
            </div>
            <form action="eventBoard" method="get">
                <div class="searchBox">
                    <div class="srcSel">
                        <span class="selectWrap">
                            <select id="condition" name="condition" class="selectBox">
                                <option value="all" <c:if test="${cd eq 'all'}">selected</c:if>>전체</option>
                                <option value="title" <c:if test="${cd eq 'title'}">selected</c:if>>제목</option>
                                <option value="content" <c:if test="${cd eq 'content'}">selected</c:if>>내용</option>
                            </select>
                        </span>
                    </div>
                    <div class="srcInput">
                        <input type="text" placeholder="검색어 입력" class="int" id="keyword" name="keyword">
                    </div>
                    <div class="srcBtn">
                        <button type="submit"><i class="icon-magnifier"></i>검색</button>
                        <%--                        <a href="sktBoard?cd=${cd}&key=${key}"><i class="icon-magnifier"></i> 검색</a>--%>
                    </div>
                </div>
            </form>
            <c:if test="${!empty boardList}">
            <table class="tbList">
                <colgroup>
                    <col width="*">
                    <col width="25%">
                    <col width="16%">
                </colgroup>
                <thead>
                <tr>
                    <th>제목</th>
                    <th>날짜</th>
                    <th>조회수</th>
                </tr>
                </thead>
                <c:forEach var="board" items="${boardList}" varStatus="vs" begin="0" step="1">
                    <tbody>
                    <tr>
                        <td class="tl">
                            <a href="eventView?id=${board.id}">
                                    <span class="nowrap">
                                        <c:out value="${board.title}"/>
                                    </span>
                            </a>
                        </td>
                        <td>
                            <fmt:formatDate value="${board.regDate}" pattern="yyyy.MM.dd"/>
                        </td>
                        <td>
                            <c:out value="${board.readCount}"/>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
                </c:if>
            </table>
        </div>
        <style>
            #paging {
                text-align: center;
            }
            #paging_ul {
                margin: 50px;
                text-align: center;
            }
            .paging_li {
                display: inline;
                margin: 10px;
            }
        </style>
        <div id="paging">
            <ul id="paging_ul">
                <c:if test="${pn > 1}">
                    <li class="paging_li">
                        <a href="${pageContext.request.contextPath}/eventBoard?pn=${pn-1}">
                            <span>&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach varStatus="vs" begin="1" end="${maxPg}" step="1">
                    <c:if test="${vs.current eq pn}">
                        <li class="paging_li">
                            <b>${vs.current}</b>
                        </li>
                    </c:if>
                    <c:if test="${vs.current ne pn}">
                        <li class="paging_li">
                            <a href="${pageContext.request.contextPath}/eventBoard?pn=${vs.current}">${vs.current}</a>
                        </li>
                    </c:if>
                </c:forEach>
                <c:if test="${pn < maxPg}">
                    <li class="paging_li">
                        <a href="${pageContext.request.contextPath}/eventBoard?pn=${pn+1}">
                            <span>&raquo;</span>
                        </a>
                    </li>
                </c:if>
            </ul>
        </div>
        <!--//centerThis-->
    </div>
    <!--//subSec-->
</div>
<!--//#content_inner-->

<%--<?--%>
<%--include "include/footer.php";--%>
<%--?>--%>
<%@ include file="../include/footer.jsp"%>