document.getElementById('cadastroForm').addEventListener('submit', function(event) {
    event.preventDefault(); 

    
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
	//Luiz - Adicionando campo de email
    const email = document.getElementById('email').value;
    const role = document.getElementById('role').value;
	const age = document.getElementById('age').value;
    
    const usuarioData = {
        username: username,
        password: password,
        role: role,
		
		// Felipe -> INI - adicionando atributos para acrescentar o modelo de rating *********
		age: age,
		// Felipe -> FIM - *******************************************************************
		//Luiz - Adicionando atributo de email 
		email: email
    };

   
    fetch('http://localhost:8080/api/registro', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(usuarioData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro ao cadastrar usuário');
        }
        return response.text(); 
    })
    .then(data => {
        alert(data); 
        document.getElementById('cadastroForm').reset(); 
		enviarEmail(email);
    })
    .catch(error => {
        alert('Erro: ' + error.message);
    });
	
	function enviarEmail(email) {
	    const url = `/email?email=${encodeURIComponent(email)}`; 

	    fetch(url, {
	        method: 'GET', 
	    })
	    .then(response => {
	        if (!response.ok) {
	            throw new Error('Erro ao enviar o e-mail!');
	        }
	        return response.text(); 
	    })
	    .then(data => {
	        console.log(data); 
	        alert(data); 
	    })
	    .catch(error => {
	        console.error('Erro:', error);
	        alert('Não foi possível enviar o e-mail. Tente novamente.');
	    });
	}
});
