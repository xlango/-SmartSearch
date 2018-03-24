$(document).ready(function(){	
	$('#login-button').click(function (event) {
		var url='/test/person/dologin';
		var sendData={'username':$('#username').val(),
				      'password':$('#password').val()};
		$.ajax({
			url:url,
			data:sendData,
			type:'POST',
			dataType: "text",
			success:function(data){
				var rdata=JSON.parse(data);
				if(rdata.msg=='成功'){
					alert('登录成功');
					event.preventDefault();
					$('form').fadeOut(500);
					$('.wrapper').addClass('form-success');
					toIndex();
				}else{
					alert('登录失败');
				}
			}		
		});		
	});
			
});

function checkeUsername(){
	var url1='/test/person/getuser';
	var sendData1={'username':$('#username').val()};
	$.ajax({
		url:url1,
		data:sendData1,
		type:'GET',
		dataType: "text",
		success:function(data){
			var rdata=JSON.parse(data);				
			if(rdata.msg=='成功'){
				$('#p').html('*账号可用').css("color",'green');
			}else{
				$('#p').html('*账号不可用').css("color",'red');
			}
		}		
	});			
  };
  
function toIndex() {
	  window.location.href = '/test/person/index';//跳转至主界面
	}
