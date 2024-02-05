let responseToken;
let emailId;
async function sendOTP() {
    const form = document.getElementById('loginform');
    emailId = form.elements['emailId'].value;
    let params=new URLSearchParams();
    params.append('emailId',emailId);

    try {

        let response= await fetch('/otp/sendOTP',{
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: params,
        });

       if(response.ok){
            responseToken=await response.text();

           console.log(responseToken);
           showOTPPopup();
       }
    }catch (e){
        console.log(e);
    }
}



async function verifyOTP(){
    const otpInputs = document.querySelectorAll('.otpform input[type="number"]');
    let otp ='';
    otpInputs.forEach(singleOtp =>{
        otp+=singleOtp.value;
    });
    let otpParams=new URLSearchParams();
    otpParams.append('otp',otp);
    otpParams.append('authToken',responseToken);
    otpParams.append('emailId',emailId);
    console.log(otpParams);
    try {
        let response=await fetch('/otp/verifyOTP',{
            method:'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: otpParams,
        })
        if(response.ok){
            responseToken="";
            emailId="";
            const matchStatus=await response.text();
            if(matchStatus)
            {
                hideOTPPopup();
                window.location.href = '/registration_page';
            }
        }else{
            hideOTPPopup();
            console.log(response.status);
        }

        }catch(e){
            console.log(e);

        }

}

function showOTPPopup() {
    document.getElementById('overlay').style.display = 'block';
    document.getElementById('otpModal').style.display = 'block';

    const inputs = document.querySelectorAll("input");
    const button = document.querySelector("button");

    inputs[2].focus();
    inputs.forEach((input, index1) => {
        if (index1 < 2) {
            return;
        }
        input.addEventListener("keyup", (e) => {
            const currentInput = input,
            nextInput = input.nextElementSibling,
            prevInput = input.previousElementSibling;

            if (currentInput.value.length > 1) {
                currentInput.value = "";
                return;
            }

            if (nextInput && nextInput.hasAttribute("disabled") && currentInput.value !== "") {
                nextInput.removeAttribute("disabled");
                nextInput.focus();
            }

            if (e.key === "Backspace") {
                inputs.forEach((input, index2) => {
                    if (index1 <= index2 && prevInput) {
                        input.setAttribute("disabled", true);
                        currentInput.value = "";
                        prevInput.focus();
                    }
                });
            }
        });
    });
    window.addEventListener("load", () => inputs[2].focus());

}

function hideOTPPopup() {
    document.getElementById('overlay').style.display = 'none';
    document.getElementById('otpModal').style.display = 'none';
}
