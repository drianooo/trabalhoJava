document.getElementById("btnContinuar").addEventListener("click", () => {
    document.getElementById("dialog").close();
});

// Abrir o diálogo se o cadastro for bem-sucedido
document.addEventListener("DOMContentLoaded", () => {
    const cadastroSucesso = /*[[${cadastroSucesso}]]*/;
    console.log(cadastroSucesso);
    if (cadastroSucesso) {
        document.getElementById("dialog").showModal();
    }
});