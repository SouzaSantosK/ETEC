<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="home.css" />
    <title>PHP</title>
  </head>
  <body>
    <div class="background-fade"></div>
    <aside></aside>
    <main>
      <header>
        <div>
          <p class="introduction-text">Bem-vindo ao quiz de</p>
          <h1>Minecraft</h1>
        </div>
      </header>

      <section>
        <form method="post" action="um.php">
          <div>
            <label for="name" id="name-label">
              Antes de começarmos, digite seu nome
            </label>
            <input type="text" name="name" id="name" placeholder="Nome" />
          </div>

          <div class="character-selection hidden">
            <p>Perfeito! Agora escolha um personagem</p>
            <div class="character-grid">
              <input type="radio" name="character-index" id="steve" value="0" />
              <label for="steve" class="character">
                <img src="images/steve-head.png" />
              </label>

              <input type="radio" name="character-index" id="whiter-skeleton" value="1" />
              <label for="whiter-skeleton" class="character">
                <img src="images/whiter-skeleton-head.png" />
              </label>

              <input type="radio" name="character-index" id="skeleton" value="2" />
              <label for="skeleton" class="character">
                <img src="images/skeleton-head.png" />
              </label>

              <input type="radio" name="character-index" id="spider" value="3" />
              <label for="spider" class="character">
                <img src="images/dragon-head.png" />
              </label>

              <input type="radio" name="character-index" id="creeper" value="4" />
              <label for="creeper" class="character">
                <img src="images/creeper-head.png" />
              </label>

              <input type="radio" name="character-index" id="zombie" value="5" />
              <label for="zombie" class="character">
                <img src="images/zombie-head.png" />
              </label>

              <input type="radio" name="character-index" id="herobrine" value="6" />
              <label for="herobrine" class="character">
                <img src="images/piglin-head.png" />
              </label>
              <input type="radio" name="character-index" id="lich" value="7" />
              <label for="lich" class="character">
                <img src="images/lich.png" style="width: 60px; transform: scaleX(-1);" />
              </label>
            </div>
          </div>

          <button type="submit" class="disabled hidden">Começar</button>
        </form>
      </section>
    </main>
    <script src="home.js"></script>
  </body>
</html>
