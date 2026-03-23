(function () {
    const modal = document.getElementById('authModal');
    const body = document.body;
    const openSignup = document.getElementById('navSignup');
    const openLogin = document.getElementById('navLogin');
    const closeElements = modal.querySelectorAll('[data-modal-close]');
    const tabButtons = modal.querySelectorAll('[data-view-toggle]');
    const forms = modal.querySelectorAll('[data-view]');

    function setView(view) {
        tabButtons.forEach((btn) => {
            btn.classList.toggle('is-active', btn.dataset.viewToggle === view);
        });
        forms.forEach((form) => {
            form.classList.toggle('is-active', form.dataset.view === view);
        });
    }

    function openModal(view) {
        setView(view);
        modal.setAttribute('aria-hidden', 'false');
        modal.classList.add('is-visible');
        body.classList.add('modal-open');
    }

    function closeModal() {
        modal.setAttribute('aria-hidden', 'true');
        modal.classList.remove('is-visible');
        body.classList.remove('modal-open');
    }

    openSignup.addEventListener('click', (event) => {
        event.preventDefault();
        openModal('signup');
    });

    openLogin.addEventListener('click', (event) => {
        event.preventDefault();
        openModal('login');
    });

    closeElements.forEach((element) => {
        element.addEventListener('click', closeModal);
    });

    tabButtons.forEach((button) => {
        button.addEventListener('click', () => {
            setView(button.dataset.viewToggle);
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