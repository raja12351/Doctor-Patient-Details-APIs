# Doctor-Patient-Details-APIs
The Task

We have a platform where doctors can register their patients through a mobile or web portal. For this to work we need to build backend APIs to achieve task like:

Adding a doctor & their speciality
Adding a patient & it’s symptom
Suggesting the doctor based on patient’s symptom

# Doctor’s entity

In our database we will have the doctor's name, city, email, phone number, and speciality.

City can have 3 values only i.e. Delhi, Noida, Faridabad
Speciality can have 4 values i.e. Orthopedic, Gynecology, Dermatology, ENT specialist
A doctor can be added or removed from the platform.


# Patient’s entity

In our database we will have the patient's name, city, email, phone number, and symptom.

City can have any value
Symptom can have the following values only
Arthritis, Back Pain, Tissue injuries (comes under Orthopedic speciality)
Dysmenorrhea (comes under Gynecology speciality)
Skin infection, skin burn (comes under Dermatology speciality)
Ear pain (comes under ENT speciality)
A patient can be added or removed from the platform.


Following fields should have the mentioned validations at the backend:

Name (should be at least 3 characters)
City (should be at max 20 characters)
Email (should be a valid email address)
Phone number (should be at least 10 number)

# Suggesting Doctors

There will be another API that will accept patient ID, and suggest the doctors based on the patient location and the symptom.

E.g. 1: If the patient ID that we received as request param in this API, that patient has Arthritis as a symptom then all the doctors of that location who is an Orthopedic will be sent as the response, since Arthritis comes under Orthopedic speciality.


Important Note: This suggesting doctor API  is the evaluating API where the logic needs to be working. The suggested doctor in the API should be based on the symptom of the patient that links to the doctor's speciality. E.g. 2: If a patient has Eye pain then only an ENT specialist doctor should be suggested.

Edge-Case 1: If there isn’t any doctor on that location (i.e. outside Delhi, Noida, Faridabad), the response should be “We are still waiting to expand to your location”

Edge-Case 2: If there isn’t any doctor for that symptom on that location, the response should be “There isn’t any doctor present at your location for your symptom”


How do you need to achieve this task?

You need to use Spring Boot Framework for core functionalities along with Hibernate for carrying out database operations.
Use Swagger to list all your APIs (optional but a very good plus point)
Things to submit:
The expected output is the zip form of the code, shared via a Google drive folder. It should also contain the postman collection that you have used to test the application i.e. created doctors, patients and suggestion API.
Please upload the drive link in this form, you don’t need to email us. Ensure that the drive folder is shared. [Form Link: https://forms.gle/AT86trr8S6kMH7B4A]

Timeline

You have to submit this assignment within 3 days from the time you received the Screening Test Result mail from our side.
You will be informed of the results within 5 working days after your submission via email.
If you pass the selection test, you will be invited for the next and final round.


Use Postman to hit the APIs and these are main postman links:
1.Adding Doctors to the database: localhost:8080/doctor/add-doctor
		Json format:{
    			      "name":"${Doctor's name}",
    			      "city":"Delhi",
    			      "email":"${email@gmail.com}",
    			      "mobileNo":"${number with 10 digit}",
    			      "speciality":"${enum category already defind in the database}"
			    }

2.Adding Patient to the database: localhost:8080/patients/add-patient
		Json format:{
    			      "name":"${Patient's name}",
    			      "city":"Delhi",
    			      "email":"${email@gmail.com}",
    			      "mobileNo":"${number with 10 digit}",
    			      "symptom":"${patient issue}"
			    }

3.Adding Disease to it's respective category so that we can maitain the record according to us: localhost:8080/diseases/add-disease
		Json format:{
    			      "diseaseName":"Tissue injuries",
    			      "speciality":"Orthopedic"
			    }

4.Fetching the Doctors list according to symptom and location: localhost:8080/patients/find-doctors?patientId=${Registered patientId}


* Swagger inbuilt, use "http://localhost:${tomcat-port}/swagger-ui.html" after running the code to hit the APIs.
