function sethomebg(path){
    $("#mbg").html("<img src='"+path+"/homebg3.jpg'><img src='"+path+"/homebg4.jpg'>");

    $(".mbg img").fadeOut(0).eq(0).fadeIn(0);
    var i = 0;
    setInterval(function(){
        if($(".mbg img").length > (i+1)){
            $(".mbg img").eq(i).fadeOut(2000).next("img").fadeIn(2000);
            i++;
        } else{
            $(".mbg img").eq(i).fadeOut(2000).siblings("img").eq(0).fadeIn(2000);
            i = 0;
        }
    },5000);
}
$(function(){
    $('#owl-demo').owlCarousel({
        items: 1,
        navigation: true,
        autoPlay: true,
        stopOnHover: true
    }).hover(function(){
        $('.owl-buttons').show();
    }, function(){
        $('.owl-buttons').hide();
    });
});