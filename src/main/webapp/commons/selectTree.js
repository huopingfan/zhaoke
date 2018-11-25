function getInitSelectTree(treeData,checkstyle){
	   $.fn.zTree.init($("#rptEmpTree0"),{
           check: {
               enable: true,
               chkStyle: checkstyle,
               radioType : "all"
           },
           callback: {
               onCheck: function(e, treeId, treeNode) {
                   var zTree = $.fn.zTree.getZTreeObj("rptEmpTree0"),
                           nodes = zTree.getCheckedNodes(true),
                           v = "";
                   		nodeid="";
                   if(nodes != null){
                       for(var i=0, l=nodes.length; i<l; i++) {
                           v += nodes[i].name + ",";
                           nodeid += nodes[i].id + ",";
                       }
                   }
                   if(v.length > 0) {
                       v = v.substring(0, v.length-1);
                       nodeid= nodeid.substring(0, nodeid.length-1);
                   };
                   $("#station").val(v);
                   $("#station").attr("idvalue",nodeid);
                   $('.pull-left', '#stationBtn').text(v).attr('title', v);
                   if(v == ""){
                       $('.pull-left', '#stationBtn').text('请选择').attr('title', '请选择');
                   }
               }
           }
       }, treeData);
}

//搜索查询满足条件展开  隐藏tree中的node
function testHideNode(){
    var treeObj = $.fn.zTree.getZTreeObj("rptEmpTree0");
    var nodes = treeObj.getNodes();
    if(nodes.length > 0){
        for(var i=0; i< nodes.length; i++){
            treeObj.hideNodes(nodes[i]);
        }
    }
    sv = $("#selectTree").val();

    nodeList = treeObj.getNodesByFilter(filter1);
    nodeList = treeObj.transformToArray(nodeList);
    for(var n in nodeList){
        findParent(treeObj,nodeList[n],sv);
    }

    treeObj.showNodes(nodeList);
    var hideNode = treeObj.getNodesByFilter(filter); // 仅查找一个节点

    treeObj.hideNodes(hideNode);


}
//
function findParent(treeObj,node,sd){
    treeObj.expandNode(node,true,false,false);
    var pNode = node.getParentNode();
    if(pNode != null&&typeof(pNode)!='undefined'){
        nodeList.push(pNode);
        findParent(treeObj,pNode,sd);
    }
}

function filter(node) {
    if(sv==""||sv==null){
        return;
    }
    return (node.checked==false&&node.isParent==false&&node.name.indexOf(sv)==-1);
}

function filter1(node) {
    console.debug(sv);
    return (node.checked==true||node.name.indexOf(sv)>-1);
}

var M;
 $(document).click(function(e){
	 $('#selectTree').on('keydown keyup',function(){
		    var t = this;
		    clearTimeout(M);
		    M = setTimeout(function(){
		        testHideNode();
		    },500)
		});
		$('#stationBtn').on('focus', function(){
			//获取树
			var ztree = $.fn.zTree.getZTreeObj("rptEmpTree0");
			//获取 隐藏框Id值 （idvalue）
			var nodeId=$("#station").attr("idvalue");
			if(nodeId != "" &&  nodeId != null ){
				
				var node = ztree.getNodesByParam("id",nodeId)[0];
				var parent = node.getParentNode();  
	            //判断父节点是否打开 
				if(!parent.open){  
	               ztree.expandNode(parent,true,true);  
	            }  
				//判断节点是否选中
	            ztree.checkNode(node,true,true);
			}
			$('#stationPanel').show();
		});
     if($(e.target).attr('id') != "stationPanel" && $(e.target).parents('#stationPanel').length <= 0 && $(e.target).attr('id')!= "station" && $(e.target).attr('id')!="stationBtn" && $(e.target).parents('#stationBtn').length <= 0){
         $('#stationPanel').hide();
         $('#selectTree').val('');
     }
 });



