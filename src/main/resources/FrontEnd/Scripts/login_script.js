// JavaScript for handling login (to be implemented)
document.getElementById('login-form').addEventListener('submit', function(event) {
    event.preventDefault();

    // Retrieve the username and password values from the form inputs
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // Check if the credentials are correct
    if (username === 'admin' && password === 'admin') {
        // Redirect to the whiteboard page
        window.location.href = 'whiteboard.html';
    } else {
        // If the credentials are incorrect, display an alert
        alert('Invalid credentials. Please try again.');
    }
});

