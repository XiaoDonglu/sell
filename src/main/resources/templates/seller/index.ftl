<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/sell/seller/login">
                        <div class="form-group">
                            <label>用户名</label>
                            <input name="username" type="text" class="form-control" style="width: 200px"/>
                        </div>
                        <div class="form-group">
                            <label>密码</label>
                            <input name="password" type="password" class="form-control" style="width: 200px"/>
                        </div>
                        <button type="submit" class="btn btn-default">登录</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>