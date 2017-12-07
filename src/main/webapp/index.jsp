<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
.black_overlay {
	display: none;
	position: fixed;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
	background-color: black;
	z-index: 1001;
	-moz-opacity: 0.8;
	opacity: .80;
	filter: alpha(opacity = 88);
}

.white_content {
	display: none;
	position: fixed;
	top: 25%;
	left: 25%;
	width: 55%;
	height: 55%;
	padding: 20px;
	border: 1px solid #ebeaea;
	background-color: silver;
	z-index: 1002;
	overflow: auto;
}

.Test_Paper_xNew_Ttwo {
	margin-top: 0px;
}

test-paper.css: 88
.Test_Paper_xNew_Ttwo {
	background: #29bdb9;
}

test-paper.css: 83
.Test_Paper_xNew_Tone, .Test_Paper_xNew_Ttwo {
	width: 230px;
	height: 120px;
	text-align: center;
	float: left;
	margin-top: 39px;
	cursor: pointer;
}

main.css: 444
.Test_Paper_xNew_Ttwo {
	background: #29bdb9;
}

main.css: 439
.Test_Paper_xNew_Tone, .Test_Paper_xNew_Ttwo {
	width: 230px;
	height: 120px;
	text-align: center;
	float: left;
	margin-top: 39px;
	cursor: pointer;
}

.cxdialog {
    position: fixed;
    top: 50%;
    left: 50%;
    overflow: hidden;
    min-width: 240px;
    margin: 0;
    padding: 0;
    border: none;
    border-radius: 0px;
    background: #fff;
    color: #333;
    font-family: Arial,'\5fae\8f6f\96c5\9ed1';
    z-index: 888;
    _position: absolute;
    _width: 360px;
    _height: 140px;
    border: 5px solid rgba(0,0,0,0.3);
}
</style>
</head>
<body>
	<input type="button" onclick="_pp()" value="弹框">




	<input type="button" onclick="_tc()" value="弹窗">

	<!--  
    <div  style="padding-bottom: 10px;">
		<div  style="margin-left: 24px;">
			<b class="start"> * </b>&nbsp;  试卷名称：<input placeholder="例如“软件开发类（Java）试卷”必填"> <span
				style="font-size: 12px; color: #999999; margin-left: 4px;">此项显示给考生</span>
		</div>
		<div class="A_N_P_name2" style="margin-left: 40px;">
			试卷备注： <input
				class="input paperTip ng-pristine ng-valid ng-valid-maxlength ng-touched"
				type="search" ng-model="paperModel.afterTitle"
				placeholder="例如：华北区使用，可不填" maxlength="30"
				style="color: rgb(51, 51, 51);">
		</div>
		
	<div>
		<a class="btn_ok" rel="cxdialog" rev="btn_ok">提交</a>
	</div>
	
      -->

	<div>
		<div id="light" class="white_content">
			<a style="float: right;" href="javascript:void(0)"
				onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">取消回复?</a>
			<a href="javascript:;" class="btn" onclick="saveReply()">发送回复</a>
			<div class="content4" contenteditable="true" id="rcontent" title=""></div>
		
		
		
		</div>
		
		
		
	</div>
		
	<div id="fade" class="black_overlay">
	
		
	
	</div>

</body>
<script type="text/javascript">
	function _pp() {
		var msg = "你还未登录，是否登录?\n\n请确认！";
		if (confirm(msg) == true) {
			location.href = "${pageContext.request.contextPath}/user/login.do";
		} else {
			location.href = "${pageContext.request.contextPath}/user/login.do";
		}
	}

	function _tc() {
		document.getElementById("light").style.display = "block";
		document.getElementById("fade").style.display = "block";
	}
</script>
</html>
