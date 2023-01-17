import React from "react";

function Login(){
    return (
        <div>
            <div>
                <h2>Winternship</h2>
                <label for="username">Username</label>
                <input type="text" id="username"></input><br></br>
                <label for="password">Password</label>
                <input type="text" id="password"></input>
            </div>
            <div>
                <button type="button" id="SignUp">Sign Up</button>
                <button type="button" id="Login">Log in</button>
            </div>
            
        </div>
    
    );
}

export default Login;