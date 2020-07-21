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
        <span><a href="#">홈</a></span> &gt; <strong>회사소개</strong>
    </div>
</div>

<div id="content_inner">

    <div class="subSec">
        <div class="centerThis">
            <div class="popTt">
                <h2>회사소개</h2>
            </div>

            <ul class="subTab group tab_2">
                <li class="active">
                    <a data-toggle="tab" href="#company">회사소개</a>
                </li>
                <li>
                    <a data-toggle="tab" href="#map">약도</a>
                </li>
            </ul>

            <div class="subTabContent">
                <div id="company" class="tab-pane fade in active">
                    <strong>회사소개</strong>
                    <br>
                    <img src="${pageContext.request.contextPath}/resources/images/company.png" width="555px" height="780px">
                </div>

                <div id="map" class="tab-pane fade">
                    <!-- * 카카오맵 - 지도퍼가기 -->
                    <!-- 1. 지도 노드 -->
                    <div id="daumRoughmapContainer1595295042548" class="root_daum_roughmap root_daum_roughmap_landing"></div>

                    <!--
                        2. 설치 스크립트
                        * 지도 퍼가기 서비스를 2개 이상 넣을 경우, 설치 스크립트는 하나만 삽입합니다.
                    -->
                    <script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

                    <!-- 3. 실행 스크립트 -->
                    <script charset="UTF-8">
                        new daum.roughmap.Lander({
                            "timestamp" : "1595295042548",
                            "key" : "2zc78",
                            "mapWidth" : "640",
                            "mapHeight" : "360"
                        }).render();
                    </script>
                </div>
            </div>

        </div>

    </div>
    <!--//subList-->

</div>
<!--//#content_inner-->

<%--<?--%>
<%--include "include/footer.php";--%>
<%--?>--%>
<%@ include file="../include/footer.jsp"%>