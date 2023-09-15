// Function to handle submitting the package form
function handlePackageSubmit(event) {
    event.preventDefault();
    const id = document.getElementById('packageId').value;
    const packageType = document.querySelector('input[name="packageType"]:checked').value;
    const services = document.getElementById('services').value;
    const price = document.getElementById('price').value;
    const description = document.getElementById('description').value;

    //display a confirmation message
    alert(`Package added successfully. ID: ${id}, Type: ${packageType}, Services: ${services}, Price: ${price}, Description: ${description}`);
}

// Attach a submit event handler to the package form
document.getElementById('packageForm').addEventListener('submit', handlePackageSubmit);
