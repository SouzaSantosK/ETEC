import { StatusBar } from "expo-status-bar";
import { useState } from "react";
import {
  StyleSheet,
  Text,
  View,
  TouchableOpacity,
  Image,
  Modal,
} from "react-native";
import { useFonts } from "expo-font";
import { Button, ImageBackground } from "react-native-web";

export default function App() {
  const [loaded] = useFonts({
    Nunito: require("./assets/fonts/Nunito-VariableFont_wght.ttf"),
  });

  const [visibility, setVisibility] = useState(false);
  const [selectedPlanet, setSelectedPlanet] = useState(0);
  const [previousPlanet, setPreviousPlanet] = useState(0);
  const [nextPlanet, setNextPlanet] = useState(0);
  const planets = [
    {
      nome: "Mercúrio",
      periodo_orbital: "88 dias",
      satelites: "Nenhum",
      duracao_dia: "59 dias",
      descricao:
        "Planeta mais próximo do Sol, período orbital aproximado de 88 dias terrestres. Sua massa é de 3,3 x 10^23 kg e volume de 6,1 x 10^10 km³, é o menor planeta do sistema solar. Gravidade é de 3,7m/s² (aproximadamente 38% da gravidade da Terra). Mercúrio possui uma atmosfera composta por hélio, hidrogênio, oxigênio e vestígios de sódio e potássio e superfície rochosa e repleta de crateras, semelhante à da Lua. Suas temperaturas podem variar de -173°C até 427°C.",
      imagem: require("./assets/planets/mercury.png"),
    },
    {
      nome: "Vênus",
      periodo_orbital: "225 dias",
      satelites: "Nenhum",
      duracao_dia: "243 dias",
      descricao:
        "2° planeta do sistema solar, possui um período orbital de aproximadamente 225 dias terrestres. Seu período de rotação é bastante lento, levando cerca de 243 dias terrestres para completar uma volta sobre seu próprio eixo. Sua gravidade é de cerca de 91% da gravidade da Terra, o que significa que um objeto pesaria quase o mesmo em ambos os planetas. Atmosfera densa e composta por dióxido de carbono, com nuvens de ácido sulfúrico. Temperaturas na superfície são extremamente elevadas, chegando a 475°C, tornando-o o planeta mais quente do sistema solar. A superfície de Vênus é coberta por planícies vulcânicas, montanhas e crateras.",
      imagem: require("./assets/planets/venus.png"),
    },
    {
      nome: "Terra",
      periodo_orbital: "365 dias",
      satelites: "1",
      duracao_dia: "24h",
      descricao:
        "Nosso planeta possui um período orbital de 365 dias terrestres, resultando em um ano. Seu período de rotação é de 24 horas, determinando um dia. A gravidade na Terra é cerca de 9,8 m/s², permitindo que objetos caiam em direção ao solo. Nossa atmosfera é composta principalmente por nitrogênio e oxigênio, essencial para sustentar a vida. Ttemperaturas na Terra variam, desde regiões frias até áreas tropicais, dependendo da localização geográfica e da estação do ano. A superfície é diversa, apresentando oceanos, montanhas, planícies, desertos e vários ecossistemas.",
      imagem: require("./assets/planets/earth.png"),
    },
    {
      nome: "Marte",
      periodo_orbital: "687 dias",
      satelites: "2",
      duracao_dia: "1d 37min",
      descricao:
        "Marte possui um período orbital de 687 dias terrestres. Seu período de rotação é um pouco mais longo que o da Terra, durando cerca de 24,6 horas. A gravidade em Marte é cerca de 38% da gravidade terrestre. A atmosfera é composta principalmente por dióxido de carbono, com traços de nitrogênio e argônio. As temperaturas são frias, variando de -87°C a -5°C. Sua superfície é caracterizada por planícies, montanhas, crateras e possui o Monte Olimpo, o maior vulcão conhecido no sistema solar.",
      imagem: require("./assets/planets/mars.png"),
    },
    {
      nome: "Júpiter",
      periodo_orbital: "12 anos",
      satelites: "95",
      duracao_dia: "9h 56min",
      descricao:
        "O maior planeta do sistema solar, possui um período orbital de 11,9 anos terrestres. Seu período de rotação é bem rápido, durando 9,9 horas. A gravidade é cerca de 24,8 m/s² (2,5x a gravidade terrestre). A atmosfera de Júpiter é composta por hidrogênio e hélio, com nuvens de amônia e metano. As temperaturas são extremamente frias, chegando até -145°C. Júpiter não possui uma superfície sólida definida, apresentando uma atmosfera turbulenta e uma camada externa de nuvens listradas coloridas, incluindo a famosa Grande Mancha Vermelha.",
      imagem: require("./assets/planets/jupiter.png"),
    },
    {
      nome: "Saturno",
      periodo_orbital: "29 anos",
      satelites: "145",
      duracao_dia: "10h 34min",
      descricao:
        "Saturno possui um período orbital de 29,5 anos terrestres. Seu período de rotação é um dos mais curtos entre os planetas, durando 10,7 horas. A gravidade em Saturno é de 10,4 m/s² (1,1x a gravidade terrestre). Sua atmosfera é composta por hidrogênio e hélio, com traços de metano e amônia. As temperaturas são muito frias, chegando a  -178°C. Superfície composta por uma camada de nuvens e sua característica mais marcante é o sistema de anéis deslumbrante, composto por inúmeras partículas de gelo e poeira.",
      imagem: require("./assets/planets/saturn.png"),
    },
    {
      nome: "Urano",
      periodo_orbital: "84 anos",
      satelites: "27",
      duracao_dia: "17h 14min",
      descricao:
        "7° planeta do sistema solar. Período orbital de 84 anos terrestres. Seu período de rotação é único, com o eixo inclinado quase no plano orbital, resultando em rotação lateral. A gravidade em Urano é de 8,7 m/s² (0,9x a gravidade terrestre). A atmosfera de Urano é composta por hidrogênio e hélio, com traços de metano, que dão ao planeta sua coloração azul característica. As temperaturas em Urano são extremamente frias, chegando a cerca de -224°C. A superfície de Urano é composta por uma camada atmosférica espessa, sem uma superfície sólida bem definida.",
      imagem: require("./assets/planets/uranus.png"),
    },
    {
      nome: "Netuno",
      periodo_orbital: "165 anos",
      satelites: "14",
      duracao_dia: "16h 6min",
      descricao:
        "Netuno, 8° e último planeta, possui um período orbital de 165 anos terrestres. Seu período de rotação é rápido, durando cerca de 16,1 horas. A gravidade em Netuno é de 11,2 m/s² (1,1x a gravidade terrestre). A atmosfera de Netuno é composta por hidrogênio e hélio, com traços de metano, que contribuem para a cor azul intensa do planeta. As temperaturas em Netuno são extremamente frias, chegando a -218°C. A superfície de Netuno é composta por uma camada atmosférica densa, sem uma superfície sólida definida, com características como nuvens, tempestades e ventos violentos.",
      imagem: require("./assets/planets/neptune.png"),
    },
  ];

  function load_planet(index) {
    setVisibility(true);
    setSelectedPlanet(index);
    setPreviousPlanet(index == 0 ? planets.length - 1 : index - 1);
    setNextPlanet(index == planets.length - 1 ? 0 : index + 1);
  }

  function voltar() {
    setVisibility(false);
  }

  return (
    <View style={styles.body}>
      <ImageBackground
        source={require("./assets/planets/Planeta.jpg")}
        style={{ width: "100%", alignItems: "center" }}
      >
        <View style={styles.main}>
          <View style={styles.hero}>
            <View>
              <Text style={[styles.hero_text, styles.h1, styles.p]}>
                Bem-vindo ao espaço
              </Text>
              <Text style={[styles.p, styles.hero_text]}>
                Uma pequena viagem pelo sistema solar
              </Text>
            </View>
            <TouchableOpacity onPress={() => load_planet(4)}>
              <Image
                source={require("./assets/planets/jupiter.png")}
                style={styles.hero_image}
              ></Image>
            </TouchableOpacity>
          </View>

          <View>
            <TouchableOpacity
              style={styles.card}
              onPress={() => load_planet(0)}
            >
              <Text style={[styles.card_text, styles.p]}>Mercúrio</Text>
              <Image
                source={require("./assets/planets/mercury.png")}
                style={[
                  styles.background_planet,
                  {
                    right: "-80%",
                    bottom: "-100%",
                  },
                ]}
              ></Image>
            </TouchableOpacity>

            <TouchableOpacity
              style={styles.card}
              onPress={() => load_planet(1)}
            >
              <Text style={[styles.card_text, styles.p]}>Vênus</Text>
              <Image
                source={require("./assets/planets/venus.png")}
                style={[
                  styles.background_planet,
                  {
                    left: "-75%",
                    bottom: "-100%",
                  },
                ]}
              ></Image>
            </TouchableOpacity>

            <TouchableOpacity
              style={styles.card}
              onPress={() => load_planet(2)}
            >
              <Text style={[styles.card_text, styles.p]}>Terra</Text>
              <Image
                source={require("./assets/planets/earth.png")}
                style={[
                  styles.background_planet,
                  {
                    width: 350,
                    height: 350,
                    alignSelf: "center",
                    top: 0,
                  },
                ]}
              ></Image>
            </TouchableOpacity>

            <TouchableOpacity
              style={styles.card}
              onPress={() => load_planet(3)}
            >
              <Text style={[styles.card_text, styles.p]}>Marte</Text>
              <Image
                source={require("./assets/planets/mars.png")}
                style={[
                  styles.background_planet,
                  {
                    right: "-55%",
                    bottom: "-100%",
                  },
                ]}
              ></Image>
            </TouchableOpacity>

            <TouchableOpacity
              style={styles.card}
              onPress={() => load_planet(4)}
            >
              <Text style={[styles.card_text, styles.p]}>Jupiter</Text>
              <Image
                source={require("./assets/planets/jupiter.png")}
                style={[
                  styles.background_planet,
                  {
                    right: "-70%",
                    top: "-90%",
                  },
                ]}
              ></Image>
            </TouchableOpacity>

            <TouchableOpacity
              style={styles.card}
              onPress={() => load_planet(5)}
            >
              <Text style={[styles.card_text, styles.p]}>Saturno</Text>
              <Image
                source={require("./assets/planets/saturn.png")}
                style={[
                  styles.background_planet,
                  {
                    left: "-65%",
                    top: "-110%",
                    transform: "rotate(180deg)",
                  },
                ]}
              ></Image>
            </TouchableOpacity>

            <TouchableOpacity
              style={styles.card}
              onPress={() => load_planet(6)}
            >
              <Text style={[styles.card_text, styles.p]}>Urano</Text>
              <Image
                source={require("./assets/planets/uranus.png")}
                style={[
                  styles.background_planet,
                  {
                    width: 400,
                    height: 400,
                    right: "-50%",
                    bottom: "-100%",
                  },
                ]}
              ></Image>
            </TouchableOpacity>

            <TouchableOpacity
              style={styles.card}
              onPress={() => load_planet(7)}
            >
              <Text style={[styles.card_text, styles.p]}>Netuno</Text>
              <Image
                source={require("./assets/planets/neptune.png")}
                style={[
                  styles.background_planet,
                  {
                    width: 400,
                    height: 400,
                    left: "-55%",
                    bottom: "-100%",
                  },
                ]}
              ></Image>
            </TouchableOpacity>
          </View>

          <Modal visible={visibility} animationType="fade" transparent={true}>
            <View style={styles.modal_view}>
              <Image
                source={planets[selectedPlanet].imagem}
                style={styles.planet_image}
              ></Image>

              <View style={styles.modal_info}>
                <Text style={[styles.planet_name, styles.p]}>
                  {planets[selectedPlanet].nome}
                </Text>

                <View style={styles.grid}>
                  <View>
                    <Text style={[styles.p, styles.grid_name]}>
                      Período orbital
                    </Text>
                    <Text style={[styles.grid_value, styles.p]}>
                      {planets[selectedPlanet].periodo_orbital}
                    </Text>
                  </View>

                  <View>
                    <Text style={[styles.p, styles.grid_name]}>
                      Duração do dia
                    </Text>
                    <Text style={[styles.grid_value, styles.p]}>
                      {planets[selectedPlanet].duracao_dia}
                    </Text>
                  </View>

                  <View>
                    <Text style={[styles.p, styles.grid_name]}>Satélites</Text>
                    <Text style={[styles.grid_value, styles.p]}>
                      {planets[selectedPlanet].satelites}
                    </Text>
                  </View>
                </View>
                <View style={styles.about_card}>
                  <View style={styles.about_card_bar}></View>
                  <Text
                    style={[
                      styles.p,
                      {
                        fontWeight: "700",
                        fontSize: "18px",
                      },
                    ]}
                  >
                    Sobre
                  </Text>
                  <Text
                    style={[
                      styles.p,
                      {
                        marginVertical: 10,
                      },
                    ]}
                  >
                    {planets[selectedPlanet].descricao}
                  </Text>
                  <Text
                    style={[
                      styles.p,
                      {
                        color: "#9c9c9c",
                        fontWeight: "700",
                        fontSize: "16px",
                      },
                    ]}
                  >
                    Mais planetas
                  </Text>
                  <View style={styles.grid_images}>
                    <TouchableOpacity
                      style={styles.grid_image}
                      onPress={() => load_planet(previousPlanet)}
                    >
                      <Image
                        source={planets[previousPlanet].imagem}
                        style={[
                          styles.background_planet,
                          {
                            width: 70,
                            height: 70,
                          },
                        ]}
                      ></Image>
                    </TouchableOpacity>

                    <TouchableOpacity
                      style={styles.grid_image}
                      onPress={() => load_planet(nextPlanet)}
                    >
                      <Image
                        source={planets[nextPlanet].imagem}
                        style={[
                          styles.background_planet,
                          {
                            width: 70,
                            height: 70,
                          },
                        ]}
                      ></Image>
                    </TouchableOpacity>
                  </View>
                </View>
              </View>

              <TouchableOpacity
                style={styles.modal_button}
                title="Voltar"
                onPress={() => voltar()}
              >
                <Text style={[styles.p, styles.button_text]}>Voltar</Text>
              </TouchableOpacity>
            </View>
          </Modal>
        </View>
        <StatusBar style="auto" />
      </ImageBackground>
    </View>
  );
}

