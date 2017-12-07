<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>智能专项练习</title>
<link rel="stylesheet" href="question/ncfontcustom.css">
<link rel="stylesheet" href="question/exercise.css">
<link charset="utf-8" rel="stylesheet" href="question/shCoreDefault.css">
		<link rel="shortcut icon" href="http://kao.acmcoder.com/images/acm.ico" type="image/x-icon">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js-css-image/all-exam.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js-css-image/login.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js-css-image/comp-enterprise.css">
	
<%-- <script type="text/javascript" src="${pageContext.request.ContextPath}/js/jquery-3.2.1.min.js"></script>
 --%>
</head>
<body>
<div class="nk-container      with-validate ">
<div class="nowcoder-header">
<div class="header-main clearfix">
<!-- <a class="nowcoder-logo" href="https://www.nowcoder.com/" title="牛客网"></a> -->
<!-- <ul class="nowcoder-navbar">
<li>
<a href="https://www.nowcoder.com/">首页</a>
</li>
<li>
<a href="https://www.nowcoder.com/contestRoom">题库</a>
<ul class="sub-nav">
<li><a href="https://www.nowcoder.com/contestRoom">公司真题</a></li>
<li><a href="https://www.nowcoder.com/intelligentTest">专项练习</a></li>
<li><a href="https://www.nowcoder.com/activity/oj">在线编程</a></li>
<li><a href="https://www.nowcoder.com/kaoyan">考研真题</a></li>
<li><a href="https://www.nowcoder.com/finalexam">期末考题</a></li>
<li><a href="https://www.nowcoder.com/activity/topics">精华专题</a></li>
<li><a href="https://www.nowcoder.com/questionCenter">试题广场</a></li>
</ul>
</li>
<li>
<a href="https://www.nowcoder.com/courses">课程</a>
</li>
<li>
<span class="ico-nav-new"></span>
<a href="https://www.nowcoder.com/recommend">求职</a>
</li>
<li>
<a href="https://www.nowcoder.com/discuss">讨论区</a>
</li>
<li>
<a href="https://www.nowcoder.com/acm/contest/vip-contest-index">发现</a>
<ul class="sub-nav">
<li><a href="https://www.nowcoder.com/acm/contest/vip-contest-index">竞赛</a></li>
<li><a href="https://www.nowcoder.com/ranking">排行榜</a></li>
</ul>
</li>
</ul> -->
<ul class="nowcoder-navbar nowcoder-other-nav">
<li class="nav-search">
<!-- <a href="javascript:void(0);" class="icon-search js-search-btn">搜索</a> -->
<div class="newnav-search-wrap">
<div class="newnav-search-cont">
<form method="get" action="https://www.nowcoder.com/search">
<input class="nav-search-txt" name="query" type="text" autocomplete="off">
<input type="hidden" name="type" value="all">
<input type="submit" class="nk-invisible">
<a href="javascript:void(0);" class="icon-search-colse js-close-search-btn"></a>
<input type="hidden" name="token" value=""></form>
</div>
</div>
</li><li>
<!-- <a href="https://www.nowcoder.com/app" class="icon-mobile-phone">APP</a> -->
</li>
<li class="nav-msg">
<!-- <a class="icon-envelope" href="https://www.nowcoder.com/sns/message/9653742/conversation-list?type=1" data-unread-conv=""><span class="nav-msg-num">6</span>消息</a> -->
</li>
<li class="profile-item">
<a href="https://www.nowcoder.com/profile" class="nav-profile">
<div class="img-box"><img src="./输入流将数据从文件，标准输入或其他外部输入设备中加载道内存，在 java 中其对应于抽象类（）及其子类。_Java专项练习_牛客网_files/0m.png@0e_100w_100h_0c_1i_1o_90Q_1x.png"></div>
</a>
<ul class="sub-nav">
<li><a href="https://www.nowcoder.com/profile" class="nav-profile-page">个人主页</a></li>
<li><a href="https://www.nowcoder.com/profile/9653742/account" class="nav-set">帐号设置</a></li>
<li><a href="https://www.nowcoder.com/profile/9653742/resume" class="icon-resume">我的简历</a></li>
<li><a href="javascript:void(0);" class="nav-out nc-logout">退出登录</a></li>
</ul>
</li>
</ul>
</div>
</div>
<div class="nk-main  clearfix">
<div class="module-box subject-box">
<div class="nowcoder-topic">
<div class="subject-progress">
</div>
<form action="${pageContext.request.contextPath}/handInPaper.do" method="post">
<div class="subject-title">[选择题]</div>
<div class="subject-main">
<div class="subject-content">
<div class="subject-question">
<p style="margin-left: 0.0cm;text-indent: 0.0cm;">
<% 

	Integer id=(Integer)session.getAttribute("index");
	Integer length=(Integer)session.getAttribute("length");
	
	if(id==null){
	session.setAttribute("index",1);
	}else{
			id++;
		if(id>length){
			session.removeAttribute("index");
		}else{
			session.setAttribute("index",id);
		}
			
	}
	
