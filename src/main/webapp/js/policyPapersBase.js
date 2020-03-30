var policyPapersapp = angular.module('shanxi-policyPapers',[ ]);
/*$sce服务写成过滤器*/
policyPapersapp.filter('trustHtml',['$sce',function($sce){
    return function(data){
        return $sce.trustAsHtml(data);
    }
}]);

policyPapersapp.directive('loading', function(){
    return {
        restrict: 'E',
        transclude: true,
        template: '<div ng-show="loading" class="loading" id="allDiv"  style="position:fixed; top:0px; left:0px; width:100%; height:100%; display:none; background-color:#000; opacity: 0.5; z-index:99999;">'
        /*+'<img alt="" src="img/user4-128x128.jpg" style="vertical-align: middle;width:100px; height:100px; position: absolute; top:50%; left:50%; margin-top: -50px; margin-left:-50px;"/>'*/
        +' <div  style="position:fixed;height: 100%;width: 100%"> <div class="box box-danger box-solid" style="position:fixed;height: 100%;width: 100%"> <div class="overlay" style="position:fixed;height: 100%;width: 100%">   <i class="fa fa-refresh fa-spin"  style="position: absolute; top:50%; left:60%; margin-top: -50px; margin-left:-50px;"></i>'
        +'<div id="wenzi" style="position: absolute; top:55%; left:50%; margin-top: -50px; margin-left:-50px;">这里是文字</div></div>    </div>  '
        +'</div>',
        link: function (scope, element, attr) {
            scope.$watch('loading', function (val) {
                if (val){
                    document.getElementById("allDiv").style.display = "block";
                }else{
                    document.getElementById("allDiv").style.display = 'none';
                }
            });
        }
    }
});
