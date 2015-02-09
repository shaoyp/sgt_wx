<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>私人定制</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- <link rel="stylesheet/less" type="text/css" href="less/privateView.less">
<link rel="stylesheet/less" type="text/css" href="less/main.less"> -->
<link href="css/privateView.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet"> 
</head>
<body>
	<form action="priorderOrder.action" method="post" id="private_form">
	 <div class="private_div " style="" >
		<div class="private_title">
	 		<font class="font_orange_title">私人定制</font>
	 	</div>
	 	<div class="private_content">
	 	<input name="openid" type="text" value="<s:property value="openid"/>">
	 	<textarea class="font_textarea_content" id="private_textarea" name="priContent" >请输入您的信息</textarea>
	 	</div>
	 	<div class="private_submit" style="">
	 		<img class="private_img right" id="private_img" alt="" src="images/common/submit.jpg">
	 		<div class="left"></div>
	 	</div>
	 </div>
	 </form>
	<script src="js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="js/less.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(function(){
			//私人定制点击
			$("#private_img").click(function(){
				$("#private_form").submit();
			});
			//按钮样式
			$("#private_img").hover(function(){
				$(this).attr("src","images/common/submit-c.png");
			},function(){
				$(this).attr("src","images/common/submit.jpg");
			});
			//获取焦点
		   $("#private_textarea").focus(function cls() {
		       var private_content = $(this).val();
			   if (private_content == "请输入您的信息"){
				   $(this).val("");
			   } 
		    });
		    
			
			
		});
	</script>
</body>
</html>
