<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>我要“团”</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
 <link rel="stylesheet/less" type="text/css" href="less/groupView.less">
<link rel="stylesheet/less" type="text/css" href="less/main.less"> 
<!--<link href="css/groupView.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet"> -->

</head>
<body>
	 <div class="group_div " >
	 	<div class="group_window" style="">
	 		<img class="group_machine" alt="" src="images/group/machine.png"/>
	 		<div class="group_light"></div>
	 		<div class="group_title font_group_title">上岗通心率酒精检测仪|<s:property value="group.name" /></div>
	 	</div>
	 	<div class="group_price">
	 		<div class="group_price_div">
	 			<div class="group_price_left left">
	 				<font>&#65509;</font><font class="font_group_normalprice">6888|<s:property value="group.discount_private" /></font> 
	 			</div>
	 			<form action="groupOrder.action" method="post" id="group_order">
	 			<div class="group_price_right right">
	 				<img alt="" src="images/group/group.png"/>
	 			</div>
	 			<div class="group_price_num right">
	 				数量：<input name="num" style="width:20px;"/>
	 			</div>
	 				 <input type="hidden" name="openid" value="<s:property value="openid"/>"/>
	 				 <input type="hidden" name="price" value="<s:property value="group.discount_private" />"/>
	 			</form>
	 		</div>
	 		<div class="group_price_div">
	 			<div class="group_price_bottom">
	 				<font>原价 &nbsp;
	 					<font class="font_group_throughline"> &#65509;|<s:property value="group.price" /></font> 
	 					&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;节省  &nbsp;
	 					<font class="font_group_throughline">&#65509;|<s:property value="group.price - group.discount_private" /></font>
	 				</font>
	 			</div>
	 		</div>
	 	</div>
	 	<div class="group_num">
	 			<div class="group_num_top">
	 				<font class="font_group_normaltime"><font class="font_group_totalnum">|<s:property value="group.people_num" /></font>人已经购买&nbsp;数量有限，赶快下单吧！</font>
	 			</div>
	 			<div class="group_num_bottom">
	 				<font class="font_group_normaltime">
	 					<s:property value="group.dead_line" />剩余时间：<font class="font_group_deadtime">3</font>天
	 					<font class="font_group_deadtime">20</font>小时
	 					<font class="font_group_deadtime">40</font>分
	 					<font class="font_group_deadtime">18</font>秒</font>
	 			</div>
	 	</div>
	 </div>
	 openid:<s:property value="openid"/><br/>
	        <input name="openid" value="<s:property value="openid"/>"/>
	<script src="js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="js/less.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(function(){
			//团购按钮样式
			$(".group_price_right img").hover(function(){
				$(this).attr("src","images/group/group-c.png");
			},function(){
				$(this).attr("src","images/group/group.png");
			});
			//点击团购按钮
			$(".group_price_right img").click(function(){
				$("#group_order").submit();
			});
			
			
		});
	</script>
</body>
</html>
