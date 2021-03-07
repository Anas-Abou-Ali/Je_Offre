<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" style="margin-left: 30px;" href="index.jsp"> <img src="css/logo_don.jpg" class="rounded-circle" width="30" height="30" class="d-inline-block align-top" alt="Logo">J'offre.ma</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">

                <c:choose>
                    <c:when test="${ !empty sessionScope.user }">
                        <li class="nav-item" style="margin-right:30px;">
                            <a class="nav-link" href="upload"><i class="fa fa-plus" aria-hidden="true"></i> Proposer un offre </a>
                        </li>
                        <li class="nav-item">
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fa fa-user" aria-hidden="true">  <c:out value="${sessionScope.user.firstName}" /> </i>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a href="profile" class="dropdown-item"> profile </a>
                                <div class="dropdown-divider"></div>
                                <a type="button" class="dropdown-item" href="login?logout=out" > Log out </a>
                            </div>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <button type="button" class="btn btn-default btn-circle btn-outline" data-toggle="modal" data-target="#connexion" >Se connecter</button>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </nav>
</header>
<!-- Modal -->
<div class="modal fade" id="connexion" tabindex="-1" role="dialog" aria-labelledby="connexionLabel" aria-hidden="true" >
    <div class="modal-dialog modal-dialog-centered" role="document" >
        <div class="modal-content" >
            <div class="modal-header" style="background-color: #fafafa;">
                <h5 class="modal-title" id="exampleModalLabel">Authentification</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body text-center">
                    <div id="fb-root"></div>
                    <script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v9.0&appId=266620018232985&autoLogAppEvents=1" nonce="Z43c2Xq9"></script>
                    <script src="js/Oauth2.js"></script>
                    <div class="fb-login-button" data-width="" data-size="large" data-button-type="login_with" data-layout="default"
                         data-auto-logout-link="false" data-use-continue-as="true" onLogin="checkLoginState()"></div>
                         <p> <span id="name"></span> </p>
                <form method="POST" action="login">
                    <input type="hidden" id="username" name="username"  />
                    <input type="hidden" id="idUser" name="idUser"  />
                    <button type="submit button" class="btn btn-default btn-circle btn-outline" >Continuer...</button>
                </form>
            </div>
        </div>
    </div>
</div>
