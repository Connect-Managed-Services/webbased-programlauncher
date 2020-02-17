function sendingRequest(val) {
	console.log(val);
	$("input.btn").prop("disabled", true);
	$("input.btn").css("pointer-events", "none");
	debugger;
	visiblefootercard(val,"Sending Request from Web Interface for : ","#20B2AA",val);
	setTimeout(function(){ 
	var jqxhr = $.get("sendTicketParam?ticketPriorityName=" + val, function(data) {
		if (data === "success"){
			visiblefootercard(val,"Response getting from Server  : ","#90EE90",data);
			$("input.btn").prop("disabled", false);
			$("input.btn").css("pointer-events", "auto");
		}else{
			visiblefootercard(val,"Response getting from Server  : ","#dc3545",data);
			setTimeout(function(){ 
				$('#' + val).hide();
				$("input.btn").prop("disabled", false);
				$("input.btn").css("pointer-events", "auto");
			}, 5000);
			
		}
	}).fail(function() {
		visiblefootercard(val,"Response getting from Server  : ","#dc3545",data);
	}).always(function() {
		setTimeout(function(){ 
			$('#' + val).hide();
		}, 3000);
	});
	}, 1000);
}

function visiblefootercard(val,message, color , data){
	
	if($('#' + val).is(":visible")){
		$('#' + val).css("background-color", color);
		$('#' + val).html(message + "" + data);
	}else{
		$('#' + val).css("background-color", color);
		$('#' + val).show().html(message + "" + data);
	}
	
}