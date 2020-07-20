<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <span><a href="#">이벤트 공지</a></span> &gt; <span><a href="#">이벤트</a></span> &gt; <strong>목록</strong>
    </div>
</div>
<div id="content_inner">

    <div class="subSec">
        <div class="centerThis">
            <div class="popTt">
                <h2>이벤트</h2>
            </div>
            <div class="searchBox">
                <div class="srcSel">
					<span class="selectWrap">
						<select class="selectBox">
							<option>선택</option>
						</select>
						</span>
                </div>
                <div class="srcInput">
                    <input type="text" placeholder="검색어 입력" class="int">
                </div>
                <div class="srcBtn">
                    <a href="#"><i class="icon-magnifier"></i> 검색</a>
                </div>
            </div>
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
                <tbody>
                <tr>
                    <td class="tl"><a href="eventView"><span class="nowrap">건강보험료 줄이는 방법을 안내해드립니다.건강보험료 줄이는 방법을 안내해드립니다.건강보험료 줄이는 방법을 안내해드립니다.건강보험료 줄이는 방법을 안내해드립니다.</span></a></td>
                    <td>2018.04.05</td>
                    <td>9879</td>
                </tr>
                <tr>
                    <td class="tl"><a href="eventView"><span class="nowrap">건강보험료 줄이는 방법을 안내해드립니다.건강보험료 줄이는 방법을 안내해드립니다.건강보험료 줄이는 방법을 안내해드립니다.건강보험료 줄이는 방법을 안내해드립니다.</span></a></td>
                    <td>2018.04.05</td>
                    <td>9879</td>
                </tr>
                <tr>
                    <td class="tl"><a href="eventView"><span class="nowrap">건강보험료 줄이는 방법을 안내해드립니다.건강보험료 줄이는 방법을 안내해드립니다.건강보험료 줄이는 방법을 안내해드립니다.건강보험료 줄이는 방법을 안내해드립니다.</span></a></td>
                    <td>2018.04.05</td>
                    <td>9879</td>
                </tr>
                <tr>
                    <td class="tl"><a href="eventView"><span class="nowrap">건강보험료 줄이는 방법을 안내해드립니다.건강보험료 줄이는 방법을 안내해드립니다.건강보험료 줄이는 방법을 안내해드립니다.건강보험료 줄이는 방법을 안내해드립니다.</span></a></td>
                    <td>2018.04.05</td>
                    <td>9879</td>
                </tr>
                <tr>
                    <td class="tl"><a href="eventView"><span class="nowrap">건강보험료 줄이는 방법을 안내해드립니다.건강보험료 줄이는 방법을 안내해드립니다.건강보험료 줄이는 방법을 안내해드립니다.건강보험료 줄이는 방법을 안내해드립니다.</span></a></td>
                    <td>2018.04.05</td>
                    <td>9879</td>
                </tr>
                <tr>
                    <td class="tl"><a href="eventView"><span class="nowrap">건강보험료 줄이는 방법을 안내해드립니다.건강보험료 줄이는 방법을 안내해드립니다.건강보험료 줄이는 방법을 안내해드립니다.건강보험료 줄이는 방법을 안내해드립니다.</span></a></td>
                    <td>2018.04.05</td>
                    <td>9879</td>
                </tr>
                </tbody>
            </table>
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