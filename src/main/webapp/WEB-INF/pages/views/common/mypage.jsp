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
        <span><a href="#">설정</a></span> &gt; <strong>회원정정보 수정</strong>
    </div>
</div>

<div id="content_inner">

    <div class="joinList subSec">
        <div class="urlInfo">
            <div class="centerThis">
                <div class="popTt mgt0">
                    <h2>회원정보</h2>
                </div>
                <dl class="td_box">
                    <dd class="td_dd">
                        <div class="td_tt">
                            아이디(이메일)
                        </div>
                        <div class="td_memo">
                            mobile@abc.co.kr
                        </div>
                    </dd>
                </dl>
                <dl>
                    <dd>
                        <input type="password" placeholder="비밀번호 입력" class="int">
                    </dd>
                    <p class="dd_info">
                        <i class="la la-info-circle"></i> 영문,숫자,특수문자 2가지 이상 6~12자리내
                    </p>
                    <dd>
                        <input type="email" placeholder="비밀번호 확인" class="int">
                    </dd>
                    <dd class="td_dd">
                        <div class="td_text">
                            <input type="text" placeholder="이름" class="int">
                        </div>
                        <div class="td_btn">
                            <a href="#">본인인증</a>
                        </div>
                    </dd>
                    <dd>
                        <input type="tel" placeholder="휴대폰번호" class="int">
                    </dd>
                </dl>
                <div class="popTt">
                    <h2>회원구분 정보</h2>
                </div>
                <dl class="td_box">
                    <dd class="td_dd">
                        <div class="td_tt">
                            회원종류
                        </div>
                        <div class="td_memo">
                            B2B제휴업체
                        </div>
                    </dd>
                    <dd class="td_dd">
                        <div class="td_tt">
                            업체명
                        </div>
                        <div class="td_memo">
                            오투아이 주식회사
                        </div>
                    </dd>
                </dl>
            </div>
        </div>
        <!--//urlInfo-->
        <div class="btnArea">
            <div class="centerThis group">
                <a href="join_select2.php" class="btn_global fl wSmall">회원탈퇴</a>
                <a href="login.php" class="btn_global bblue fr wBig">회원정보수정</a>
            </div>
        </div>
        <!--//btnArea-->

    </div>
    <!--//subList-->

</div>
<!--//#content_inner-->

<%--<?--%>
<%--include "include/footer.php";--%>
<%--?>--%>
<%@ include file="../include/footer.jsp"%>