//vendor side view user request page

//creating vendor object
const userPlanRequests = [
    {
        requestId: 1,
        fromDate: '2023-09-15',
        toDate: '2023-09-20',
        servicesNeeded: 'Decoration, Photography, Catering',
        numberOfPersons: 100,
        otherServices: 'Live Band'
    },
];

// Function to generate the table rows for user plan requests
function generateUserPlanRequestRows() {
    const tableBody = document.getElementById('userRequestTableBody');

    userPlanRequests.forEach((request) => {
        const row = tableBody.insertRow();

        const requestIdCell = row.insertCell(0);
        const fromDateCell = row.insertCell(1);
        const toDateCell = row.insertCell(2);
        const servicesNeededCell = row.insertCell(3);
        const numberOfPersonsCell = row.insertCell(4);
        const otherServicesCell = row.insertCell(5);
        const actionCell = row.insertCell(6);

        requestIdCell.textContent = request.requestId;
        fromDateCell.textContent = request.fromDate;
        toDateCell.textContent = request.toDate;
        servicesNeededCell.textContent = request.servicesNeeded;
        numberOfPersonsCell.textContent = request.numberOfPersons;
        otherServicesCell.textContent = request.otherServices;
        actionCell.innerHTML = `<a href="CreateQuotationPage.html">Create Quotation</a>`;
    });
}

// Call the function to generate the table rows when the page loads
window.onload = generateUserPlanRequestRows;
