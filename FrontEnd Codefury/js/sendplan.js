// js file for user to send plan request

// fetching user details from json file and check if user status is active or not
// if user is inactive don't let him submit form
//if he is active let him submit form
function plan(){
    fetch('../projectjs/user.json')
    .then(res=>res.json())
    .then(data=>{
        
        const resi=(data.users[0].Status).localeCompare("inactive");
        
       if(resi==0){
        document.getElementById("submit").disabled = true;
       }else{
        document.getElementById("submit").disabled = false;
    }
});
}

// validation of the form
function send(event){
    event.preventDefault();
    var curr=new Date();
    var fr=document.getElementById("from-date").value;
    fr = new Date(fr);
    var to=document.getElementById("to-date").value;
    to = new Date(to);

    var pid=document.getElementById("request-id").value;
    var fd=document.getElementById("from-date").value;
    var td=document.getElementById("to-date").value;
    var sr=document.getElementById("service").value;
    var pl=document.getElementById("person").value;
    var os=document.getElementById("other-service").value;

   
  
    if(pid==''){
        document.getElementById("rid-msg").innerHTML="Please enter the request id";
        return false;
    }
    //check the value of password is empty or not
    if(fd==''){
        document.getElementById("fdate-msg").innerHTML="Please enter the from date";
        
        return false;
    }
    if(fr<=curr){
        document.getElementById("fdate-msg").innerHTML="Please enter the correct from date";
        
        return false;
    }
    
    if(td==''){
        document.getElementById("tdate-msg").innerHTML="Please enter the to date";
        
        return false;
    }

    if(to<=curr || to<fr){
        document.getElementById("tdate-msg").innerHTML="Please enter the correct to date";
        
        return false;
    }
    if(sr==''){
        document.getElementById("service-msg").innerHTML="Please select the service";
        
        return false;
    }
    if(pl==''){
        document.getElementById("people-msg").innerHTML="Please enter the No. of attending people";
        
        return false;
    }
    if(pl<30){
        document.getElementById("people-msg").innerHTML="Please enter the number greater than 30";
        
        return false;
    }
    else{
        alert("Request sent");
        window.location.replace("sendplanreq.html");
    }


}