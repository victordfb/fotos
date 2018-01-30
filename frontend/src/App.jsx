import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import {Pessoas} from './fotos/Pessoas';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Avatarilus</h1>
        </header>
        <br/>
        <Pessoas />
      </div>
    );
  }
}

export default App;
