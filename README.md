
Tech Stack : 
1. Spring boot in ZohoCatalyst,
2. Mysql in Clever Cloud

   
🚀 API Base URL
https://ems-backend-springboot-50026276785.development.catalystappsail.in/api/employees/

📦 Dummy JSON Payload (for POST/PUT)
json
Copy
Edit
{
  "id": 1,
  "fullName": "John Doe",
  "email": "john.doe@example.com",
  "departmentName": "Development",  // Options: Development, Testing, Technical Support, etc.
  "branchName": "Chennai"          // Options: Chennai, Madurai, Coimbatore, Trichy, etc.
}
⚠️ Note: CORS error will occur if accessed from a frontend in browser. Use tools like Postman for testing.

🛠️ API Endpoints
Method	Endpoint	Description
GET	/	Get all employees
GET	/{id}	Get employee by ID
POST	/	Create a new employee (requires JSON body)
PUT	/{id}	Update an existing employee by ID (requires JSON body)
DELETE	/{id}	Delete an employee by ID

Example for GET by ID:
https://ems-backend-springboot-50026276785.development.catalystappsail.in/api/employees/1
