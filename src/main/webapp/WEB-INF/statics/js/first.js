window.onload = function init() {
	
	var btn = document.getElementById('btn');
	
	btn.onclick = function() {
		var usernameval = document.getElementById('username').value;
		var emailval = document.getElementById('email').value;

		var genderval = '';
		var bFlag = false;
		var gender = document.getElementsByName('gender');
		for (var i = 0; i < gender.length; i++) {
			if (gender[i].checked) {
				bFlag = true;			
				genderval = gender[i].value;
				break;
			}
		}

		if (bFlag == false) {
			alert('性别不能为空，请选择！')
			document.getElementById('gender').focus();
			return false;
		}

		var tdUsername = document.createElement('td');
		var textUsernameNode = document.createTextNode(usernameval);
		tdUsername.appendChild(textUsernameNode);

		var tdEmail = document.createElement('td');
		var textEmailNode = document.createTextNode(emailval);
		tdEmail.appendChild(textEmailNode);

		var tdGender = document.createElement('td');
		var textGenderNode = document.createTextNode(genderval);
		tdGender.appendChild(textGenderNode);
		
		var tdOption = document.createElement('td');
		var aNode = document.createElement('a');
		var aTextNode=document.createTextNode('删除');
		aNode.appendChild(aTextNode);
//		aNode.href='www.baidu.com';
		
		aNode.onclick=function(){
			aNode.parentNode.parentNode.parentNode.removeChild(aNode.parentNode.parentNode);
			return false;
		}
		
		tdOption.appendChild(aNode);		

		var tr = document.createElement('tr');
		tr.appendChild(tdUsername);
		tr.appendChild(tdEmail);
		tr.appendChild(tdGender);
		tr.appendChild(tdOption);
		
		var tableNode = document.getElementById('tbl')

		tableNode.appendChild(tr)

	}

}
