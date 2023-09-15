// Quotation Page specific JavaScript

// Function to handle submitting the quotation form
function handleQuotationSubmit(event) {
    event.preventDefault();
    const quotationAmount = document.getElementById('quotationAmount').value;

    //display a confirmation message
    alert(`Quotation submitted successfully. Amount: $${quotationAmount}`);
}

// Attach a submit event handler to the quotation form
document.getElementById('quotationForm').addEventListener('submit', handleQuotationSubmit);
