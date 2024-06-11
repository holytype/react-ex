import logo from './logo.svg';
import './App.css';
import axios from "axios";

const onNaverLogin = () => {

  window.location.href = "http://localhost:8080/oauth2/authorization/naver"
}

function Login(props) {
  return (
      <>
        <h1>Login</h1>
        <button onClick={onNaverLogin}>naver login</button>
      </>
  );
}

const getData = () => {
  axios
      .get("http://localhost:8080/my", {withCredentials: true})
      .then((res) => {
        alert(JSON.stringify(res.data))

      })
      .catch((error) => alert(error))
}

function App() {
  return (
      <>
        <button onClick={onNaverLogin}>Naver Login</button>
        <button onClick={getData}>get DATA</button>
      </>
  );
}

export default App;
