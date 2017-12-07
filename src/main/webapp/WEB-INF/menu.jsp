<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>智能专项练习_C++Java前端经典笔试面试题库_牛客网</title>
<meta name="description" content="牛客网是IT求职神器,提供C++、JAVA、前端各知识点笔试题库,能过能力鉴定模型智能推荐专项突击练习，在线进行百度阿里腾讯网易等互联网名企笔试面试模拟考试练习,和牛人一起讨论经典试题,全面提升你的编程能力">
<meta name="keywords" content="牛客网, C++笔试面试，Java笔试面试，前端笔试面试，计算机笔试,计算机面试, IT笔试,笔试题库,笔试练习,IT面试,在线编程,编程学习,牛客网">
<link rel="stylesheet" href="${pageContext.request.contextPath}/menu/ncfontcustom.css">
<link rel="shortcut icon" href="http://kao.acmcoder.com/images/acm.ico" type="image/x-icon">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js-css-image/all-exam.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js-css-image/login.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js-css-image/comp-enterprise.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/menu/specialExercise.css">
<script charset="utf-8" async="" src="${pageContext.request.contextPath}/menu/intelligent.js.下载"></script></head>
<body>
<div class="nk-container     ">
<div class="nowcoder-header">


<div class="header-main clearfix">
<ul class="nowcoder-navbar nowcoder-other-nav">
<li class="nav-search">
<a href="javascript:void(0);" class="icon-search js-search-btn">搜索</a>
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
<a href="https://www.nowcoder.com/app" class="icon-mobile-phone">APP</a>
</li>
<li class="nav-msg">
<a class="icon-envelope" href="https://www.nowcoder.com/sns/message/9850868/conversation-list?" data-unread-conv="">消息</a>
</li>
<li class="profile-item">
<a href="https://www.nowcoder.com/profile" class="nav-profile">
<div class="img-box"><img src="${pageContext.request.contextPath}/menu/9850868_1510818706550_8CDBA9EE661A85F428FE11CECA540264@0e_100w_100h_0c_1i_1o_90Q_1x"></div>
</a>
<ul class="sub-nav">
<li><a href="https://www.nowcoder.com/profile" class="nav-profile-page">个人主页</a></li>
<li><a href="https://www.nowcoder.com/profile/9850868/account" class="nav-set">帐号设置</a></li>
<li><a href="https://www.nowcoder.com/profile/9850868/resume" class="icon-resume">我的简历</a></li>
<li><a href="javascript:void(0);" class="nav-out nc-logout">退出登录</a></li>
</ul>
</li>
</ul>
</div>
</div>
<div class="test-tab-wrap">
<div class="test-tab-cont clearfix">
<ul class="test-tab clearfix">
<li>
<a href="https://www.nowcoder.com/contestRoom">公司真题模考</a>
</li>
<li class="selected">
<a href="https://www.nowcoder.com/intelligentTest">智能专项练习</a>
</li>
<li>
<a href="https://www.nowcoder.com/activity/oj">在线编程</a>
</li>
<li>
<a href="https://www.nowcoder.com/kaoyan">考研真题</a>
</li>
<li>
<a href="https://www.nowcoder.com/finalexam">期末考题</a>
</li>
<li>
<a href="https://www.nowcoder.com/activity/topics">精华专题</a>
</li>
<li>
<a href="https://www.nowcoder.com/questionCenter">试题广场</a>
</li>
</ul>
<div class="new-subject-upload nc-req-auth">
<a href="https://www.nowcoder.com/userquestion/v4/new"><i class="icon-cloud-upload"></i>新题上传</a>
</div>
</div>
</div>
<div class="nk-main test-center-page clearfix">
<div class="mini-banner">
</div>
<div class="module-box">
<div class="module-head">
<h1>笔试练习</h1>
</div>
<form action="${pageContext.request.contextPath}/findQuestionsByCondition.do" method="post">
<div class="module-body">
  <div class="pop-interest-box horizontal-mod clearfix" id="jsTagContainer">
   <dl class="pop-interest-type">
    <dt class="pop-interest-head">
     <label class="checkbox nc-req-auth js-tag-all"><input type="checkbox" onchange="_allSelect();" >全选</label>
     <h2>练习阶段</h2>
    </dt>
    	<c:forEach items="${labelList}" var="label">
	    <dd class="pop-interest-info nc-req-auth js-tag-item" data-id="569">
	     <dd class="pop-interest-info nc-req-auth js-tag-item" data-id="569">
  			<input type="checkbox" name="labels" class="checkbox" value="${label.lid}">
	      <div class="pop-interest-tit" title="${label.label}">
	       		${label.label}
	      </div>
	      
	      </label>
	     <div class="data-progress-bg">
	      <div class="data-progress-bar red-bar" style="width:0.4185851820845542%;"></div>
	     </div>
	     <span class="data-progress-txt">10/2389</span>
	    </dd>
	    </c:forEach>
   </dl>
  </div> 
