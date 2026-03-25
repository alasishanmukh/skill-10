<!DOCTYPE html> 
<html> 
<head> 
<title>Student Manager</title> 
<!-- React CDN --> 
<script 
src="https://unpkg.com/react@18/umd
/react.development.js"></script> 
<script src="https://unpkg.com/react
dom@18/umd/react
dom.development.js"></script> 
<script src="https://unpkg.com/babel
standalone@6/babel.min.js"></script> 
<style> 
body { 
font-family: Arial; 
      background-color: #f4f4f4; 
      padding: 20px; 
    } 
    .container { 
      width: 500px; 
      margin: auto; 
      background: white; 
      padding: 20px; 
      border-radius: 10px; 
      box-shadow: 0 0 10px gray; 
    } 
    input { 
      margin: 5px; 
      padding: 8px; 
      width: 90%; 
    } 
    button { 
      padding: 8px 12px; 
      margin: 5px; 
      border: none; 
      background-color: #007bff; 
      color: white; 
      cursor: pointer; 
    } 
    button.delete { 
      background-color: red; 
    } 
    table { 
      width: 100%; 
      margin-top: 10px; 
border-collapse: collapse; 
} 
th, td { 
border: 1px solid #ddd; 
padding: 8px; 
text-align: center; 
} 
th { 
background-color: #007bff; 
color: white; 
} 
</style> 
</head> 
<body> 
<div id="root"></div> 
<script type="text/babel"> 
const { useState } = React; 
function StudentManager() { 
const [students, setStudents] = 
useState([ 
{ id: 1, name: "Mounika", course: 
"CSE" }, 
{ id: 2, name: "Ravi", course: "ECE" 
}, 
}, 
{ id: 3, name: "Anjali", course: "IT" }, 
{ id: 4, name: "Kiran", course: "EEE" 
{ id: 5, name: "Sita", course: "MBA" 
} 
]); 
const [newStudent, setNewStudent] 
= useState({ 
id: "", 
name: "", 
course: "" 
}); 
const handleChange = (e) => { 
setNewStudent({ 
...newStudent, 
[e.target.name]: e.target.value 
}); 
}; 
const addStudent = () => { 
if (!newStudent.id || 
!newStudent.name || 
!newStudent.course) { 
alert("Please fill all fields"); 
return; 
} 
setStudents([...students, 
newStudent]); 
setNewStudent({ id: "", name: "", 
course: "" }); 
}; 
 
      const deleteStudent = (id) => { 
        const updated = students.filter(s => 
s.id !== id); 
        setStudents(updated); 
      }; 
 
      return ( 
        <div className="container"> 
          <h2>Student Manager</h2> 
 
          <input 
            type="text" 
            name="id" 
            placeholder="Enter ID" 
            value={newStudent.id} 
            onChange={handleChange} 
          /> 
          <input 
            type="text" 
            name="name" 
            placeholder="Enter Name" 
            value={newStudent.name} 
            onChange={handleChange} 
          /> 
          <input 
            type="text" 
            name="course" 
            placeholder="Enter Course" 
            value={newStudent.course} 
            onChange={handleChange} 
          /> 
 
          <button onClick={addStudent}>Add 
Student</button> 
 
          {students.length === 0 ? ( 
            <p>No students available</p> 
          ) : ( 
            <table> 
              <thead> 
                <tr> 
                  <th>ID</th> 
                  <th>Name</th> 
                  <th>Course</th> 
                  <th>Action</th> 
                </tr> 
              </thead> 
              <tbody> 
                {students.map((s) => ( 
                  <tr key={s.id}> 
                    <td>{s.id}</td> 
                    <td>{s.name}</td> 
                    <td>{s.course}</td> 
                    <td> 
                      <button 
                        className="delete" 
                        onClick={() => 
deleteStudent(s.id)} 
                      > 
                        Delete 
</button> 
</td> 
</tr> 
))} 
</tbody> 
</table> 
)} 
</div> 
); 
} 
ReactDOM.createRoot(document.getEle
mentById("root")).render(<StudentMan
ager />); 
</script> 
</body> 
</html> 