<h3 align="center">iQLDT Backend - Java Servlet & MySQL</h3>

### 🚀 Deployment & API

* **Live Demo:** [iqldt-backend.onrender.com](https://iqldt-backend.onrender.com/)
* **API Endpoint:** [`POST`] [iqldt-backend.onrender.com/api_post](https://iqldt-backend.onrender.com/api_post)

> [!NOTE]
> **Cold Start Delay:** Hosted on Render's free instance, the server automatically enters sleep mode after periods of inactivity. The initial request may take up to **50 seconds** to spin up.

**About the iQLDT app:** iQLDT is inspired by iCTSV and eHUST (two official apps from Hanoi University of Science and Technology for students). Currently, I am building three features: Login, Extracurricular Activities, and Timetable.

**Describe:**

The backend is built using Java Servlet following the MVC (Model-View-Controller) pattern. It is responsible for providing an admin web interface for data management and serving JSON data to the iQLDT Android application.

**Features:**

>**1\. Login:**
>
>&emsp;SHA-256 Password Hashing
><img align="center" height="400" alt="image" src="https://github.com/user-attachments/assets/aa620a97-1ca6-4d84-ba3e-dce883ffc31f" />
>

>**2\. Web Admin (CRUD): Create, Read, Update, Delete**
>
><img align="center" height="400" alt="image" src="https://github.com/user-attachments/assets/73496f19-3740-446e-90ae-784ad3f77130" />
>

>**3\. REST API for Android application:**
>
>&emsp;Create "/api_post" endpoint to export article list data in JSON format.
>
><img align="center" height="400" alt="image" src="https://github.com/user-attachments/assets/d3b7d5a2-07e8-43d6-a6a2-b0ed931eada3" />


**Architectural model:** Updating

**Logic code:**
<p align="center">
  <img width="1723" height="603" alt="iQLDT drawio" src="https://github.com/user-attachments/assets/bfc7ac1c-ce86-47e1-b6bf-d613287d0699" />
</p>

**Folder management:**
<p align="center">
  <img height="600" alt="image" src="https://github.com/user-attachments/assets/2be96c5b-cec3-433e-90aa-56adbcb1ede0" />
</p>

**Tech Stack:**
>
>Language: Java
>
>Specification/ API: Jakarta EE/ Java Servlet
>
>Web Server: Apache Tomcat
>
>Database: MySQL