%><%-- <c:if test="${last==l.id}">
	<input type="button" value="交卷">
</c:if> --%>

  <c:forEach items="${list}" var="l"  varStatus="vs">
  		<c:if test="${vs.count==index}">
  			<span>${l.title}</span>
  		</c:if>
		<c:if test="${vs.count==index}">
		<label class="radio" id="jsCpn_2_checkbox_0">
		<pre>
			<c:if test="${l.type==1}">
				<c:forEach items="${l.ops}" var="op" varStatus="i">
					<input type="radio" name="answers" value="${i.count}">&nbsp;&nbsp;&nbsp;&nbsp;<span>${op}</span>
				</c:forEach>
			</c:if>
			<c:if test="${l.type==3}">
				<c:forEach items="${l.ops}" var="op" varStatus="i">
				<input type="checkbox" name="answers" value="${i.count }">&nbsp;&nbsp;&nbsp;&nbsp;<span>${op}</span>
				</c:forEach>
			</c:if>
			<c:if test="${l.type==4}">
				<textarea rows="15" cols="50" name="answer">
				 	请在此作答
				</textarea>
			</c:if>
		</pre>
		</label>
   </c:if>
  </c:forEach>		
  
</p>
</div>
</div>
<div class="subject-action clearfix">
<div class="subject-opr">
<span class="subject-opr-item"><i class="ico-collect"></i><a href="javascript:void(0);" class="js-follow nc-req-auth" data-id="56418">收藏本题</a></span>
<span class="subject-opr-item"><i class="ico-mark"></i><a href="javascript:void(0);" class="js-shield nc-req-auth" data-id="56418" data-title="屏蔽该题，该题将不会出现在以后的组卷中。" data-tips-index="1">屏蔽本题</a></span>
</div>
<div class="subject-next">
<form id="submitForm" method="post" action="https://www.nowcoder.com/question/next?pid=8227432&amp;qid=56418&amp;tid=12559772">
<input type="hidden" name="content" id="answer">
<input id="aheadFinish" type="submit" name="button" class="btn warning-btn" value="提前交卷">
<c:forEach items="${list}" var="l"  varStatus="vs">
	<c:if test="${length == index && vs.count==index}">
		<input type="submit"  class="btn btn-primary"    value="交卷" >
	</c:if>
	<c:if test="${index !=length && vs.count==index}">
	<input id="next" type="button" name="button" onclick="aaa()" class="btn btn-primary" value="下一题">
	</c:if>
<%-- 	<c:if test="${last != l.id}">
		
	</c:if>
	<c:if test="${last gt l.id}">
	<input id="next" type="button" name="button" onclick="aaa()" class="btn btn-primary" value="下一题">
	</c:if> --%>
</c:forEach>
</form>
<input type="hidden" name="token" value=""></form>
</div>
</div>
</div>

<script type="text/javascript">
	
	function aaa(){
	/* 	$.ajax({
  			url:"${pageContext.request.contextPath}/handInPaper.do",
  			type:"POST",
  			data:{
					answers:$("answers").val(),
				 },
  			success:function(msg){
  				alert(msg);
  			}
  		}); */
  		var  arr  = document.getElementsByName("answers");
  		var sth ='';
  		 for(var i=0;i<arr.length;i++){
  			if(arr[i].checked==true){
  				sth=sth+arr[i].value;
  			}
  		} 
  				 $.ajax({
  		  			url:"${pageContext.request.contextPath}/handInPaper.do",
  		  			type:"POST",
  		  			data:{
  							sth:sth,
  						 },
  		  			success:function(msg){
  		  			}
  		  		}); 
		window.location.reload();
	}
