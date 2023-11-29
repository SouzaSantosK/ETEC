<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./src/styles/register.css" />
    <title>Registro</title>
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0"
    />
  </head>
  <body>
    <main>
      <section>
        <button class="close">
          <a href="./index.php">
            <span class="material-symbols-outlined"> close </span>
          </a>
        </button>
        <aside></aside>
        <div class="left-side">
          <h2>Registre-se</h2>

          <form action="./src/scripts/register.php" method="post">
            <div class="input-group">
              <input required type="email" id="email" name="email" />
              <label for="email">Email</label>
            </div>
            <div class="input-group">
              <input required type="password" id="password" name="password" />
              <label for="password">Senha</label>
            </div>
            <div class="input-group">
              <input required type="text" id="username" name="username" />
              <label for="username" class="username">Nome de usuário</label>
            </div>
            <div class="divisor">
              <div class="input-group">
                <input required type="text" id="first-name" name="first-name" />
                <label for="first-name">Nome</label>
              </div>
              <div class="input-group">
                <input required type="text" id="last-name" name="last-name" />
                <label for="last-name">Sobrenome</label>
              </div>
              <div class="input-group">
                <select required type="text" id="county" name="county">
                  <option value="">Selecione uma opção</option>
                  <option value="São Paulo">São Paulo</option>
                  <option value="Santo André">Santo André</option>
                  <option value="São Bernardo">São Bernardo</option>
                  <option value="São Caetano">São Caetano</option>
                  <option value="Itaquera">Itaquera</option>
                  <option value="Tatuapé">Tatuapé</option>
                </select>
                <label for="county">Município</label>
              </div>
              <div class="input-group">
                <input required type="text" id="course" name="course" />
                <label for="course">Curso</label>
              </div>
            </div>
            <div class="input-group">
              <input
                required
                type="tel"
                id="phone"
                minlength="9"
                name="phone"
              />
              <label for="phone">Telefone</label>
            </div>
            <div class="terms">
              <input type="checkbox" name="cb" id="cb" required />
              <p>
                Ao clicar você concorda em aceitar nossos
                <span>termos e condições</span> e que você está ciente das
                <span>políticas de responsabilidade da plataforma</span>.
              </p>
            </div>
            <button type="submit" class="submit">Criar conta</button>
          </form>
        </div>
      </section>
    </main>
    <script src="./src/scripts/listener.js"></script>
  </body>
</html>
