(function () {
    const modal = document.getElementById('authModal');
    if (!modal) return;
    const body = document.body;
    const openSignup = document.getElementById('navSignup');
    const openLogin = document.getElementById('navLogin');
    const closeElements = modal.querySelectorAll('[data-modal-close]');
    const tabButtons = modal.querySelectorAll('[data-view-toggle]');
    const forms = modal.querySelectorAll('[data-view]');

    function setView(view: string) {
        tabButtons.forEach((btn) => {
            const htmlBtn = btn as HTMLElement;
            htmlBtn.classList.toggle('is-active', htmlBtn.dataset.viewToggle === view);
        });
        forms.forEach((form) => {
            const htmlForm = form as HTMLElement;
            htmlForm.classList.toggle('is-active', htmlForm.dataset.view === view);
        });
    }

    function openModal(view: string) {
        setView(view);
        (modal as HTMLElement).setAttribute('aria-hidden', 'false');
        (modal as HTMLElement).classList.add('is-visible');
        body.classList.add('modal-open');
    }

    function closeModal() {
        (modal as HTMLElement).setAttribute('aria-hidden', 'true');
        (modal as HTMLElement).classList.remove('is-visible');
        body.classList.remove('modal-open');
    }

    if (openSignup) {
        openSignup.addEventListener('click', (event) => {
            event.preventDefault();
            openModal('signup');
        });
    }

    if (openLogin) {
        openLogin.addEventListener('click', (event) => {
            event.preventDefault();
            openModal('login');
        });
    }

    closeElements.forEach((element) => {
        element.addEventListener('click', closeModal);
    });

    tabButtons.forEach((button) => {
        button.addEventListener('click', () => {
            const htmlButton = button as HTMLElement;
            setView(htmlButton.dataset.viewToggle);
        });
    });

    modal.addEventListener('click', (event) => {
        if (event.target === modal) {
            closeModal();
        }
    });

    document.addEventListener('keydown', (event) => {
        if (event.key === 'Escape' && modal.classList.contains('is-visible')) {
            closeModal();
        }
    });
})();