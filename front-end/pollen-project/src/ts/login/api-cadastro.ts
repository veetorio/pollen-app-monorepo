// Seleciona especificamente o formulário de cadastro
const formCadastro = document.querySelector('form#registerForm');

console.log('📋 api-cadastro.ts carregado. Form encontrado?', !!formCadastro);

if (formCadastro) {
  // Cria ou obtém o elemento de mensagem
  let mensagemDiv = formCadastro.querySelector('.cadastro-mensagem');
  if (!mensagemDiv) {
    mensagemDiv = document.createElement('div');
    mensagemDiv.className = 'cadastro-mensagem';
    formCadastro.insertBefore(mensagemDiv, formCadastro.querySelector('.auth-form__submit'));
  }

  formCadastro.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();

    const nomeInput = formCadastro.querySelector('#name') as HTMLInputElement;
    const emailInput = formCadastro.querySelector('#email') as HTMLInputElement;
    const senhaInput = formCadastro.querySelector('#senha') as HTMLInputElement;

    if (!nomeInput || !emailInput || !senhaInput) {
      console.error('❌ Campos de cadastro não encontrados');
      mensagemDiv.textContent = 'Erro: Formulário de cadastro inválido.';
      mensagemDiv.className = 'cadastro-mensagem cadastro-mensagem-erro';
      return;
    }

    const nome = nomeInput.value.trim();
    const email = emailInput.value.trim();
    const senha = senhaInput.value.trim();

    if (!nome || !email || !senha) {
      mensagemDiv.textContent = 'Preencha nome, email e senha corretamente.';
      mensagemDiv.className = 'cadastro-mensagem cadastro-mensagem-erro';
      return;
    }

    mensagemDiv.textContent = '';
    mensagemDiv.className = 'cadastro-mensagem';

    try {
      console.log('🔵 Enviando POST para /usuario:', { nome, email, senha });

      const baseUrl = 'http://localhost:8080';
      const resposta = await fetch(`${baseUrl}/usuario`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          nome,
          email,
          senha,
          tipo: 'CONTRIBUIDOR',
        }),
      });

      console.log('📊 Status HTTP cadastro:', resposta.status, resposta.statusText);

      if (resposta.ok) {
        mensagemDiv.textContent = 'Cadastro realizado com sucesso! Você já pode entrar.';
        mensagemDiv.className = 'cadastro-mensagem cadastro-mensagem-sucesso';

        nomeInput.value = '';
        emailInput.value = '';
        senhaInput.value = '';

        // Alterna para a aba de login 1s depois
        setTimeout(() => {
          const botaoLogin = document.querySelector('[data-view-toggle="login"]') as HTMLElement;
          if (botaoLogin) botaoLogin.click();
        }, 1000);

      } else {
        const payload = await resposta.json().catch(() => ({}));
        const mensagemErro = payload.mensagem || payload.message || payload.error || 'Erro no cadastro. Tente novamente.';
        console.error('❌ Erro de cadastro:', resposta.status, mensagemErro);
        mensagemDiv.textContent = 'Erro no cadastro: ' + mensagemErro;
        mensagemDiv.className = 'cadastro-mensagem cadastro-mensagem-erro';
      }
    } catch (erro) {
      console.error('❌ Erro de conexão no cadastro:', erro);
      const mensagemErro = erro instanceof Error ? erro.message : 'Erro desconhecido';
      mensagemDiv.textContent = 'Erro ao conectar com o servidor: ' + mensagemErro;
      mensagemDiv.className = 'cadastro-mensagem cadastro-mensagem-erro';
    }
  });
}
