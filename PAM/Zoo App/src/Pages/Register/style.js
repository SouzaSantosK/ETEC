import { StyleSheet } from "react-native";

export default StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#101010",
    fontSize: "16px",
  },
  backgroundImage: {
    flex: 1,
  },
  linearGradient: {
    flex: 1,
    padding: 30,
  },
  header: {
    justifyContent: "center",
  },
  headerP: {
    fontSize: 35,
    fontFamily: "Inter-Bold",
    color: "#FF6347",
    textTransform: "uppercase",
  },
  form: {
    flex: 2,
    justifyContent: "flex-end",
    gap: 20,
  },
  label: {
    fontFamily: "Inter-Bold",
    fontSize: 25,
    height: 60,
    color: "#fff",
    display: "flex",
    alignItems: "center",
  },
  input: {
    border: "2px solid #FF6347",
    height: 60,
    borderRadius: 10,
    fontSize: 18,
    paddingHorizontal: 30,
    color: "#rgba(255, 255, 255, 0.8)",
    fontFamily: "Inter-Bold",
  },
  buttons: {
    display: "flex",
    rowGap: 20,
    flex: 1,
    justifyContent: "flex-end",
  },
  button: {
    height: 60,
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
    borderRadius: 10,
  },
  login: {
    backgroundColor: "#FF6347",
  },
  buttonText: {
    color: "#fff",
    fontFamily: "Inter-Bold",
    fontSize: 18,
  },
});
