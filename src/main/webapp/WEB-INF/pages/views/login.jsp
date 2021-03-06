<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--<tiles:insertAttribute name="header"/>--%>
<%@ include file="./include/header.jsp"%>
<script>
    $(document).ready(function () {
        $('#login_btn').click(function () {
            var sendData = JSON.stringify({login:$('#login').val(),password:$('#password').val()});
            console.log(sendData);

            $.ajax({
               type: "POST",
               url: "/rest/loginProcess",
               data: sendData,
               dataType: "json",
               contentType: "application/json;charset=UTF-8",
               //async: true,
               success: function (result) {
                    //alert(result);
                    alert(result.msg);
                    $('#content_wrap').load('homeMain');
               },
               error: function (jqXHR, textStatus, errorThrown) {
                    //alert(jqXHR.responseText);
                   console.log(textStatus);
                   console.log(errorThrown);
                   console.log(jqXHR.responseText);
                    //console.log(data);
               }
            });
        });
    });
</script>
<div id="content_inner" class="login_wrap">
    <div class="centerThis">
        <form action="/homeMain" method="post">
            <h1 class="images login_logo"><img src="${pageContext.request.contextPath}/resources/images/logo.png"></h1>
            <div class="login_inputBox">
                <div class="input_row">
                    <input type="text" class="int input_login" placeholder="아이디(이메일) 입력" name="login" id="login">
                </div>
                <div class="input_row">
                    <input type="password" class="int input_login" placeholder="비밀번호" name="password" id="password">
                </div>
            </div>
            <div class="id_save group">
                <p>
                    <label class="labelBox">자동로그인
                        <input type="checkbox" checked="checked">
                        <span class="checkmark"></span>
                    </label>

                    <!--<label class="labelBox">자동로그인
                    <input type="radio" name="radio">
                    <span class="radiobtn"></span> </label>-->

                </p>
            </div>
            <div class="loginArea group">
                <button id="login_btn" type="button" class="btn_global bblue">로그인</button>
    <%--                <a href="homeMain" class="btn_global bblue">로그인</a>--%>
            </div>
        </form>
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