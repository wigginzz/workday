<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                    + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>Workday</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <style type="text/css">
        * {
            margin: 0px;
            padding: 0px;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            -ms-box-sizing: border-box;
            box-sizing: border-box;
        }

        .copy {
            text-align: left;
            font-size: large;
            padding: 20px;
        }

        .copy a {
            color: #e0e0e0;
            padding: 20px 20px 0px 0px;
            text-decoration: underline;
        }

        .copy a:HOVER {
            color: white;
        }

        body {
            background-color: #005999;
            text-align: center;
            position: relative;
        }

        .copright {
            padding: 20px;
            color: #e0e0e0;
            text-align: right;
        }

        .gallary {
            display: flex;
            justify-content: center;
        }

        .gallary .item {
            position: relative;
            display: inline;
            margin: 150px 15px 0px 15px;
            border: 10px solid #f0f0f0;
            float: left;
            width: 250px;
            height: 180px;
            overflow: hidden;
            -webkit-box-shadow: 5px 5px 5px #111;
            box-shadow: 5px 5px 5px #303030;
        }

        .gallary .item img {
            width: 250px;
            height: 180px;
            -webkit-transition: all 1s ease;
            -moz-transition: all 1s ease;
            -o-transition: all 1s ease;
            -ms-transition: all 1s ease;
            transition: all 1s ease;
            position: absolute;
            left: 0px;
            top: 0px;
        }

        .gallary .item img:HOVER {
            width: 300px;
            height: 216px;
            left: -25px;
            top: -18px;
        }

        .gallary span {
            color: white;
            padding: 5px 10px;
            display: block;
            position: absolute;
            background-color: #005999;
        }
    </style>
    <script type="application/javascript">
        function loaded() {
            var canvas = document.querySelector("canvas");
            canvas.width = window.innerWidth;
            canvas.height = window.innerHeight;
            canvas.style.position = "absolute";
            canvas.style.left = "0px";
            canvas.style.top = "0px";
            canvas.style.zIndex = "-100";

            var ctx = canvas.getContext("2d");

            var TAU = 2 * Math.PI;

            var times = [];

            function loop() {
                ctx.clearRect(0, 0, canvas.width, canvas.height);
                update();
                draw();
                requestAnimationFrame(loop);
            }

            function Ball(startX, startY, startVelX, startVelY) {
                this.x = startX || Math.random() * canvas.width;
                this.y = startY || Math.random() * canvas.height;
                this.vel = {
                    x: startVelX || Math.random() * 2 - 1,
                    y: startVelY || Math.random() * 2 - 1
                };
                this.update = function (canvas) {
                    if (this.x > canvas.width + 50 || this.x < -50) {
                        this.vel.x = -this.vel.x;
                    }
                    if (this.y > canvas.height + 50 || this.y < -50) {
                        this.vel.y = -this.vel.y;
                    }
                    this.x += this.vel.x;
                    this.y += this.vel.y;
                };
                this.draw = function (ctx, can) {
                    ctx.beginPath();
                    ctx.globalAlpha = .4;
                    ctx.fillStyle = '#448fda';
                    ctx.arc((0.5 + this.x) | 0, (0.5 + this.y) | 0, 3, 0, TAU, false);
                    ctx.fill();
                }
            }

            var balls = [];
            for (var i = 0; i < canvas.width * canvas.height / (65 * 65); i++) {
                balls.push(new Ball(Math.random() * canvas.width, Math.random() * canvas.height));
            }

            var lastTime = Date.now();

            function update() {
                var diff = Date.now() - lastTime;
                for (var frame = 0; frame * 16.6667 < diff; frame++) {
                    for (var index = 0; index < balls.length; index++) {
                        balls[index].update(canvas);
                    }
                }
                lastTime = Date.now();
            }

            var mouseX = -1e9, mouseY = -1e9;
            document.addEventListener('mousemove', function (event) {
                mouseX = event.clientX;
                mouseY = event.clientY;
            });

            function distMouse(ball) {
                return Math.hypot(ball.x - mouseX, ball.y - mouseY);
            }

            function draw() {
                ctx.globalAlpha = 1;
                ctx.fillStyle = '#005999';
                ctx.fillRect(0, 0, canvas.width, canvas.height);
                for (var index = 0; index < balls.length; index++) {
                    var ball = balls[index];
                    ball.draw(ctx, canvas);
                    ctx.beginPath();
                    for (var index2 = balls.length - 1; index2 > index; index2 += -1) {
                        var ball2 = balls[index2];
                        var dist = Math.hypot(ball.x - ball2.x, ball.y - ball2.y);
                        if (dist < 100) {
                            ctx.strokeStyle = "#448fda";
                            ctx.globalAlpha = 1 - (dist > 100 ? .8 : dist / 150);
                            ctx.lineWidth = "2px";
                            ctx.moveTo((0.5 + ball.x) | 0, (0.5 + ball.y) | 0);
                            ctx.lineTo((0.5 + ball2.x) | 0, (0.5 + ball2.y) | 0);
                        }
                    }
                    ctx.stroke();
                }
            }

            // Start
            loop();
        }

    </script>
</head>

<body onload="loaded()">
<canvas></canvas>
<table width="100%" height="100%">
    <tr height="30px;">
        <td>
            <div class="copy">
                <a href="http://se-cim-ennwifi-test.opaas.enncloud.cn/doc/index">API文档</a></span>
                <a href="adminindex">管理系统</a>
            </div>
        </td>
    </tr>
    <tr>
        <td valign="middle" align="center">
            <div>
                <img src="img/cim_logo_big.png" alt="">
            </div>
            <div class="gallary">
                <div class="item">
                    <img src="img/cim_model.png">
                    <span>模型</span>
                </div>
                <div class="item">
                    <img src="img/cim_site.png">
                    <span>现场</span>
                </div>
                <div class="item">
                    <img src="img/cim_api.png">
                    <span>API</span>
                </div>
                <div class="item">
                    <img src="img/cim_console.png">
                    <span>控制台</span>
                </div>
            </div>
        </td>
    </tr>
    <tr height="30px;">
        <td>
            <div class="copright">
                &copy; 2017-2018 泛能网络科技
            </div>
        </td>
    </tr>
</table>


</body>
</html>
                                                                                     