<div class="difficulty">
<span class="item-label">调整难度系数：</span>
<span title="难度系数"  id="jsDifficulty"></span>
<!-- <label class="radio js-source-radio" id="jsCpn_6_checkbox_4">
<span class="icons"></span>
<input type="radio"   name="rank" value="1">
简单
</label>
<label class="radio js-source-radio checked" id="jsCpn_7_checkbox_5">
<span class="icons"></span>
<input type="radio"  name="rank" value="2">
普通
</label>
<label class="radio js-source-radio" id="jsCpn_8_checkbox_6">
<span class="icons"></span>
<input type="radio"  name="rank" value="3">
困难
</label> -->
<span class="icons"></span>
<input type="radio"   name="rank" value="1" class="radio js-source-radio" id="jsCpn_7_checkbox_5">
<font size="3">简单</font>
<span class="icons"></span>
<input type="radio"   name="rank" value="2" class="radio js-source-radio" id="jsCpn_7_checkbox_5">
<font size="3">普通</font>
<span class="icons"></span>
<input type="radio"   name="rank" value="3" class="radio js-source-radio" id="jsCpn_7_checkbox_5">
<font size="3">困难</font>



</div>
<div class="choise-items" style="display: block;" id="jsCountChk">
<span class="item-label">选择题目类型：</span>

<span class="icons"></span>
<input type="checkbox"   name="types" value="1" class="radio js-source-radio" id="jsCpn_7_checkbox_5">
<font size="3">单选题</font>
<span class="icons"></span>
<input type="checkbox"   name="types" value="2" class="radio js-source-radio" id="jsCpn_7_checkbox_5">
<font size="3">多选题</font>
<span class="icons"></span>
<input type="checkbox"   name="types" value="3" class="radio js-source-radio" id="jsCpn_7_checkbox_5">
<font size="3">填空题</font>
<input type="checkbox"   name="types" value="4" class="radio js-source-radio" id="jsCpn_7_checkbox_5">
<font size="3">问答题</font>

<!-- <label class="radio" id="jsCpn_2_checkbox_0">
<span class="icons"></span>
<input type="radio"  name="num"  value="5">
5题
</label>
<label class="radio checked" id="jsCpn_3_checkbox_1">
<span class="icons"></span>
<input type="radio"  name="num"  value="10" >
10题
</label>
<label class="radio" id="jsCpn_4_checkbox_2">
<span class="icons"></span>
<input type="radio" name="num"  value="20">
20题
</label>
<label class="radio" id="jsCpn_5_checkbox_3">
<span class="icons"></span>
<input type="radio"    name="num"  value="30">
30题
</label>
</div> -->
<div class="special-oprt-bar clearfix">
<div class="special-oprt-txt">
已选择：<span id="jsTagsShow">Java</span><span id="jsDifficultyShow"> | 三星难度 | 10题</span>
</div>
<div class="special-oprt-btn">
<a href="javascript:void(0);" class="btn btn-default nc-req-auth" id="jsReSelect">重选</a>
<button class="btn btn-primary" type="submit" id="jsGoPractice">确定</button>
<input type="hidden" name="token" value="">
</form>
</div>
</div>
</div>
</div>
</div>
<div class="fixed-menu" style="display: block; bottom: 117px;">
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
<img src="${pageContext.request.contextPath}/menu/wx-rcode.jpg" alt="二维码">
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
<img src="${pageContext.request.contextPath}/menu/app.png" alt="二维码">
<p>下载牛客APP，随时随地刷题</p>
</div>
</li>
</ul>
<div class="phone-qrcode" style="">
<a href="javascript:void(0);" class="qrcode-close">x</a>
<img src="${pageContext.request.contextPath}/menu/app.png" alt="二维码" style="width:70px;height:70px;">
<p>扫一扫下载牛客APP</p>
</div>
</div>




