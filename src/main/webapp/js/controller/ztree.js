$(document).ready(function(){

});
function init_ztree(zNodes) {
    var treeObj = $.fn.zTree.init($("#rptEmpTree0"),{
        data: {
            simpleData: {
                enable: true,
                idKey:"cityId",
                pIdKey:"parentId",
                rootPId:0
            }
        },
        view: {
            showIcon: false,
        },
        callback: {
            onClick : zTreeOnClick
        }
    }, zNodes);
    console.log(zNodes);
    treeObj.expandAll(false);    //默认展开
}
//隐藏tree中的node
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
$('#stationBtn').on('focus', function(){
    $('#stationPanel').show();
});
$(document).click(function(e){
    if($(e.target).attr('id') != "stationPanel" && $(e.target).parents('#stationPanel').length <= 0 && $(e.target).attr('id')!= "station" && $(e.target).attr('id')!="stationBtn" && $(e.target).parents('#stationBtn').length <= 0){
        $('#stationPanel').hide();
        $('#selectTree').val('');
    }
});
var M;
$('#selectTree').on('keydown keyup',function(){
    var t = this;
    clearTimeout(M);
    M = setTimeout(function(){
        testHideNode();
    },500)
});

function zTreeOnClick(event, treeId, treeNode) {
    var v = treeNode.name;
    $("#station").val(v);
    var input = angular.element($("#station"));

    //获取文本框的scope
    var scope = input.scope();
    scope.search.area = treeNode.cityId;
    scope.$apply();
    console.log( $("#station").val());
    $('.pull-left', '#stationBtn').text(v).attr('title', v);
    if(v == ""){
        $('.pull-left', '#stationBtn').text('请选择').attr('title', '请选择');
    }
    //可以判断是否为2级行政区域
    $('#stationPanel').hide();
    $('#selectTree').val('');
    //$("#station").val()
    //alert($("#approvalYearSelect").find("option:selected").text());
    //alert($("#classificationSelect").find("option:selected").text());
}


