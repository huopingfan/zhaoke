<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="<%=request.getContextPath() %>/commons/jq/jquery-3.2.1.js"></script>

<link href="<%=request.getContextPath() %>/commons/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="<%=request.getContextPath() %>/commons/bootstrap/js/bootstrap.min.js"></script>


</head>


<body>




<form action="" class="form-horizontal" enctype="multipart/form-data" >
    <div class="form-group">
        <label  class="col-sm-2 control-label">用户名:</label>
        <div class="col-sm-4" >
            <input type="text" class="form-control" id="cusername" >
        </div>
    </div>
    <div class="form-group">
        <label  class="col-sm-2 control-label">密码:</label>
        <div class="col-sm-4" >
            <input type="password" class="form-control" id="cuserpwd" >
        </div>
    </div>
  <center>
    <input type="button" value="登陆" onclick="login()" class="btn btn-primary" />
  </center>
</form>




</body>




<script type="text/javascript">
	function login(){
		var cusername = $("#cusername").val();
		var cuserpwd = $("#cuserpwd").val();
		if (cusername==null || cusername==""){
			alert("用户名不能为空,请输入");
			return false;
		}
		if (cuserpwd==null || cuserpwd==""){
			alert("密码不能为空,请输入");
			return false;
		}
		$.ajax({
			url:"<%=request.getContextPath()%>/LogController/queryUser",
			type:"post",
			dataType:"json",
			data:{
				"cusername":cusername,
				"cuserpwd":cuserpwd,
			},
			async:false,
			success:function(result){
				if(result.success){
				alert(result.message);
				location.href="<%=request.getContextPath() %>/DeptController/queryZtree"; 
				}
				else{
					alert(result.message);
				}
			},
			error:function(){
				alert("系统繁忙,请稍后再试！！！");
			}
		})
	}
</script>
</html>