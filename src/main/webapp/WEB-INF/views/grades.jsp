<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title></head>
<body>
<%
    String role = (String) session.getAttribute("role");
%>
<h1>나의 학점</h1>
<p>표시되지 않는 강의는 성적 입력 전입니다.</p>
<hr>
<%
    if (role.equals("STUDENT")) {
%>
<table border="1" id="gradeTable">
    <tbody>
    <th>강의명</th>
    <th>교수명</th>
    <th>학생명</th>
    <th>학번</th>
    <th>성적</th>
    <th>학점</th>
    </tbody>
</table>
<script>
    let grades = [];
    fetch('/grade', {
        method: "GET",
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(async res => {
            grades = await res.json();
            console.log(grades);
            let table = document.getElementById("gradeTable");
            let tbody = table.querySelector("tbody");
            for (let i = 0; i < grades.length; i++) {
                let grade = grades[i];
                let row = document.createElement("tr");
                let lectureName = document.createElement("td");
                lectureName.textContent = grade.lectureName;
                row.appendChild(lectureName);

                let professorName = document.createElement("td");
                professorName.textContent = grade.professorName;
                row.appendChild(professorName);

                let studentName = document.createElement("td");
                studentName.textContent = grade.studentName;
                row.appendChild(studentName);

                let studentIdNumber = document.createElement("td");
                studentIdNumber.textContent = grade.studentIdNumber;
                row.appendChild(studentIdNumber);

                let gradeValue = document.createElement("td");
                gradeValue.textContent = grade.grade;
                row.appendChild(gradeValue);

                let credit = document.createElement("td");
                credit.textContent = grade.credit+"학점";
                row.appendChild(credit);

                tbody.appendChild(row);
            }
        })
</script>
<%
    }
%>
<hr>
<button onclick="location.replace('/')">홈으로 돌아가기</button>
<button onclick=logout()>로그아웃</button>
<script>
    function logout(){
        fetch('/logout', {
            method: "GET"
        })
            .then(async res => {
                let body = await res.json();
                if (res.status === 200) {
                    alert(body.message);
                    location.replace('/');
                }
                if (res.status === 403) {
                    alert(body.message);
                    location.reload();
                }
            })
    }
</script>
</body>
</html>
