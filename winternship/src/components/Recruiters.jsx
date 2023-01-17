import React from "react";

//Need to dynamically fill this information with the recruiter data that comes from the api request

function Recruiters(props){
    for(let i = 0; i<2; i++){
        return (
            <div>
                <h2>{props.name}</h2>
                <img alt="recruiter's picture from Linkedin"></img>
                <p>{props.phone}</p>
                <p>{props.email}</p>
            </div>
        );
    }
    
}

export default Recruiter;