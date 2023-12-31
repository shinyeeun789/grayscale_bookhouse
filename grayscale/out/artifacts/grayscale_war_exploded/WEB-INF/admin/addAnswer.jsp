<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> 질문 글 작성 </title>
    <c:set var="path" value="<%=request.getContextPath()%>" />
    <%@ include file="../../encoding.jsp"%>
    <%@ include file="../../common.jsp"%>

    <style>
        .form-control:disabled {
            opacity: 1;
            border: none;
        }
    </style>
</head>
<body>
<div class="container-fluid m-0 p-0">
    <%@ include file="../../header.jsp"%>
    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__text">
                        <h4> 답변 글 작성 </h4>
                        <div class="breadcrumb__links">
                            <a href="${path}/">Home</a>
                            <a href="javascript: history.go(-1)"> Q&A </a>
                            <span> 답변 글 작성 </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <div class="container-fluid px-4 mt-5 mb-5">
        <div class="row justify-content-md-center">
            <div class="col-sm-8 mb-3 mb-sm-0">
                <div class="card w-100 mb-3">
                    <div class="card-body">
                        <div class="form-outline mb-4">
                            <h4> 질문내용 </h4>
                        </div>
                        <div class="form-outline mb-4">
                            <label for="title" class="form-label"> 제목 </label>
                            <input type="text" class="form-control" value="${qna.title}" readonly>
                        </div>
                        <div class="form-outline mb-4">
                            <label for="content" class="form-label"> 내용 </label>
                            <textarea class="form-control" rows="10" readonly>${qna.content}</textarea>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row justify-content-md-center">
            <div class="col-sm-8 mb-3 mb-sm-0">
                <div class="card w-100 mb-3">
                    <div class="card-body">
                        <form action="${path}/AddQnaPro.do" method="post">
                            <div class="form-outline mb-4">
                                <h4> 답변 작성 </h4>
                            </div>
                            <div class="form-outline mb-4">
                                <label for="title" class="form-label"> 제목 </label>
                                <input type="text" class="form-control" id="title" name="title" required>
                                <input type="hidden" id="par" name="par" value="${qna.qno}">
                                <input type="hidden" id="lev" name="lev" value="1">
                            </div>
                            <div class="form-outline mb-4">
                                <label for="content" class="form-label"> 내용 </label>
                                <textarea class="form-control" id="content" name="content" rows="10"></textarea>
                            </div>
                            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                                <input type="submit" class="btn btn-dark btn-block gradient-custom-4" value="글 등록하기">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="../../footer.jsp" %>
</div>
</body>
</html>
