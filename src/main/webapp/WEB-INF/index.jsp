<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="common/common.jsp"%>
    <title>ログインページ</title>
</head>
<body>
<span class="label label-danger">${Error}</span>
<form action="/user/login" method="post">
    <div class="form-group">
        <label for="title">アカウントID</label>
        <input type="email" class="form-control" name="email" id="title"><br>
        <label for="title">パスワード</label>
        <input type="password" class="form-control" name="pass" id="input_pass">
<%--        <button id="btn_passview">表示</button>--%>
    </div>
    <button type="submit">送信</button>
</form><br>
<h2>新規登録は<a href="/user/signup">こちら</a>から。</h2>
</body>
</html>

<%--以下はパスワードを表示させるためのjs
<script>
    window.addEventListener('DOMContentLoaded', function(){

        // (1)パスワード入力欄とボタンのHTMLを取得
        let btn_passview = document.getElementById("btn_passview");
        let input_pass = document.getElementById("input_pass");

        // (2)ボタンのイベントリスナーを設定
        btn_passview.addEventListener("click", (e)=>{

            // (3)ボタンの通常の動作をキャンセル（フォーム送信をキャンセル）
            e.preventDefault();

            // (4)パスワード入力欄のtype属性を確認
            if( input_pass.type === 'password' ) {

                // (5)パスワードを表示する
                input_pass.type = 'text';
                btn_passview.textContent = '非表示';

            } else {

                // (6)パスワードを非表示にする
                input_pass.type = 'password';
                btn_passview.textContent = '表示';
            }
        });

    });
</script>
--%>
