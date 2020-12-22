function MyTable(tabName,url){
    this.$tab = $("."+tabName);
    this.$wrap = this.$tab.parent();
    this.queryURL = url;
    this.queryData = null;
    this.init();
}
MyTable.prototype.init = function(){
    this.pager = new Pager($("<div class='myPager'><div>").insertAfter(this.$wrap));
    
}

MyTable.prototype.show = function(data){
    this.clear();
    var list = data.list;
    var len = list.length;
    var df = document.createDocumentFragment();
    for(var i=0;i<len;i++){
        var $tr = $("<tr></tr>");
        var $id = $("<tr>"+list[i].imga+"</tr>").appendTo($tr);
        var $name = $("<tr>"+list[i].pname+"</tr>").appendTo($tr);
        var $age = $("<tr>"+list[i].pprice+"</tr>").appendTo($tr);
        var $sex = $("<tr>"+list[i].des+"</tr>").appendTo($tr);
        df.appendChild($tr[0]);
    }
    this.$tab[0].appendChild(df);
}

MyTable.prototype.clear = function(){
    this.$tab.empty();
}
