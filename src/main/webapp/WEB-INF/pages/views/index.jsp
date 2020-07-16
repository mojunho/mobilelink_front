<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%--<?--%>
<%--include "include/header.php";--%>
<%--?>--%>
<%@ include file="./include/header.jsp"%>

<%--<?--%>
<%--include "include/header_main.php";--%>
<%--?>--%>
<%@ include file="./include/header_main.jsp"%>

<div id="content_inner">

    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="${pageContext.request.contextPath}/resources/images/main.jpg">
            </div>
            <div class="item">
                <img src="${pageContext.request.contextPath}/resources/images/main2.jpg">
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span class="sr-only">Previous</span> </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span class="sr-only">Next</span> </a>
    </div>
    <!--//carousel-example-generic-->

    <div class="mSecBox">
        <div class="centerThis">
            <div class="mSec">
                <div class="mTt m01">
                    <h2><strong>모바일</strong> 임직원 특판</h2>
                </div>
                <ul class="mTb">
                    <li>
                        <div class="top">
                            <em>SKT</em>
                            <p>
                                <img src="${pageContext.request.contextPath}/resources/images/link.jpg">
                            </p>
                        </div>
                        <div class="bot">
                            <a href="#"><span aria-hidden="true" class="icon-magnifier"></span> 자세히보기</a>
                        </div>
                    </li>
                    <li>
                        <div class="top">
                            <em>KT</em>
                            <p>
                                <img src="${pageContext.request.contextPath}/resources/images/link2.jpg">
                            </p>
                        </div>
                        <div class="bot">
                            <a href="#"><span aria-hidden="true" class="icon-magnifier"></span> 자세히보기</a>
                        </div>
                    </li>
                    <li>
                        <div class="top">
                            <em>LGT</em>
                            <p>
                                <img src="${pageContext.request.contextPath}/resources/images/link3.jpg">
                            </p>
                        </div>
                        <div class="bot">
                            <a href="#"><span aria-hidden="true" class="icon-magnifier"></span> 자세히보기</a>
                        </div>
                    </li>
                </ul>
            </div>
            <!--//mSec-->

            <div class="mButton">
                <ul>
                    <li class="li01">
                        <a href="#"> <h2>유선/인터넷 특판</h2> <label>바로가기<i class="la la-arrow-right"></i></label> </a>
                    </li>
                    <li class="li02">
                        <a href="#"> <h2>생활가전 특판</h2> <label>바로가기<i class="la la-arrow-right"></i></label> </a>
                    </li>
                    <li class="li03">
                        <a href="#"> <h2>이벤트 공지</h2> <label>바로가기<i class="la la-arrow-right"></i></label> </a>
                    </li>
                </ul>
            </div>
            <!--//mButton-->

            <div class="mLink">
                <dl>
                    <dt>
                        <h2>문의전화</h2>
                    </dt>
                    <dd>
                        <strong>02-1234-5678</strong>
                        <p>평일 09:00 ~ 18:00, 점심 12:00 ~ 13:00 / 주말,공휴일 휴무</p>
                    </dd>
                </dl>
            </div>
            <!--//mLink-->
        </div>
        <!--//centerThis-->
    </div>
    <!--//mSecBox-->

</div>
<!--//#content_inner-->

<%--<?--%>
<%--include "include/footer.php";--%>
<%--?>--%>
<%@ include file="./include/footer.jsp"%>
