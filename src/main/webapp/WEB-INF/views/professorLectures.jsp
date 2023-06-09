<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title></head>
<body>
<hr>
<table border="1" id="lectureTable">
    <tbody>
    <th>강의명</th>
    <th>교수명</th>
    <th>교수연락처</th>
    <th>학점</th>
    <th>상세보기</th>
    </tbody>
</table>
<script>
    let lectures = [];
    fetch('/lectures/professor', {
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


                    let detailTd = document.createElement("td");
                    let button = document.createElement("button");
                    button.innerHTML = "상세보기"; // 버튼 텍스트 설정
                    button.onclick = function () {
                        fetch('/lectures?id=' + lecture.id,
                            {
                                method: "GET",
                                headers: {
                                    'Content-Type': 'application/json'
                                }
                            }
                        )
                    };
                    detailTd.appendChild(button);
                    row.appendChild(detailTd);
                    tbody.appendChild(row);
                }
            }
        )
</script>
