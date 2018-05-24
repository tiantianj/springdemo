$(function () {
   $("#reply").submit(function (e) {
       if($("#content").val().trim()==""||$("#author").val().trim()==""){
           alert("回复内容或者昵称不能为空");
           //阻止表单
           e.preventDefault();
       }else{
           return;
       }

   }) ;
});