</div>
<div class="footer" float="left"><div class="public"><div class="footer-left"><div class="footer-logo"><img src="${pageContext.request.contextPath}/js-css-image/blogo.png" style="position: relative;top: -3px;"></div><div class="footer-txt"><a target="_blank" href="http://www.acmcoder.com/aboutus/about.html">关于我们</a>　|　<a target="_blank" href="http://www.acmcoder.com/aboutus/contact.html">联系我们</a>　|　<a target="_blank" href="http://www.acmcoder.com/aboutus/shengming.html">免责声明</a><br>Copyright © acmcoder.com<br>All Rights Reversed 京ICP备15012255-1</div></div><div class="footer-right"><table><tbody><tr><td><img src="${pageContext.request.contextPath}/js-css-image/f-phone.png"></td><td style="font-size: 14px;">客服热线：010-85359782<br>销售热线：010-85359766</td><td style="font-size: 14px;"><a class="weixinPng" href="javascript:void(0)" style="color:white;position: relative;"><img src="${pageContext.request.contextPath}/js-css-image/f-weixin.png"> &nbsp;&nbsp;iamacmcoder<img class="hide" style="width: 80px;position: absolute;left: 130px;top: -50px;" src="${pageContext.request.contextPath}/js-css-image/saimaweixin.jpg"></a><br><a href="javascript:void(0)" style="color:white"><img src="${pageContext.request.contextPath}/js-css-image/f-qq.png"> &nbsp;&nbsp;2531743633</a><br></td></tr></tbody></table></div></div></div><div class="topW" style="display: none; right: 351px;"><span></span></div></form></body></html>
		<script src="${pageContext.request.contextPath}/js-css-image/footer-exam.js.aaa"></script>
