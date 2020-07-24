<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="no"/>
    <!-- 브라우저의 UI를 안보이게 -->
    <meta name="apple-mobile-web-app-status-bar-style" content="white"/>
    <!-- 상태바의 색상 지정 -->
    <title>mobilelink</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css" media="all" />
    <script src="${pageContext.request.contextPath}/resources/js/jquery-latest.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/common.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.touchSwipe.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/lnb.js" type="text/javascript"></script>
<body>
<div id="content_wrap" class="group">
<%--    <a href="#" id="lnav_close"><i class="fa fa-times" aria-hidden="true"></i></a>--%>

    <div id="ltnav">
        <div class="ltnav_inner" style="overflow:auto; -webkit-overflow-scrolling:touch;">
            <div id="ltnav_title">
                <div class="ltnav_text">
                    <h3><em><i class="la la-user"></i></em> 안녕하세요. <strong><c:out value="${userName}"/></strong>님</h3>
                </div>
                <a href="#" id="lnav_close"><i class="la la-close"></i></a>
            </div>
            <!---//ltnav_title-->
            <div id="cssmenu">
                <ul>
                    <li onclick="location.href='/homeMain'">
                        <div class="tt">
                            <i class="la la-home"></i> 홈
                        </div>
                    </li>
                    <li class="has-sub">
                        <div class="tt">
                            <i class="la la-mobile"></i> 모바일 임직원 특판
                        </div>
                        <ul>
                            <li onclick="location.href='/sktBoard'">
                                SKT
                            </li>
                            <li onclick="location.href='/ktBoard'">
                                KT
                            </li>
                            <li onclick="location.href='/lgtBoard'">
                                LGT
                            </li>
                        </ul>
                    </li>
                    <li onclick="location.href='/internetBoard'">
                        <div>
                            <i class="la la-laptop"></i> 유선/인터넷 특판
                        </div>
                    </li>
                    <li onclick="location.href='/lifeMachineBoard'">
                        <div>
                            <i class="la la-television"></i> 생활 가전 특판
                        </div>
                    </li>
                    <li onclick="location.href='/eventBoard'">
                        <div>
                            <i class="la la-bullhorn"></i> 이벤트 공지
                        </div>
                    </li>
                    <li onclick="location.href='/company'">
                        <div>
                            <i class="la la-building"></i> 회사소개
                        </div>
                    </li>
                    <li class="has-sub">
                        <div class="tt">
                            <i class="la la-cog"></i> 설정
                        </div>
                        <ul>
                            <li onclick="location.href='/mypage'">
                                내 정보 수정
                            </li>
                            <li onclick="location.href='/alarm'">
                                알림수신 설정
                            </li>
                            <li onclick="location.href='/logout'">
                                로그아웃
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!--#cssmenu-->
        </div>
        <!--//ltnav_inner-->
    </div>
    <!--ltnav-->

    <div id="content">
        <div id="ltnav_mask"></div>
        <div id="table-fixed">
