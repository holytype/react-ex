import React, { useEffect } from 'react';
import axios from 'axios';
import Regist from './Regist';
import Login from './Login';
import {BrowserRouter, Route, Routes} from "react-router-dom";

function App() {

  return (
  <BrowserRouter>
      <Routes>
        <Route path="/regist" element={<Regist/>}></Route>
        <Route path="/Login" element={<Login/>}></Route>
      </Routes>
  </BrowserRouter>
  );
}

export default App;