const styles = StyleSheet.create({
  body: {
    flex: 1,
    backgroundColor: "black",
    alignItems: "center",
    minHeight: "100vh",
    overflow: "hidden",
  },
  main: {
    flex: 1,
    maxWidth: 380,
    gap: 50,
    paddingVertical: 20,
    paddingHorizontal: 10,
  },
  p: {
    fontFamily: "Nunito",
    color: "#FBFBFB",
  },
  hero: {
    justifyContent: "space-between",
  },
  h1: {
    fontSize: "2.5rem",
    fontWeight: 400,
    maxWidth: "65%",
    color: "#FBFBFB",
  },
  hero_text: {
    color: "#C2C2C2",
    fontSize: "18px",
    maxWidth: "50%",
  },
  hero_image: {
    height: "650px",
    width: "650px",
    transform: "translateX(50px)",
    opacity: "0.7",
  },
  card: {
    height: "125px",
    borderRadius: 15,
    justifyContent: "flex-end",
    padding: "10px",
    position: "relative",
    overflow: "hidden",
    border: "1px solid rgba(255, 255, 255, 0.2)",
    marginVertical: 5,
    backgroundColor: "#000",
  },
  card_text: {
    fontWeight: "700",
    fontSize: "1.6rem",
    letterSpacing: "2px",
  },
  background_planet: {
    resizeMode: "contain",
    position: "absolute",
    width: 600,
    height: 600,
    zIndex: -1,
  },
  modal: {
    flex: 1,
  },
  modal_view: {
    flex: 1,
    backgroundColor: "#000",
    padding: 10,
    alignItems: "center",
    justifyContent: "space-between",
    gap: 10,
  },
  planet_image: {
    resizeMode: "contain",
    width: 250,
    height: 250,
    flex: 2,
  },
  modal_info: {
    width: "100%",
    gap: 20,
    justifyContent: "space-between",
    position: "relative",
  },
  planet_name: {
    fontWeight: 700,
    fontSize: "1.6rem",
    textAlign: "center",
  },
  grid: {
    display: "grid",
    gridTemplateColumns: "repeat(3, 1fr)",
    textAlign: "center",
  },
  grid_name: {
    color: "#C2C2C2",
    fontWeight: "600",
  },
  grid_value: {
    fontWeight: "600",
    fontSize: "18px",
    marginTop: "10px",
  },
  about_card: {
    backgroundColor: "#272727",
    flex: 2,
    borderRadius: 10,
    paddingVertical: "1.5rem",
    paddingHorizontal: "1rem",
  },
  about_card_bar: {
    backgroundColor: "#fff",
    opacity: 0.4,
    position: "absolute",
    borderRadius: 10,
    height: 5,
    width: "25%",
    alignSelf: "center",
    top: 10,
  },
  grid_images: {
    display: "grid",
    gridTemplateColumns: "repeat(2, 1fr)",
    marginTop: 5,
    gap: 15,
    paddingHorizontal: 5,
  },
  grid_image: {
    backgroundColor: "#000",
    overflow: "hidden",
    height: 80,
    borderRadius: 10,
    justifyContent: "center",
    alignItems: "center",
    border: "2px solid #662A32",
  },
  modal_button: {
    width: "100%",
    height: 50,
    justifyContent: "center",
    textAlign: "center",
    border: "1px solid #42ACFB",
    borderRadius: 10,
  },
  button_text: {
    fontWeight: "700",
    fontSize: "2rem",
    letterSpacing: 2,
    textTransform: "uppercase",
  },
});
