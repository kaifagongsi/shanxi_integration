var adminApp = angular.module('shanxi-admin',['ngCookies']);
/*$sce服务写成过滤器*/
adminApp.filter('trustHtml',['$sce',function($sce){
    return function(data){
        return $sce.trustAsHtml(data);
    }
}]);

adminApp.filter('textLengthSet', function () {
    return function(value, wordwise, max, tail) {
        if (!value) return '';

        max = parseInt(max, 10);
        if (!max) return value;
        if (value.length <= max) return value;

        value = value.substr(0, max);
        if (wordwise) {
            var lastspace = value.lastIndexOf(' ');
            if (lastspace != -1) {
                value = value.substr(0, lastspace);
            }
        }

        return value + (tail || ' …');//'...'可以换成其它文字
    };
});
adminApp.directive('loading', function(){
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
//focus directive
adminApp.directive('myFocus', function () {
    return {
        restrict: 'A',
        link: function (scope, element, attr) {
            scope.$watch(attr.myFocus, function (n, o) {
                if (n != 0 && n) {
                    element[0].focus();
                }
            });
        }
    };
});
//blur directive
adminApp.directive('myBlur', function () {
    return {
        restrict: 'A',
        link: function (scope, element, attr) {
            element.bind('blur', function () {
                //apply scope (attributes)
                scope.$apply(attr.myBlur);
                //return scope value for focusing to false
                //scope.$eval(attr.myFocus + '=false');
            });
        }
    };
});
adminApp.directive('ngFocus', [function() {
    var FOCUS_CLASS = "ng-focused";
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function(scope, element, attrs, ctrl) {
            ctrl.$focused = false;
            element.bind('focus', function(evt) {
                element.addClass(FOCUS_CLASS);
                scope.$apply(function() {ctrl.$focused = true;});
            }).bind('blur', function(evt) {
                element.removeClass(FOCUS_CLASS);
                scope.$apply(function() {ctrl.$focused = false;});
            });
        }
    }
}]);
//自定义ckeditor
adminApp.directive('ckeditor', function() {
    return {
        require : '?ngModel',
        link : function(scope, element, attrs, ngModel) {
            var ckeditor = CKEDITOR.replace(element[0], {

            });
            if (!ngModel) {
                return;
            }
            ckeditor.on('instanceReady', function() {
                ckeditor.setData(ngModel.$viewValue);
            });
            ckeditor.on('pasteState', function() {
                scope.$apply(function() {
                    ngModel.$setViewValue(ckeditor.getData());
                });
            });
            ngModel.$render = function(value) {
                ckeditor.setData(ngModel.$viewValue);
            };
        }
    };
});
