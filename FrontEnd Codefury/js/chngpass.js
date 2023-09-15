// validation of change password

function changePass(event){
    event.preventDefault();
    fetch('../js/user.json')
    .then(res=>res.json())
    .then(data=>{

        var op=document.getElementById("old-password").value;
        var np=document.getElementById("new-password").value;
        var cp=document.getElementById("confirm-password").value;
       const res= cp.localeCompare(np);
   
    if(op=='' ){
        document.getElementById("opass-msg").innerHTML="Please enter the current password";
        document.getElementById("cpass-msg").innerHTML="";
        document.getElementById("npass-msg").innerHTML="";
        return false;
    }
    if(op!=data.users[0].Password ){
        document.getElementById("opass-msg").innerHTML="Current password is invalid";
        document.getElementById("cpass-msg").innerHTML="";
        document.getElementById("npass-msg").innerHTML="";
        return false;
    }

    //check the value of password is empty or not
    if(np==''){
        document.getElementById("npass-msg").innerHTML="Please enter the new password";
        document.getElementById("cpass-msg").innerHTML="";
        document.getElementById("opass-msg").innerHTML="";
        return false;
    }

    if(cp==''){
        document.getElementById("cpass-msg").innerHTML="Please enter the confirm password";
        document.getElementById("opass-msg").innerHTML="";
        document.getElementById("npass-msg").innerHTML="";
        return false;
    }

    if(res==(-1) ){
        document.getElementById("cpass-msg").innerHTML="Confirm password is not same as New password";
        document.getElementById("opass-msg").innerHTML="";
        document.getElementById("npass-msg").innerHTML="";
        
    }else{
        alert("Password is changed");
        data.users[0].Password=np;
        console.log(data.users[0].Password);
    }
    
});
}