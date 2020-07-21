<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%--<?--%>
<%--include "include/header.html";--%>
<%--?>--%>
<%@ include file="../include/header.jsp"%>

<%--<?--%>
<%--include "include/header_main.html";--%>
<%--?>--%>
<%@ include file="../include/header_main.jsp"%>

<div class="location">
    <div class="centerThis">
        <span><a href="#">설정</a></span> &gt; <strong>알림수신설정</strong>
    </div>
</div>

<div id="content_inner">

    <div class="subSec">
        <div class="centerThis">
            <div class="popTt">
                <h2>알림수신설정</h2>
            </div>
        </div>
        <table class="opList">
            <tbody>
            <tr>
                <th>모바일링크에서 보내는 알림 설정 </th>
                <td ><label class="switch">
                    <input type="checkbox" checked="">
                    <span class="check_slider round"></span> </label></td>
            </tr>
            </tbody>
        </table>
    </div>
    <!--//subList-->

</div>
<!--//#content_inner-->

<%--<?--%>
<%--include "include/footer.html";--%>
<%--?>--%>
<%@ include file="../include/footer.jsp"%>