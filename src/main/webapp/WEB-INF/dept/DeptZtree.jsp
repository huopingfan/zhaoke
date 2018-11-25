<%@page import="com.fh.util.UtilProperties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%
    		String cimgurl = UtilProperties.getProperty("nginx.host");
    		request.setAttribute("nginxhttp", cimgurl);
    	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/commons/datatime/bootstrap-datetimepicker.min.css" />
<link href="<%=request.getContextPath() %>/commons/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/commons/datatable/DataTables-1.10.18/css/dataTables.bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/commons/ztree/css/bootstrapStyle/bootstrapStyle.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/commons/jq/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/commons/ztree/js/jquery.ztree.all.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/commons/ztree/js/jquery.ztree.exhide.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/commons/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/commons/dataTable.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/commons/bootbox/bootbox.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/commons/datatable/DataTables-1.10.18/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/commons/datatable/DataTables-1.10.18/js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/commons/datatime/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/commons/datatime/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/commons/selectTree.js"></script>


<link href="<%=request.getContextPath()%>/commons/fileinput/css/fileinput.min.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="<%=request.getContextPath()%>/commons/fileinput/js/fileinput.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/commons/fileinput/js/locales/zh.js"></script>





</head>
<body>
	<nav class="navbar navbar-default navbar-static-top">
    <div class="container-fluid" style="background-color: #ccc;height:80px">
        <ul class="nav navbar-nav navbar-left">
            <li><a href="#">欢迎登陆<%-- <h1>欢迎${user.crealname}
           	 登录系统&nbsp;登陆时间为
            <fmt:formatDate value="${user.clastlogintime }" pattern="yyyy-MM-dd HH:mm:ss" />
            <c:if test="${user.clogincount !=0}">
             &nbsp;今天登陆的次数为${user.clogincount+1}次
            </c:if>
            </h1> --%>
               </a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="javascript:;" onclick="logout();">安全退出</a></li>
        </ul>
    </div>
	</nav>	
    	 <div class="col-md-3">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-info">
                        <!-- Default panel contents -->
                        <div class="panel-heading">
                            管理<br>
                            <button type="button" class="btn btn-primary" onclick="addDept();"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增</button>
                            <button type="button" class="btn btn-info" onclick="showEditDept();"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改</button>
                            <button type="button" class="btn btn-danger" onclick="deleteDept();"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除</button>
                        </div>
                        <div class="panel-body" style="height:800px">
                            <!-- Table --><!-- 动态树 -->
                            <div id="deptTree" class="ztree"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 用户 -->
         <div class="col-md-9" >
            <div class="row" >
                <div class="col-md-12">
                    <div class="panel panel-info">
                        <!-- Default panel contents -->
                        <div class="panel-heading">
                           用户查询
                        </div>
                        <div class="panel-body">
                            <form class="form-horizontal" id="empSearchForm">
                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">名字:</label>
                                    <div class="col-sm-6" >
                                        <input type="text" class="form-control"  name="cusername">
                                    </div>
                                </div>
                             
                               <!--  <div class="form-group">
                                    <label  class="col-sm-2 control-label">生日:</label>
                                    <div class="col-sm-6">
                                        <div class="input-group">
                                            <input type="text" class="form-control" id="minbirthday">
                                            <span class="input-group-addon" id="basic-addon2"><i class="glyphicon glyphicon-list-alt"></i></span>
                                            <input type="text" class="form-control" id="maxbirthday">
                                        </div>
                                    </div>
                                </div> -->
                                <div class="form-group" style="text-align: center;">
                                    <button type="button" class="btn btn-primary" onclick="search();"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询</button>
                                    <button type="reset" class="btn btn-info" ><span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>重置</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12" >
                    <button type="button" class="btn btn-primary" onclick="showAddEmp();"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增</button>
            		<button type="button" class="btn btn-primary" onclick="downExcel()">
					<span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span>
					动态下载Excel
					</button>
            
            
            
            
                </div>
            </div>
            <div class="row" >
                <div class="col-md-12">
                    <div class="panel panel-info">
                        <!-- Default panel contents -->
                        <div class="panel-heading">
                         	   用户列表
                        </div>
                        <div class="panel-body">
                            <table id="empTable" class="table table-striped table-bordered" style="width:100%">
                            </table>
                        </div>
                    </div>
                    </div>
                </div>
       </div>
