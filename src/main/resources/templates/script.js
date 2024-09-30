document.getElementById('cadastroForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Previne o envio padrão do formulário

    // Coleta os dados do formulário
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const role = document.getElementById('role').value;

    // Cria um objeto com os dados do usuário
    const usuarioData = {
        username: username,
        password: password,
        role: role
    };

    // Envia os dados para o backend usando fetch
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
        return response.text(); // ou response.json() se retornar um JSON
    })
    .then(data => {
        alert(data); // Exibe uma mensagem de sucesso ou erro
        document.getElementById('cadastroForm').reset(); // Limpa o formulário após o envio
    })
    .catch(error => {
        alert('Erro: ' + error.message);
    });
});
