Pager.getSpan = function(value,className){
    return $("<span class='"+className+"'>"+value+"</span>");
}
function Pager($parent){
    this.$parent = $parent;
    this.pageCallBack = $.noop;
    this.preVal = "＜";
    this.nextVal = "＞";
    this.splitChar = "…";
    this.init();
    this.spaceStep = 2;
}
Pager.prototype.setPageCallBack = function(pageCallBack){
    this.pageCallBack = pageCallBack;
    return this;
}
Pager.prototype.init = function(){
    if(this.$parent.length == 0){
        alert("pagediv not exists ");
    }
    this.$divRow = $("<div class='pagerRow'></div>").appendTo(this.$parent);
    this.$div = $("<div class='showPage'>").appendTo(this.$parent);
}
Pager.prototype.clear = function(){
    this.$div.empty();
    this.$divRow.empty();
}
Pager.prototype.addSpan = function(value,className){
    var $span = Pager.getSpan(value,className).appendTo(this.$numdiv);
    $span.css("width",this.getSpanWidth(value)+"px");
    return $span;
}
Pager.prototype.getSpanWidth = function(value){
    var width = 21;
    var curNeed = 0;
    if(!isNaN(value)){
        curNeed = value.toString().length * 8;
    }
    return curNeed>width?curNeed:width;
}
Pager.prototype.disable = function($span,flag){
    var removeClass = flag?"nable cursor_pointer":"disable cursor_default";
    var addClass = flag?"disable cursor_default":"nable cursor_pointer";
    $span.removeClass(removeClass).addClass(addClass);
    return $span;
}
Pager.prototype.show = function(pageCount,curPage,rowCount){
    alert(0)
    this.clear();
    this.$divRow.html("　　共有"+pageCount+"页，"+rowCount+"条数据");
    pageCount = pageCount?pageCount-0:0;
    if(pageCount<=0){
        return;
    }
    var self = this;
    this.$prev = Pager.getSpan(this.preVal,"toBtn").appendTo(this.$div);
    this.$numdiv = $("<div class='numDiv'></div>").appendTo(this.$div);
    this.$nextVal = Pager.getSpan(this.nextVal,"toBtn").appendTo(this.$div);
    curPage = curPage?curPage-0:1;
    curPage = curPage<1?1:curPage;
    curPage = curPage>pageCount?pageCount:curPage;
    this.disable(this.$prev,curPage == 1);
    if(curPage>1){
        this.$prev.click(function(){
                self.pageCallBack(curPage-1);
            });
    }
    this.disable(this.$nextVal,curPage == pageCount);
    if(curPage<pageCount){
        this.$nextVal.click(function(){
                self.pageCallBack(curPage+1);
            });
    }
    var steps = this.getSteps(pageCount,curPage);
    for(var i in steps){
        if(i == curPage){
            this.addSpan(steps[i],"nable");
            continue;
        }
        if(steps[i] == this.splitChar){
            this.addSpan(steps[i]);
            continue;
        }
        
        this.addSpan(steps[i],"disable").hover($.proxy(this.mouseover,this),$.proxy(this.mouseout,this))
            .click(function(){
                alert(0)
                self.pageCallBack($(this).html());
            });
    }
}
Pager.prototype.mouseout = function(e){
    var $span = $(e.target);
    this.disable($span,true);
}
Pager.prototype.mouseover = function(e){
    var $span = $(e.target);
    this.disable($span,false);
}
Pager.prototype.getSteps = function (pageCount,curPage){
    var steps = {};
    var curStar = curPage-3;
    var curEnd = curPage+3;
    for(var i=1;i<=pageCount;i++){
        if((i>this.spaceStep && i<curStar)||(i>curEnd && i<pageCount-1)){
            continue;
        }
        if((i==curStar && i>this.spaceStep) || (i==curEnd && i<pageCount-1)){
            steps[i]=this.splitChar;
            continue;
        }
        steps[i]=i;
    }
    return steps;
}