</body>
<script type="text/html" id="addEmp">
	<form class="form-horizontal" >
        <div class="form-group">
            <label  class="col-sm-2 control-label">用户姓名</label>
            <div class="col-sm-6" >
                        <input type="text" class="form-control" id="cusername" placeholder="姓名">
 			</div>
        </div>
 		<div class="form-group">
            <label  class="col-sm-2 control-label">性别</label>

            <div class="col-sm-6">
                <input type="radio"  name="nsex" value="1">男
                <input type="radio"  name="nsex" value="0">女
            </div>
        </div>

		<div class="form-group">
            <label  class="col-sm-2 control-label">用户头像</label>

            <div class="col-sm-6">
                <input type="file"  name="userphoto" id="userphoto" >
                <input type="text"  id="cimgurl">
            </div>
        </div>
		<div class="form-group">
            <label  class="col-sm-2 control-label">是否有效:</label>
                   <div class="col-sm-6">
                      <div class="input-group">
                          <input type="radio" name="nvalid" value="1">是
                          <input type="radio" name="nvalid" value="2">否
                      </div>
                   </div>
       </div>
		<div class="form-group">
            <label  class="col-sm-2 control-label">职务</label>
                   <div class="col-sm-6">
                      <div class="input-group">
                          <select id="selectid">
							<option>请选择<option>
						</select>
                      </div>
                   </div>
       </div>
		<div class="form-group">
            <label  class="col-sm-2 control-label">部门</label>
                   <div class="col-sm-6">
                      <div class="input-group">
                          <select id="selecttypeid">
							<option>请选择<option>
						</select>
                      </div>
                   </div>
       </div>
     <div class="form-group">
            <label  class="col-sm-2 control-label">出生日期</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="dbirthday" placeholder="出生日期">
            </div>
        </div>
    </form>
</script>



<script type="text/html" id="addDept">
<div id="addForm">
	<form class="form-horizontal" enctype="" name = "addForm" >
    		<div class="form-group">
        		<label  class="col-sm-2 control-label">上级部门</label>
        	<div class="col-sm-6" >
            	<input type="text" class="form-control" id="fatherDeptName" readonly>
            	<input type="text" class="form-control" id="fatherid" readonly>
        	 </div>
   	 </div>
   		 <div class="form-group">
       		 <label  class="col-sm-2 control-label">部门名字</label>
        	<div class="col-sm-6" >
            	<input type="text" class="form-control" id="cdeptname" name="cdeptname" >
        	</div>
    	</div>
   		<div class="form-group">
            <label  class="col-sm-2 control-label">是否有效:</label>
                   <div class="col-sm-6">
                      <div class="input-group">
                          <input type="radio"   name="nvalid" value="1">是
                          <input type="radio"  name="nvalid" value="2">否
                      </div>
                   </div>
       </div>
	</form>
</div>
</script>
<script type="text/html" id="addOneDept">

	<form class="form-horizontal" enctype="" name = "addForm">
    	
   		 <div class="form-group">
       		 <label  class="col-sm-2 control-label">部门名字</label>
        	<div class="col-sm-6" >
            	<input type="text" class="form-control" id="cdeptname" name="cdeptname" >
        	</div>
    	</div>
   		<div class="form-group">
            <label  class="col-sm-2 control-label">是否有效:</label>
                   <div class="col-sm-6">
                      <div class="input-group">
                          <input type="radio"   name="nvalid" value="1">是
                          <input type="radio"  name="nvalid" value="2">否
                      </div>
                   </div>
       </div> 

<div class="form-group">
	<label  class="col-sm-2 control-label">部门描述</label>
	<button onclick="deleteOneFormDept(this)">删除</button>
</div>

	</form>

</script>



<script type="text/html" id="updateDepd">
	<form class="form-horizontal" enctype="" >
    	
   		 <div class="form-group">
       		 <label  class="col-sm-2 control-label">部门名字</label>
        	<div class="col-sm-6" >
            	<input type="text" class="form-control" id="cdeptname" >
        	</div>
    	</div>
   		
	</form>
</script>

