//$(document).ready(function(){	
//	$('#content').bind(function(){
//		searchlike();
//	});
//	
//})

//搜索框模糊查询
function searchlike(){
	$.ajax({
		url:'/test/comment/getlikeContent',
		data:{'content':$('#content').val()},
		type:'GET',
		dataType: "text",
		success:function(data){
			var rdata=JSON.parse(data);	
			if(rdata.msg=='失败'){ $('#search-result').empty(); }
			else {
				var boarddiv='';
				for (var i = 0; i < 5; i++) {
					if (i==0) {
						$('#search-result').empty();
					}	
					boarddiv="<div class=\"form-control btn-default\" id='"+rdata.data[i].content
					+"' onclick=\"linkInput(this)\">"+rdata.data[i].content+"</div>"; 
					$('#search-result').append(boarddiv);			
				  }	
			}					
		}		
	});			
  };
  
function linkInput(obj){
	$('#content').val(obj.id);
	$('#search-result').empty();
}