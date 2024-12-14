const baseUrl = "http://localhost:8080/auth";

// Login
document.getElementById("loginForm")?.addEventListener("submit", async (e) => {
    e.preventDefault();
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    const response = await fetch(`${baseUrl}/login`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({ email, password }),
    });

    if (response.ok) {
        const data = await response.json();
        localStorage.setItem("token", data.token); // Save JWT token
        alert("Login successful!");
        window.location.href = "home.html"; // Redirect to home page
    } else {
        alert("Invalid login credentials.");
    }
});

// Register
document.getElementById("registerForm")?.addEventListener("submit", async (e) => {
    e.preventDefault();
    const firstName = document.getElementById("firstName").value;
    const lastName = document.getElementById("lastName").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    const response = await fetch(`${baseUrl}/register`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({ firstName, lastName, email, password }),
    });

    if (response.ok) {
        alert("Registration successful! Please log in.");
        window.location.href = "login.html";
    } else {
        alert("Registration failed. Try again.");
    }
});
