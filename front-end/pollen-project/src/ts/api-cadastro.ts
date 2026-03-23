const registerForm = document.getElementById("registerForm");
if (registerForm) {
  registerForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const nomeElement = document.getElementById("name");
    const emailElement = document.getElementById("email");
    const senhaElement = document.getElementById("senha");

    if (!nomeElement || !emailElement || !senhaElement) {
      alert("Erro: Um ou mais campos não foram encontrados.");
      return;
    }

    const nome = (nomeElement as HTMLInputElement).value;
    const email = (emailElement as HTMLInputElement).value;
    const senha = (senhaElement as HTMLInputElement).value;

    try {
      const response = await fetch("https://375a1444b38a.ngrok-free.app/usuario", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({ nome, email, senha })
      });

      if (!response.ok) {
        const erro = await response.text();
        alert("Erro ao cadastrar: " + erro);
        return;
      }

      const data = await response.json();
      alert("Usuário cadastrado com sucesso!");
      console.log(data);
    } catch (error) {
        alert("Erro de conexão com o servidor: " + error);
      }
    });
  }