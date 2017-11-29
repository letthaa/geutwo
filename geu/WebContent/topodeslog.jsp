<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">GEU</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/geu/index.jsp">Inicio</a></li>

				<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="registro.jsp">Registro</a>
				</li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Login <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li>
							<form action="login" method="post">
								Login: <input name="login" type="text" required><br>
								Senha: <input name="senha" type="password" required><br>
								<br>
								<button type="submit">Entrar</button>
							</form>
						</li>
					</ul>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>