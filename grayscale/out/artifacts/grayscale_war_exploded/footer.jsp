<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<c:set var="path2" value="<%=request.getContextPath()%>"/>
<!-- Footer Section Begin -->
<footer class="footer">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-2 offset-lg-1 col-md-3 col-sm-6">
                <div class="footer__widget">
                    <h6>Shopping</h6>
                    <ul>
                        <li><a href="#"> 인기도서 </a></li>
                        <li><a href="#"> 신규도서 </a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-2 col-md-3 col-sm-6">
                <div class="footer__widget">
                    <h6>Category</h6>
                    <ul>
                        <li><a href="${path}/ProductList.do?cate=A&page=1"> 교과서 </a></li>
                        <li><a href="${path}/ProductList.do?cate=B&page=1"> 참고서 </a></li>
                        <li><a href="${path}/ProductList.do?cate=C&page=1"> 문제집 </a></li>
                        <li><a href="${path}/ProductList.do?cate=D&page=1"> 기타 </a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-2 col-md-3 col-sm-6">
                <div class="footer__widget">
                    <h6>Community</h6>
                    <ul>
                        <li><a href="${path1}/NoticeList.do?page=1"> 공지사항 </a></li>
                        <li><a href="${path1}/QnaList.do?page=1">QnA</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="footer__copyright__text">
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    <p>Copyright ©
                        <script>
                            document.write(new Date().getFullYear());
                        </script>
                        SHINYEEUN | This template is made with <a href="https://colorlib.com" target="_blank">Colorlib</a>
                    </p>
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- Footer Section End -->