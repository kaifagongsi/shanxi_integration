var cobj,minus;
function setContent(){
    var cheight=$(window).height()-minus-26;
    if(cheight<100){
        cheight=100;
    }
    $(cobj).height(cheight);
}
function setCntmin(){
    var cheight=$(window).height()-minus-26;
    if(cheight<200){
        cheight=200;
    }
    $(cobj).css("min-height",cheight+"px");
}