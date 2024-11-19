document.getElementById('cadastroForm').addEventListener('submit', function(event) {
    event.preventDefault(); 

    
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const role = document.getElementById('role').value;
	const age = document.getElementById('age').value;
    
    const usuarioData = {
        username: username,
        password: password,
        role: role,
		
		// Felipe -> INI - adicionando atributos para acrescentar o modelo de rating *********
		age: age
		// Felipe -> FIM - *******************************************************************
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
    })
    .catch(error => {
        alert('Erro: ' + error.message);
    });
});