<script type="text/javascript">
			var deptztree = {
					
					callback:{
						onClick:searchEmp
					},
				}
			$(function(){
				toloadzTree();
				toloadTable();
				/* initdatetime(); */
				initempphoto();
			})
		//初始化树.expandAll(true)
			function toloadzTree(){
				$.ajax({
					url:"<%=request.getContextPath() %>/DeptController/queryDeptZtree",
					dataType:"json",
					type:"post",
					async:false,
					success:function(data){
						$.fn.zTree.init($("#deptTree"), deptztree, data);
					},
					error:function(){
						alert("部门树展示失败，请联系114进行查询");
					}
				})
			}
			
			//初始化用户表
			var empTable;
			function toloadTable(){
				empTable = 	$("#empTable").dataTable({
					//是否允许改变每页条数
					"lengthChange":true,//配合  lengthMenu使用
					"lengthMenu":[5,10,15,20],
					//是否允许使用本地分页
					"paging":true,
					//是否显示当前操作的状态
					"processing":true,
					//是否开启本地搜索
					"searching":true,
					//是否开启服务器端 或者   客户端
					//客户端在前台自动分页  过滤  服务器端要自己写分页
					"serverSide":true,
					//以下叫数据查询
					"ajax":{
						//发送请求查询数据的路径
						"url":"<%=request.getContextPath() %>/UserController/queryEmpPageList",
						
						//回调函数
						"dataSrc":function(result){
						  return  result.data;
						},
					},
					//以下是  数据的对应展示
					"columns":[
							//数据库里的字段
							{"data":"cuserid","orderData":false,
								"title":"<input  type='checkbox' name='checklist' id='checkall' onclick='alles()'>选择",
								"width":"10%",
								render:function( data  ,   type   ,  row   ,  meta   ){
									return '<input type="checkbox" name="cuserid"  value="'+data+'">';
								}
							},
							{"data":"cusername","title":"用户姓名"},
							{"data":"dbirthday","title":"用户生日",
								render:function(  data  ,   type   ,  row   ,  meta ){

									return  new Date(data).Format("yyyy-MM-dd");
									}
							},
							{"data":"cimgurl","title":"用户照片",
								render:function( data  ,   type   ,  row   ,  meta   ){
									if(data != null && data != ""){
										return "<img src='${nginxhttp}"+data+"' class='img-cricle' width='80px'>";
									}
									return data;
								}
							},
							{"data":"cdeptname","title":"所在部门"},
							{"data":"czwname","title":"职务"},
							{"data":"nsex","title":"用户性别",
								render:function(  data  ,   type   ,  row   ,  meta ){

									return  data==1?"男":"女";
									}
							},
							{"title":"操作"}
					],
					columnDefs:[{
						//  6  为  下标   在指定的下标位置加  标签
						"targets":7,
						render:function(data , type ,row , meta){
							var buttons = "";
							buttons+='<a type="button"  href="javascript:;" onclick="delEmp(\''+row.cuserid+'\')">删除</a>&nbsp;&nbsp;&nbsp;';
							buttons+='<a type="button"  href="javascript:;" onclick="updateEmp(\''+row.cuserid+'\')">修改</a>';
						return  buttons;
						}

					}],
					//以下的是   回调函数
					//放到  ajax  外面，跟  ajax  平级
					//表格重新绘制需要的回调函数
					"fnDrawCallback":function (oSettings){
					},
					//表格加载成功后的回调函数
					"fnInitComplete":function(oSettings,json){
						console.log('DataTable 初始化完毕');
					},
					//以下是国际化
					//设置国际化语言
					"language":{
							"url":"<%=request.getContextPath()%>/commons/datatable/Chinese.json"
					},
				})
			}
			//增加树节点
			function addDept()
			{
				//判断是否选中父级节点
				var ztreeobj = $.fn.zTree.getZTreeObj("deptTree");
				var selectNodes = ztreeobj.getSelectedNodes();
				if(selectNodes.length ==0){
					//alert弹框，提示没有请选择父节点
					bootbox.alert({
						size:"small",
						title:"增加节点提示信息",
						message:"<span class='glyphicon glyphicon-plus' aria-hidden='true'></span>请选择你要增加的父节点"
					})
					return false;
				}
				bootbox.dialog
				({
					//弹出框的大小   small  小   larged  大
					size:"larged",
					//弹出框的抬头
					title:"部门新增表单",
					//弹出框的信息
					message:$("#addDept").html(),
					buttons:
					{
						addOneForm:{
							label:'添加部门',
							className:'btn-info',
							callback:function(){
								$("#addForm").append($("#addOneDept").html());
								return false;
							}
						},
						confirm:
						{
							lable:"保存",
							className:"btn-success",
							callback:function()
							{
								var cpid = selectNodes[0].id;
								/* var cdeptname = $("#cdeptname").val();
								var cdescription = $("#cdescription").val(); */
								var deptArr=[];
								var forms = $("[name='addForm']");
								$.each(forms,function(){
									var cdeptname = $(this).find("[name='cdeptname']").val();
									var nvalid = $(this).find("[name='nvalid']").val();
									deptArr.push({
										cpid:cpid,
										cdeptname:cdeptname,
										nvalid:nvalid
									})
								})
								
							 $.ajax
								({
									url:"<%=request.getContextPath() %>/DeptController/addDept",
									type:"post",
									dataType:"json",
									data:{
										deptArr:JSON.stringify(deptArr)
									},
									async:false,
									success:function(data)
									{
										if(data.success){
											toloadzTree();
											var newnodeid = data.deptid;
											var treenode = {};
											treenode.id = newnodeid;
											treenode.pid = cpid;
											treenode.name = cdeptname;
											ztreeobj.addNodes(selectNodes[0],treenode);
										}else{
											bootbox.alert({
													size:"small",
													title:"增加节点提示信息",
													message:"增加节点失败",
												}) 
										}
									},
									error:function(){
										bootbox.alert({
												size:"small",
												title:"增加节点提示信息",
												message:"增加节点失败",
											})
									}
								}) 
							}
						},
							cancel:{
								lable:"取消",
								className:"btn-danger",
							}	
					}
				})
				$("#fatherDeptName").val(selectNodes[0].name);
				$("#fatherid").val(selectNodes[0].id); 
			}	
	function deleteOneFormDept(obj){
		$(obj).parents("form").remove();
	}		
	//删除
	function deleteDept(){
		//获取要操作的树
		var treeObj = $.fn.zTree.getZTreeObj("deptTree");
		//获取被选中的节点
		var nodes = treeObj.getSelectedNodes();
		//判断是否选中节点
		if(nodes.length==0){
				bootbox.alert({
					size:"small",
					title:"删除节点",
					message:"请选中要删除的部门",
				})
			return false;
		}
		var childrenodes = treeObj.transformToArray(nodes);
		var ids = "";
		for (var  i=0; i < childrenodes.length; i++) {
			ids+=";"+childrenodes[i].id;
		}
		bootbox.confirm({
			size:"small",
			title:"删除节点",
			message:"删除选中的节点，以及其下全部的子节点",
			buttons:
			{
				confirm:{
					label:"删除",
					className:"btn-success",
				},
				cancel:{
					label:"取消",
					className:"btn-danger",
				}
				
			},				
		callback:function(result){
			if(result){
				$.ajax({
					url:"<%=request.getContextPath() %>/DeptController/deletedept",
					data:{
						deptid:ids
						},
					type:"post",
					dataType:"json",
					async:false,
					success:function(result){
						if(result.success){
							treeObj.removeChildNodes(nodes[0]);
							treeObj.removeNode(nodes[0]);
						}
					},
					error:function()
					{
						bootbox.alert({
							size:"small",
							title:"删除失败",
							message:"删除失败，请稍后再播",
						})
					}
				})
			}
		}
	})
}
	
	
	//修改
	function showEditDept()
	{
			//判断是否选中父级节点
			var ztreeobj = $.fn.zTree.getZTreeObj("deptTree");
			var selectNodes = ztreeobj.getSelectedNodes();
			if(selectNodes.length ==0){
				//alert弹框，提示没有请选择父节点
				bootbox.alert({
					size:"small",
					title:"修改节点提示信息",
					message:"<span class='glyphicon glyphicon-plus' aria-hidden='true'></span>请选择你要修改的节点"
				})
				return false;
			}
			//先把弹框弹出来，在赋值
			bootbox.dialog
			({
				//弹出框的大小   small  小   larged  大
				size:"larged",
				title:"修改节点提示信息",
				message:$("#updateDepd").html(),
				buttons:
				{
					confirm:
					{
						label:"保存",
						className:"btn-success",
						callBack:function()
						{
							//获取选中的id 通过他修改
					        var cid = selectNodes[0].id;
					        var cpid = selectNodes[0].pid;
					        var cdeptname = $("#cdeptname").val();
					        alert(cid);
					        alert(cpid);
					        alert(cdeptname);
					        alert(cdescription);
					        if(result)
					        {
						        $.ajax
						     ({
						        	url:"<%=request.getContextPath()%>/DeptController/updateDept",
									dataType:"json",
									type:"post",
									data:{
										cid:cid,
										cpid:cpid,
										cdeptname:cdeptname,
									},
									async:false,
									success:function(data)
									{
										if(data.success)
										{	
											selectNodes[0].name=cdeptname;
											ztreeObj.updateNode(selectNodes[0]);
										}
									},
									error:function()
									{
										bootbox.alert({ 
											  size: "small",
											  title: "重大错误",
											  message: "修改部门错误,请稍后重试", 
										})
									}
								})
							}
						}
					},
					cancel:{
						lable:"取消",
						className:"btn-danger",
					}
				}
			})
			//回显的值
			$("#cdeptname").val(selectNodes[0].name);
	}
	//删除用户
	function delEmp(cuserid){
		$.ajax({
			url:"<%=request.getContextPath() %>/UserController/deleteUser",
			data:{
				cuserid:cuserid
			},
			type:"post",
			dataType:"json",
			async:false,
			success:function(result){
				if(result.success){
						empTable.api().ajax.reload();
					}
			},
			error:function(){
				bootbox.alert({
					size:"small",
					title:"删除失败",
					message:"删除员工失败",
				})
			}
		})
	}
	
	
	//新增员工
	function showAddEmp(){
		bootbox.dialog
		({
			//弹出框的大小   small  小   larged  大
			size:"larged",
			//弹出框的抬头
			title:"员工新增表单",
			//弹出框的信息
			message:$("#addEmp").html(),
			buttons:
			{
				confirm:
				{
					lable:"保存",
					className:"btn-success",
					callback:function()
					{
						var cusername=$("#cusername").val();
						var nsex = $("[name='nsex']:checked").val();
						var dbirthday = $("#dbirthday").val();
						var nvalid = $("[name='nvalid']:checked").val();
						var cimgurl = $("#cimgurl").val();
						var cdeptid = $("#selecttypeid").val();
						var czwid = $("#selectid").val();
						$.ajax
						({
							url:"<%=request.getContextPath() %>/UserController/addUser",
							type:"post",
							dataType:"json",
							data:{
								cusername:cusername,
								nsex:nsex,
								dbirthday:dbirthday,
								nvalid:nvalid,
								cimgurl:cimgurl,
								cdeptid:cdeptid,
								czwid:czwid
							},
							async:false,
							success:function(result){
								if(result.success){
									bootbox.alert({
										size:"small",
										title:"增加员工",
										message:"<span class='glyphicon glyphicon-plus' aria-hidden='true'></span>增加员工成功",
									});
									searchEmp();
									empTable.api().ajax.reload();
								}
							},
							error:function(){
								bootbox.alert({
										size:"small",
										title:"增加员工提示信息",
										message:"增加员工失败",
									})
							}
						}) 
					}
				},
				cancel:{
					lable:"取消",
					className:"btn-danger",
				}	
			}
		})
		$("#dbirthday").datetimepicker({
			//时间格式
			"format":"yyyy-mm-dd",
			//国际化
			"language":'zh-CN',
			//选中之后自动关闭
			"autoclose":1,
			//只展示第三个图层，下标为2,最大视图只有4
			"startView":2,
			"minView":2,
			"todayHighlight":1,
			"todayBtn":1,
			//括号里也可自定义时间，最大只能到自定义时间
			"endDate": new Date(),
			//开始时间，只能选择括号时间之后的时间
			//startDate: new Date('2018-09-10'),
		});
		$.ajax({
			url:"<%=request.getContextPath() %>/ZwController/queryzw",
			type:"post",
			dataType:"json",
			data:{
				
			},
			async:false,
			success:function(data){
				$.each(data,function(){
					$("#selectid").append("<option value='"+this.czwid+"'>---"+this.czwname+"---</option>")
				})
					searchEmp();
				
			},
			error:function(){
				bootbox.alert({
						size:"small",
						title:"修改员工提示信息",
						message:"修改员工信息失败",
					})
			}
			})
			$.ajax({
			url:"<%=request.getContextPath() %>/DeptController/querydept",
			type:"post",
			dataType:"json",
			data:{
				
			},
			async:false,
			success:function(data){
				$.each(data,function(){
					$("#selecttypeid").append("<option value='"+this.cdeptid+"'>---"+this.cdeptname+"---</option>")
				})
					searchEmp();
				
			},
			error:function(){
				bootbox.alert({
						size:"small",
						title:"修改员工提示信息",
						message:"修改员工信息失败",
					})
			}
			})
		initempphoto();
	}
	
	//fileinput图片上传到ftp
	function initempphoto(previewArr){
		$("#userphoto").fileinput({
			uploadUrl:"<%=request.getContextPath()%>/UserController/fileload",
			initialPreview:previewArr,
			initialPreviewAsData:true,//特别重要的地方
			uploadAsync : true, //默认异步上传
			showUpload : true, //是否显示上传按钮,跟随文本框的那个
			showRemove : true, //显示移除按钮,跟随文本框的那个
			showCaption : true,//是否显示标题,就是那个文本框
			showPreview : true, //是否显示预览,不写默认为true
			dropZoneEnabled : false,//是否显示拖拽区域，默认不写为true，但是会占用很大区域
			language : 'zh',//设置国际化语言
			allowedFileTypes : [ 'image' ],//配置允许文件上传的类型
		    allowedPreviewTypes : [ 'image' ],//配置所有的被预览文件类型
		    allowedPreviewMimeTypes : [ 'jpg', 'png', 'gif' ],//控制被预览的所有mime类型
			layoutTemplates: {     
	        	actionUpload: '',   //取消上传按钮 
	         	actionZoom: ''      //取消放大镜按钮 
	  		}
		}).on("fileuploaded",function(event   , data  , priviewld  ,  index ){
			if(data!=null && data.response.ok ){
					$("#cimgurl").val(data.response.url);
				}
				return data;
			})
	}
	/* //初始化日期
	function initdatetime(){
		$("#minBirthday").datetimepicker({
			//时间格式
			"format":"yyyy-mm-dd",
			//国际化
			"language":'zh-CN',
			//选中之后自动关闭
			"autoclose":1,
			//只展示第三个图层，下标为2,最大视图只有4
			"startView":2,
			"minView":2,
			//
			"todayHighlight":1,
			
			"todayBtn":1,
			//括号里也可自定义时间，最大只能到自定义时间
			"endDate": new Date(),
			//开始时间，只能选择括号时间之后的时间
			//startDate: new Date('2018-09-10'),
		}).on('changeDate',function(e){
				var startTime = e.date;
				$("#maxBirthday").datetimepicker('setStartDate',startTime);
			});
			
		$("#maxBirthday").datetimepicker({
			//时间格式
			"format":"yyyy-mm-dd",
			//国际化
			"language":'zh-CN',
			//选中之后自动关闭
			"autoclose":1,
			//只展示第三个图层，下标为2,最大视图只有4
			"startView":2,
			"minView":2,
			//今天高亮
			"todayHighlight":1,
			//设置加上今天的按钮
			"todayBtn":1,
			//括号里也可自定义时间，最大只能到自定义时间
			"endDate": new Date(),
			//开始时间，只能选择括号时间之后的时间
			//startDate: new Date('2018-09-10'),
		}).on('changeDate',function(e){
				var endTime = e.date;
				$("#minBirthday").datetimepicker('setEndDate',endTime);
			});
} */
//修改
function updateEmp(cuserid){
	bootbox.dialog
	({
		//弹出框的大小   small  小   larged  大
		size:"larged",
		//弹出框的抬头
		title:"修改表单",
		//弹出框的信息
		message:$("#addEmp").html(),
		buttons:
		{
			confirm:
			{
				lable:"保存",
				className:"btn-success",
				callback:function()
				{
					var cusername=$("#cusername").val();
					var nsex = $("[name='nsex']:checked").val();
					var dbirthday = $("#dbirthday").val();
					var userphotoimg = $("#userphotoimg").val();
					$.ajax
					({
						url:"<%=request.getContextPath() %>/UserController/updateUser",
						type:"post",
						dataType:"json",
						data:{
							cuserid:cuserid,
							cusername:cusername,
							nsex:nsex,
							dbirthday:dbirthday,
							userphotoimg:userphotoimg
						},
						async:false,
						success:function(result){
							if(result.success){
								bootbox.alert({
									size:"small",
									title:"修改员工",
									message:"<span class='glyphicon glyphicon-plus' aria-hidden='true'></span>修改员工成功",
								});
								searchEmp();
							}
						},
						error:function(){
							bootbox.alert({
									size:"small",
									title:"修改员工提示信息",
									message:"修改员工信息失败",
								})
						}
					}) 
				}
			},
			cancel:{
				lable:"取消",
				className:"btn-danger",
			}	
		}
	})
	$("#dbirthday").datetimepicker({
		//时间格式
		"format":"yyyy-mm-dd",
		//国际化
		"language":'zh-CN',
		//选中之后自动关闭
		"autoclose":1,
		//只展示第三个图层，下标为2,最大视图只有4
		"startView":2,
		"minView":2,
		//
		"todayHighlight":1,
		
		"todayBtn":1,
		//括号里也可自定义时间，最大只能到自定义时间
		"endDate": new Date(),
		//开始时间，只能选择括号时间之后的时间
		//startDate: new Date('2018-09-10'),
	});
	//数据回显
	$.ajax({
		url:"<%=request.getContextPath() %>/UserController/queryEmpById",
		data:{
			cuserid:cuserid
		},
		dataType:"json",
		type:"post",
		async:false,
		success:function(data){
			if(data.success){
				var user = data.data;
				$("#cusername").val(user.cusername);
				var sexs = $("[name='nsex']");
				var nsex = user.nsex;
				$.each(sexs,function(){
					var rsex = $(this).val();
						if(nsex==rsex){
							$(this).prop("checked",true);
						}
				})
				$("#dbirthday").val(new Date(user.dbirthday).Format("yyyy-MM-dd"));
				var paremarr = [];
				if(user.cimgurl!=null && user.cimgurl!=""){
					paremarr.push("${nginxhttp}"+user.cimgurl)
				}
				initempphoto(paremarr);
				$("#cimgurl").val(user.cimgurl);
			}
		},
		error:function(){
			alert("部门树展示失败，请联系114进行查询");
		}
	})
}	
			//动态导出用户表Excel
			function downExcel(){
							
			   var zTreeObj=$.fn.zTree.getZTreeObj("deptTree");
				   var selectedNodes=zTreeObj.getSelectedNodes();
				   var selectids="";
				   if(selectedNodes.length!=0) {
						if (selectedNodes[0].id!="1") {
								var nodes=zTreeObj.transformToArray(selectedNodes[0]);
								for ( i= 0; i < nodes.length; i++) {
									selectids+=";"+nodes[i].id;
								}
						}
					}
				   var myform=document.getElementById("empSearchForm");
				   myform.action="<%=request.getContextPath()%>/UserController/exportExcel?deptids="+selectids;
				   myform.method="post";
				   myform.submit();
			}
	
			//点击树节点，显示相应的列表
			function searchEmp(){
				var treeobj = $.fn.zTree.getZTreeObj("deptTree");
				var selectNodes = treeobj.getSelectedNodes();
				var selectids = "";
				if(selectNodes.length !=  0 ){
					if(selectNodes[0].id  !=  "1" ){
						var  nodes = treeobj.transformToArray(selectNodes[0]);
						for(var   i =0 ;  i<nodes.length ; i++  ){
							selectids+=";"+nodes[i].id;
						}
					}
				}
				var  param = {};
				//赋参数
				param.cdeptids = selectids;
				param.cusername = $("[name='cusername']").val();
				//如何给  datatable  动态赋值
				empTable.api().settings()[0].ajax.data = param;
				//列表刷新
				empTable.api().ajax.reload();
			}

</script>
</html>