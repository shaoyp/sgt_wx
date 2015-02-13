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
	 		<div class="group_title font_group_title"><s:property value="group.name" /></div>
	 	</div>
	 	<div class="group_price" style="">
	 		<div class="group_price_div">
	 			<div class="group_price_left left">
	 				<font>&#65509;</font><font class="font_group_normalprice"><s:property value="group.discount_private" /></font> 
	 			</div>
	 			<form action="groupOrder.action" method="post" id="group_order">
	 			<div class="group_price_right right">
	 				<img alt="" src="images/group/group.png"/>
	 			</div>
	 			<div class="group_price_num right">
	 				数量：<span id="group_num_down">-</span>&nbsp;<input name="num" style="width:25px;" value="1" id="group_num"/>&nbsp;<span id="group_num_up">+</span>
	 			</div>
	 				 <input type="hidden" name="openid" value="<s:property value="openid"/>"/>
	 				 <input type="hidden" name="price" value="<s:property value="group.discount_private" />"/>
	 			</form>
	 		</div>
	 		<div class="group_price_div">
	 			<div class="group_price_bottom">
	 				<font>原价 &nbsp;
	 					<font class="font_group_throughline"> &#65509;<s:property value="group.price" /></font> 
	 					&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;节省  &nbsp;
	 					<font class="font_group_throughline">&#65509;<s:property value="group.price - group.discount_private" /></font>
	 				</font>
	 			</div>
	 		</div>
	 	</div>
	 	<div class="group_num">
	 			<div class="group_num_top">
	 				<font class="font_group_normaltime"><font class="font_group_totalnum"><s:property value="group.people_num" /></font>人已经购买&nbsp;数量有限，赶快下单吧！</font>
	 			</div>
	 			<div class="group_num_bottom">
	 				剩余时间：
	 				<font class="font_group_normaltime" id="group_time">
	 					<input type="hidden" id="groupTime"  value="<s:property value="group.dead_line"/>"/>
	 					<font class="font_group_deadtime" id="group_day">3</font>天
	 					<font class="font_group_deadtime" id="group_hour">20</font>小时
	 					<font class="font_group_deadtime" id="group_min">40</font>分
	 					<font class="font_group_deadtime" id="group_sec">18</font>秒
	 				</font>
	 			</div>
	 	</div>
	 </div>
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
			//剩余时间
			var dat = $("#groupTime").val();
	    	calcTime(dat);
		   	setInterval(function(){
		   		calcTime(dat);
		   	},1000);
		   	//数量改变
		   	$("#group_num_up").click(function(){
		   		var group_num = parseInt($("#group_num").val()) + 1;
		   		$("#group_num").val(group_num);
		   	});
		   	$("#group_num_down").click(function(){
		   		if(parseInt($("#group_num").val()) > 0){
			   		var group_num = parseInt($("#group_num").val()) - 1;
			   		$("#group_num").val(group_num);
		   		}
		   		
		   	});
		});
		function calcTime(dat){
	    	var cur = new Date().getTime();	
	    	if(dat < cur){
	    		$("#group_time").text("已过期");
	    	}else{
				var baseSec = parseInt((dat - cur)/1000);
				var day = parseInt(baseSec/3600/24);
				var sec = baseSec%60;
				var min = parseInt(baseSec/60)%60;
				var hour = parseInt(baseSec/3600)%24;
				$("#group_day").html(day);
				$("#group_hour").html(hour);
				$("#group_min").html(min);
				$("#group_sec").html(sec);
	    		
	    	}
	    }
	</script>
</body>
</html>
