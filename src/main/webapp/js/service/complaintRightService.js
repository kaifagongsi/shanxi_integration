//统计service层
firstwebApp.service('complaintRightService',function ($http) {
    //列表页加载
    this.load = function (searchMap) {
        return $http.post('../../complaintRight/getList.do',searchMap);
    }


    this.uploadfile = function (pData) {
        return $http.post('../../complaintRight/save.do',pData);
    }

    /*this.savefile = function () {
        //获取表单
        var formData = new FormData(document.getElementById("rights_info"));
        //获取文件
        var file = document.getElementById("file").files[0];
        //向formData中添加数据:
        formData.append("file",file);

        $http({
            method: 'post',
            url: '../../imgUpload/ckeditorUpload.do?command=QuickUpload&type=Files',
            data: formData,
            headers: {'Content-Type': undefined},
            transformRequest: angular.identity
        })
            .success(function(data){
                console.log(data);
            });
        //return $http.post('../../imgUpload/ckeditorUpload.do?command=QuickUpload&type=Files');
    }*/

    this.upload = function(){
        /*//获取表单
        var formData = new FormData(document.getElementById("rights_info"));
        //获取文件
        var file = document.getElementById("file").files[0];
        //向formData中添加数据:
        formData.append("file",file);

         $http({
             method: 'post',
             url: '../../complaintRight/upload.do',
             data: formData,
             headers: {'Content-Type': undefined},
             transformRequest: angular.identity
         })
             .success(function(data){
             console.log(data);
        });*/
    };


    });
