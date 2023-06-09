<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title></head>
<body>
<hr>
<%
    String role = (String) session.getAttribute("role");
%>
<%
    if (role.equals("STUDENT")) {
%>
<table border="1" id="lectureTable">
    <tbody>
    <th>강의명</th>
    <th>교수명</th>
    <th>교수연락처</th>
    <th>학점</th>
    <th>수강신청</th>
    </tbody>
</table>
<script>
    let lectures = [];
    fetch('/lectures', {
        method: "GET",
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(async res => {
            lectures = await res.json();
            console.log(lectures);
            let table = document.getElementById("lectureTable");
            let tbody = table.querySelector("tbody");
            for (let i = 0; i < lectures.length; i++) {
                let lecture = lectures[i];
                let row = document.createElement("tr");
                let lectureName = document.createElement("td");
                lectureName.textContent = lecture.name;
                row.appendChild(lectureName);

                let professorName = document.createElement("td");
                professorName.textContent = lecture.professorName;
                row.appendChild(professorName);

                let professorPhoneNumber = document.createElement("td");
                professorPhoneNumber.textContent = lecture.professorPhoneNumber;
                row.appendChild(professorPhoneNumber);

                let credit = document.createElement("td");
                credit.textContent = lecture.credit;
                row.appendChild(credit);


                let registerBtn = document.createElement("td");
                let button = document.createElement("button");
                button.innerHTML = "신청하기"; // 버튼 텍스트 설정
                button.onclick = function () {
                    fetch('/lectures/apply',
                        {
                            method: "POST",
                            headers: {
                                'Content-Type': 'application/json'
                            },
                            body: JSON.stringify({
                                lectureId: lecture.id
                            })
                        }
                    ).then(async res => {
                            if (res.status === 201) {
                                alert("수강신청 성공");
                            }
                        }
                    )
                }
                registerBtn.appendChild(button);
                row.appendChild(registerBtn);

                tbody.appendChild(row);
            }
        })

    function register(lectureId) {
        fetch('/lectures/apply',
            {
                method: "POST",
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    lectureId: lectureId
                })
            }
        ).then(async res => {
                if (res.status === 201) {
                    alert("수강신청 성공");
                }
            }
        )
    }
</script>
<%
} else {
%>
<table border="1" id="lectureTable">
    <tbody>
    <th>강의명</th>
    <th>교수명</th>
    <th>교수연락처</th>
    <th>학점</th>
    </tbody>
</table>
<script>
    let lectures = [];
    fetch('/lectures', {
        method: "GET",
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(async res => {
            lectures = await res.json();
            console.log(lectures);
            let table = document.getElementById("lectureTable");
            let tbody = table.querySelector("tbody");
            for (let i = 0; i < lectures.length; i++) {
                let lecture = lectures[i];
                let row = document.createElement("tr");
                let lectureName = document.createElement("td");
                lectureName.textContent = lecture.name;
                row.appendChild(lectureName);

                let professorName = document.createElement("td");
                professorName.textContent = lecture.professorName;
                row.appendChild(professorName);

                let professorPhoneNumber = document.createElement("td");
                professorPhoneNumber.textContent = lecture.professorPhoneNumber;
                row.appendChild(professorPhoneNumber);

                let credit = document.createElement("td");
                credit.textContent = lecture.credit;
                row.appendChild(credit);

                tbody.appendChild(row);
            }
        })


</script>
<%
    }
%>
<hr>
</body>
</html>