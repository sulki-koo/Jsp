<%@ page contentType="text/html; charset=UTF-8"%>

<body>
    <div id="container">
        <header>
            <h1>MY WEBSITE</h1>
            <div id="loginlink">
            	<%if(session.getAttribute("sid")==null) {%>
        		<form action="loginProc.jsp" method="post">
        			id: <input type="text" name="mid">
            		pass: <input type="password" name="mpass">
            		<input type="submit" value="login">
        		</form>
        		<% } else {%>
        			<p>
        				<%= session.getAttribute("sid") %>(<%= session.getAttribute("sname") %>)님&nbsp;로그인중&nbsp;&nbsp;
        				<button onclick="location.href='logout.jsp';">로그아웃</button>
        			</p>
        		<% } %>
        		</div>
        </header>
        <p id="mainbanner">
            <a href="#new img"><img src="img/비누방울.jpg"></a>
        </p>
        <nav>
            <input class="nav-toggle" id="nav-toggle" type="checkbox">
            <label class="navicon" for="nav-toggle"><span class="navicon-bar"></span></label>
            <ol id="totalmemu">
                <li><a href="#1"></a>MENU1</li>
                <li><a href="#2"></a>MENU2</li>
                <li><a href="#3"></a>MENU3</li>
                <li><a href="#4"></a>MENU4</li>
            </ol>
        </nav>
        <section>
            <nav>
                <ol id="menu1-1">
                    <li>MENU 1-1</li>
                    <li>MENU 1-2</li>
                    <li>MENU 1-3</li>
                    <li>MENU 1-4</li>
                    <li>MENU 1-5</li>
                </ol>
            </nav>
            <article>메뉴 1-1의 컨텐츠입니다.
                어느새 설날이 다가왔습니다.
                이때가 되면 생각하는 것은 하나님은 우리에게 또 한 장의 도화지를 주셨다고 생각합니다.
                '1년 365일'시간(時間)이라는 도화지(圖畵紙) 위에 실천(實踐)이라는 붓으로, 우리는 인생(人生)이라는 그림을 그리는 것이라 생각을 해봅니다.
                그래서 2004년에는 각자 자기가 원하는 그림을 구상하고, 계획하고, 생각하면서, 훌륭한 삶의 그림을 그려야 한다고 생각합니다.
                그런데 그림도 무작정 그리면 안됩니다.
                열정과 패기를 가지고, 철저한 계획과 준비와 끊임없이 훈련하면서 그려야 합니다.
                거기에 언제나 '상냥한 웃음'과 '아름다운 친절'과 '존경의 인사'라는 '물감'을 사용한다면 더욱더 아름다운 그림이 그려지리라 생각합니다. 물론 거기에 '지혜(智慧)'라는 물감까지
                첨가하면 더욱 좋겠지요.
                그림이라는 말을 쓰니 그 옛날 "한니발 장군"의 일화가 생각납니다.
                한니발 장군은 나폴레옹보다 거의 2천년 가까이 앞선 BC 217년에 알프스 산맥을 넘어 로마로 진군했던 '카르타고'의 명장(名將)입니다. 그가 이탈리아 남부 칸나에 평원에서 로마군을
                박살낸 ‘칸나에 전투’는 세계 모든 육사(陸士) 교과서에서 다뤄질 정도입니다 . 한니발 장군 부대는 프랑스를 점령하고 알프스산맥을 넘어 세계 최강의 로마를 점령했습니다.
                한니발 장군이 젊었을 때 이야기입니다.
                한니발 장군의 외형은 불행히도 애꾸눈이었습니다.
                그래서 항상 콤플렉스를 지니고 있었습니다.
                어느날 화가에게 자기 초상화를 그려달라고 했습니다. 그 화가는 사실 그대로 애꾸눈인 한니발 얼굴 모습으로 그렸습니다. 그러자 한니발은 애꾸눈인 자화상을 보면서 화를 내면서 그 화가를
                꾸짖었습니다. 이번에는 다른 화가에게 부탁했습니다. 이번 화가는 앞의 화가처럼 그리면 혼날 것이 뻔하기에 정상적인 눈을 가진 초상화를 그렸습니다. 한니발은 이번에도 화를 냈습니다. 자기의
                모습이 아니라는 것입니다.
                또 다른 화가에게 맡겼습니다.
                세 번째 화가는 한니발 장군을 비스듬히 앉히고 옆에서 애꾸눈이 안 보이는 정상적인 눈만 보이도록 비스듬히 앉히고 다른 각도에서 초상화를 그렸습니다. 나중에 완성된 그림을 보고 이 화가의
                지혜를 칭찬하였다고 합니다.
                그렇습니다. 고정관념을 버리면서 새로운 창의적인 생각으로 삶의 지혜를 갖고 인생을 살아가야 합니다.
                바야흐로 한해를 설계하고 소망을 갖는 1월입니다.
                올 한해, 자기가 목표한 것에 도달하기 위해 어느 조직의 경영이든, 개인적인 생활이든 , 자신과의 약속을 지키는 것이 중요하리라 생각합니다. 그리고 올 한해 따뜻한 마음을 가지고 서로
                나누고 베푸는 한해가 되었으면 합니다.
                우리가 잘 아는 영어의 커뮤니케이션(communication)이라는 말이 있습니다.
                굳이 우리말로 옮기면 소통, 연락, 전달 등의 뜻이 되는 이 말은 어원(語源)이 라틴어 커뮤니카레에서 비롯됐습니다. 라틴어 커뮤니카레는 '나누다' 라는 뜻입니다. 즉
                커뮤니케이션(communication)은 서로 나누는 것입니다.
                2004년------- 서로 사랑을 나누고, 미소를 나누고, 정보를 나누고, 정을 나누고......
                그래야 우리의 삶이 " 천국의 계단"으로 하나씩 오르는 것이 아닐까요??????.
                요즈음 인기있는 책이 있습니다.
            </article>
        </section>