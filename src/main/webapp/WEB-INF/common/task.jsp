<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var = "count" value = "0"/>
<c:forEach items = "${tasks}" var = "item">
    <c:if test="${count != item.categoryId}">
        <c:forEach items = "${categories}" var = "category">
            <c:if test="${category.id == item.categoryId}">
                <h3>${category.name}</h3>
            </c:if>
        </c:forEach>
        <c:set var = "category" value="${item.categoryId}"/>
    </c:if>
    <div class = "task">
            <input type="radio" name = "did" value="${item.id}">
            <label for="${item.id}">${item.name}</label>
            <c:if test="${not empty item.limit}"><p>期限：${item.limit}</p></c:if>
            <c:if test="${empty item.limit}"><p>期限：--------</p></c:if>
            <c:if test="${not empty item.description}"><p>詳細：${item.description}</p></c:if>
            <c:if test="${empty item.description}"><p>詳細：--------</p></c:if>
            <p><a href="/task/update?taskid=${item.id}">変更</a></p>
    </div>
    <br>
</c:forEach>
