<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--<tiles:insertAttribute name="header"/>--%>
<%@ include file="./include/header.jsp"%>
<div id="content_inner" class="login_wrap">
    <div class="centerThis">
        <h1 class="images login_logo"><img src="${pageContext.request.contextPath}/resources/images/logo.png"></h1>
        <div class="login_inputBox">
            <div class="input_row">
                <input type="text" class="int input_login" placeholder="아이디(이메일) 입력">
            </div>
            <div class="input_row">
                <input type="password" class="int input_login" placeholder="비밀번호">
            </div>
        </div>
        <div class="id_save group">
            <p>
                <label class="labelBox">자동로그인
                    <input type="checkbox" checked="checked">
                    <span class="checkmark"></span> </label>

                <!--<label class="labelBox">자동로그인
                <input type="radio" name="radio">
                <span class="radiobtn"></span> </label>-->

            </p>
        </div>
        <div class="loginArea group">
            <a href="index" class="btn_global bblue">로그인</a>
        </div>

        <ul class="loginLink">
            <li>
                <a href="id">
                    <p>
                        <em><i class="la la-envelope"></i></em>
                    </p> 아이디찾기 </a>
            </li>
            <li>
                <a href="pw">
                    <p>
                        <em><i class="la la-unlock"></i></em>
                    </p> 비밀번호찾기 </a>
            </li>
            <li>
                <a href="join">
                    <p>
                        <em><i class="la la-pencil-square"></i></em>
                    </p> 회원가입 </a>
            </li>
        </ul>
    </div>

</div>
<!--//#content_inner-->
<div id="footer2">
    <p>
        Copyright(c) Samsung M&S inc. All rights reserved
    </p>
</div>
<!--//#footer-->
<%--<tiles:insertAttribute name="footer2"/>--%>
<%@ include file="./include/footer2.jsp"%>