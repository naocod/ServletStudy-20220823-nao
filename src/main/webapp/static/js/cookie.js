
load();

function load() {
	$.ajax({
		async: false,
		type: "get",
		url: "/cookie/test",
		data: {
			flag : true 
		},
		dataType: "json",
		success: (response) => {
			getList(response.cookies);
		},
		error: (error) => {
			console.log(error);
		}
	});
	
}

function getList(cookies) {
	const tbody = document.querySelector("tbody");
	
	tbody.innerHTML = "";
	
	for(let i = 0; i < cookies.length; i++) {
		tbody.innerHTML = `
			<tr>
				<td>${i + 1}</td>
				<td>${cookies[i].name}</td>
				<td>${cookies[i].value}</td>
				<td>${cookies[i].domain}</td>
				<td>${cookies[i].path}</td>
				<td>${cookies[i].masAge}</td>
			</tr>
		`
	}
}