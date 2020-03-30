$(document).ready(function(){

});
function init_ztreeEnt(zNodes) {
    var treeObj = $.fn.zTree.init($("#rptEmpTree0Ent"),{
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
            onClick : zTreeOnClickEnt
        }
    }, zNodes);
    console.log(zNodes);
    treeObj.expandAll(false);    //默认展开
}
//隐藏tree中的node
function testHideNode(){
    var treeObj = $.fn.zTree.getZTreeObj("rptEmpTree0Ent");
    var nodes = treeObj.getNodes();
    if(nodes.length > 0){
        for(var i=0; i< nodes.length; i++){
            treeObj.hideNodes(nodes[i]);
        }
    }
    sv = $("#selectTreeEnt").val();

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
$('#stationBtnEnt').on('focus', function(){
    $('#stationPanelEnt').show();
});
$(document).click(function(e){
    if($(e.target).attr('id') != "stationPanelEnt" && $(e.target).parents('#stationPanelEnt').length <= 0 && $(e.target).attr('id')!= "stationEnt" && $(e.target).attr('id')!="stationBtnEnt" && $(e.target).parents('#stationBtn').length <= 0){
        $('#stationPanelEnt').hide();
        $('#selectTreeEnt').val('');
    }
});
var M;
$('#selectTreeEnt').on('keydown keyup',function(){
    var t = this;
    clearTimeout(M);
    M = setTimeout(function(){
        testHideNode();
    },500)
});

function zTreeOnClickEnt(event, treeId, treeNode) {
    var v = treeNode.name;
    $("#stationEnt").val(v);
    var input = angular.element($("#stationEnt"));

    //获取文本框的scope
    var scope = input.scope();
    scope.searchEnt.area = treeNode.cityId;
    scope.$apply();
    console.log( $("#stationEnt").val());
    $('.pull-left', '#stationBtnEnt').text(v).attr('title', v);
    if(v == ""){
        $('.pull-left', '#stationBtnEnt').text('请选择').attr('title', '请选择');
    }
    //可以判断是否为2级行政区域
    $('#stationPanelEnt').hide();
    $('#selectTreeEnt').val('');
    //$("#station").val()
    //alert($("#approvalYearSelect").find("option:selected").text());
    //alert($("#classificationSelect").find("option:selected").text());
}