<script src="${pageContext.request.contextPath}/menu/hm.js.下载"></script><script>
window.isLogin = true;
window.globalInfo = {
ownerId: '9850868',
ownerName: 'LUYAOW',
ownerTinyHead: 'https://images.nowcoder.com/images/20171116/9850868_1510818706550_8CDBA9EE661A85F428FE11CECA540264@0e_100w_100h_0c_1i_1o_90Q_1x',
ownerMainHead: 'https://images.nowcoder.com/images/20171116/9850868_1510818706550_8CDBA9EE661A85F428FE11CECA540264@0e_200w_200h_0c_1i_1o_90Q_1x',
ownerEmail: '',
ownerPhone: '13623445437',
ownerType: '1',
status: '0',
honorLevel: '1',
gender: '',
isCompleteInfo: true,
canLoadInIframe: 'false'
};
window.useNeteaseCaptcha = true;
</script>
<script type="text/javascript">
window.ncDeployImageRoot = "//static.nowcoder.com/";
window.ncJsVersion = "1.02.10";
window.ncJsPluginVersion = "1.0.11";
</script>
<script src="${pageContext.request.contextPath}/menu/sea.js.下载" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/menu/nc.cpn.js.下载" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/menu/base.js.下载" type="text/javascript"></script>
<script type="text/javascript">
if (!window.seajs) {
var oBody = document.body;
var aChild = oBody.childNodes;
seajs.use('nowcoder/1.2.900/javascripts/site/common/nav');
</script><div id="jsCpn_1_component_0" style="display:none;"><div id="jsCpn_0_component_0" class="  btn-group" style="display: block; min-width: 297px;"><ul class="dropdown-menu js-menu" style="position:static;float:none;border-bottom:0;overflow-x:hidden;"></ul></div></div>
<script>
var _hmt = _hmt || [];
(function() {
var hm = document.createElement("script");
hm.src = "//hm.baidu.com/hm.js?a808a1326b6c06c437de769d1b85b870";
var s = document.getElementsByTagName("script")[0];
s.parentNode.insertBefore(hm, s);
})();

function _allSelect(){
	var qids=document.getElementsByName("labels");
	for(var i=0;i<qids.length;i++){
		if(qids[i].checked){
		qids[i].checked=false;
		}else{
		qids[i].checked=true;
		}
	}
}

</script>
<script type="text/javascript">
window.tags = [{"title":"编程语言","items":[{"tcount":2389,"rcount":10,"leftcount":2387,"id":569,"title":"C/C++"},{"tcount":938,"rcount":1,"leftcount":938,"id":570,"title":"Java"},{"tcount":186,"rcount":0,"leftcount":186,"id":571,"title":"Javascript"},{"tcount":30,"rcount":0,"leftcount":30,"id":572,"title":"C#"},{"tcount":218,"rcount":0,"leftcount":218,"id":574,"title":"HTML/CSS"},{"tcount":5,"rcount":0,"leftcount":5,"id":573,"title":"Python"},{"tcount":114,"rcount":0,"leftcount":114,"id":575,"title":"PHP"}]},{"title":"算法","items":[{"tcount":162,"rcount":0,"leftcount":162,"id":589,"title":"查找"},{"tcount":399,"rcount":0,"leftcount":399,"id":590,"title":"排序"},{"tcount":32,"rcount":0,"leftcount":32,"id":591,"title":"递归"},{"tcount":243,"rcount":0,"leftcount":243,"id":597,"title":"复杂度"},{"tcount":67,"rcount":0,"leftcount":67,"id":598,"title":"高级算法"}]},{"title":"数据结构","items":[{"tcount":304,"rcount":0,"leftcount":304,"id":578,"title":"数组"},{"tcount":80,"rcount":0,"leftcount":80,"id":579,"title":"字符串"},{"tcount":347,"rcount":0,"leftcount":347,"id":580,"title":"链表"},{"tcount":303,"rcount":0,"leftcount":303,"id":581,"title":"栈"},{"tcount":171,"rcount":0,"leftcount":171,"id":582,"title":"队列"},{"tcount":737,"rcount":0,"leftcount":737,"id":583,"title":"树"},{"tcount":341,"rcount":0,"leftcount":341,"id":584,"title":"图"},{"tcount":88,"rcount":0,"leftcount":88,"id":585,"title":"哈希"},{"tcount":61,"rcount":0,"leftcount":61,"id":586,"title":"堆"}]},{"title":"数学和逻辑","items":[{"tcount":160,"rcount":0,"leftcount":160,"id":600,"title":"组合数学"},{"tcount":153,"rcount":0,"leftcount":153,"id":601,"title":"概率统计"},{"tcount":618,"rcount":0,"leftcount":618,"id":602,"title":"智力题"}]},{"title":"计算机基础","items":[{"tcount":2760,"rcount":0,"leftcount":2760,"id":604,"title":"网络基础"},{"tcount":1875,"rcount":0,"leftcount":1875,"id":606,"title":"数据库"},{"tcount":1613,"rcount":0,"leftcount":1613,"id":607,"title":"操作系统"},{"tcount":43,"rcount":0,"leftcount":43,"id":608,"title":"加密和安全"},{"tcount":1051,"rcount":0,"leftcount":1051,"id":609,"title":"编程基础"},{"tcount":1246,"rcount":2,"leftcount":1246,"id":610,"title":"编译和体系结构"}]},{"title":"软件开发","items":[{"tcount":673,"rcount":0,"leftcount":673,"id":612,"title":"软件工程"},{"tcount":99,"rcount":0,"leftcount":99,"id":613,"title":"软件测试"},{"tcount":322,"rcount":1,"leftcount":322,"id":618,"title":"Linux"},{"tcount":153,"rcount":0,"leftcount":153,"id":620,"title":"Windows"},{"tcount":39,"rcount":0,"leftcount":39,"id":630,"title":"数理统计"},{"tcount":54,"rcount":0,"leftcount":54,"id":631,"title":"机器学习"},{"tcount":46,"rcount":0,"leftcount":46,"id":636,"title":"并发"},{"tcount":24,"rcount":0,"leftcount":24,"id":637,"title":"Spring"},{"tcount":95,"rcount":0,"leftcount":95,"id":616,"title":"iOS"},{"tcount":129,"rcount":0,"leftcount":129,"id":617,"title":"Android"}]}];
seajs.use('nowcoder/1.2.900/javascripts/site/contest/intelligent');
</script>

</body>


</html>