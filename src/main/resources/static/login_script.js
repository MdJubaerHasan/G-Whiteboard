document.getElementById('login-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    const loginPayload = {
        username: username,
        password: password
    };

    fetch('http://localhost:8080/api/whiteboard/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(loginPayload)
    })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                // Redirect to the whiteboard page
                window.location.href = 'whiteboard.html';
            } else {
                alert(data.message || 'Invalid credentials. Please try again.');
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
});