</script>
<!-- 展开的时候加class:open -->
<div class="answer-sheet-box open">
<a href="javascript:void(0)" class="card-unfold">展开答题卡</a>
<a href="javascript:void(0)" class="card-fold">收起答题卡</a>
<ul class="answer-sheet-num clearfix">
<li><a href="javascript:void(0);" class="answering-num" data-qid="56418">1</a></li>
<li><a href="javascript:void(0);" data-qid="15210">2</a></li>
<li><a href="javascript:void(0);" data-qid="25800">3</a></li>
<li><a href="javascript:void(0);" data-qid="57601">4</a></li>
<li><a href="javascript:void(0);" data-qid="50975">5</a></li>
</ul>
</div>
</div>
<input type="hidden" id="jsQuestionInfo" data-pid="8227432" data-tid="12559772" data-qid="56418" data-total="5" data-left="5">
</div>
<div class="fixed-menu">
<ul>
<li>
<a href="javascript:void(0);" class="gotop js-nav-go-top" title="回到顶部"></a>
</li>
<li>
<a class="fixed-wb" target="_blank" href="http://www.weibo.com/nowcoder"></a>
</li>
<li>
<a href="tencent://groupwpa/?subcmd=all&amp;param=7B2267726F757055696E223A3135373539343730352C2274696D655374616D70223A313431333130373737387D0A" class="qq" title="QQ"></a>
</li>
<li>
<a href="javascript:void(0);" class="wx"></a>
<div class="wx-qrcode">
<img src="question/wx-rcode.jpg" alt="二维码">
<p>扫描二维码，关注牛客网</p>
</div>
</li>
<li>
<a href="https://www.nowcoder.com/discuss/30" class="feedback" title="意见反馈"></a>
<a href="https://www.nowcoder.com/discuss/30" class="feedback-letter">意见反馈</a>
</li>
<li>
<a href="javascript:void(0);" class="qrcode"></a>
<div class="wx-qrcode">
<img src="question/app.png" alt="二维码">
<p>下载牛客APP，随时随地刷题</p>
</div>
</li>
</ul>
<div class="phone-qrcode" style="display:none;">
<a href="javascript:void(0);" class="qrcode-close">x</a>
<img src="question/app.png" alt="二维码" style="width:70px;height:70px;">
<p>扫一扫下载牛客APP</p>
</div>
</div>



<%-- <div class="footer" float="left" ><div class="public"><div class="footer-left"><div class="footer-logo"><img src="${pageContext.request.contextPath}/js-css-image/blogo.png" style="position: relative;top: -3px;"></div><div class="footer-txt"><a target="_blank" href="http://www.acmcoder.com/aboutus/about.html">关于我们</a>　|　<a target="_blank" href="http://www.acmcoder.com/aboutus/contact.html">联系我们</a>　|　<a target="_blank" href="http://www.acmcoder.com/aboutus/shengming.html">免责声明</a><br>Copyright © acmcoder.com<br>All Rights Reversed 京ICP备15012255-1</div></div><div class="footer-right"><table><tbody><tr><td><img src="${pageContext.request.contextPath}/js-css-image/f-phone.png"></td><td style="font-size: 14px;">客服热线：010-85359782<br>销售热线：010-85359766</td><td style="font-size: 14px;"><a class="weixinPng" href="javascript:void(0)" style="color:white;position: relative;"><img src="${pageContext.request.contextPath}/js-css-image/f-weixin.png"> &nbsp;&nbsp;iamacmcoder<img class="hide" style="width: 80px;position: absolute;left: 130px;top: -50px;" src="${pageContext.request.contextPath}/js-css-image/saimaweixin.jpg"></a><br><a href="javascript:void(0)" style="color:white"><img src="${pageContext.request.contextPath}/js-css-image/f-qq.png"> &nbsp;&nbsp;2531743633</a><br></td></tr></tbody></table></div></div></div><div class="topW" style="display: none; right: 351px;"><span></span></div></form></body></html>
 --%>

<script src="/js/jquery-3.2.1.min.js"></script>
<div class="ad-window-sm js-global-tips" style="display:none;">
<a href="javascript:void(0);" class="ad-close">X</a>
<div class="ad-live-active"></div>
<a class="link-green js-global-tips-href" target="_blank" href="https://www.nowcoder.com/test/question/21aec5a1d97c424aa0bad994317948b6?pid=8227432&amp;tid=12559772">点击查看&gt;&gt;</a>
</div><div id="jsCpn_1_component_0" style="display:none;"><div id="jsCpn_0_component_0" class="  btn-group" style="display: block; min-width: 297px;"><ul class="dropdown-menu js-menu" style="position:static;float:none;border-bottom:0;overflow-x:hidden;"></ul></div></div></body></html>