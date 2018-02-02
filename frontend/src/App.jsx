import React, {Component} from 'react';
import {BrowserRouter as Router, Route} from 'react-router-dom';

import logo from './rocket-ship.svg';
import './App.css';

import {Pessoas} from './fotos/Pessoas';
import {Imagens} from './fotos/Imagens';

class App extends Component {

    render() {
        return (
            <Router>
                <div className="App">
                    <header className="App-header">
                        <img src={logo} className="App-logo" alt="logo"/>
                        <h1 className="App-title">Avatorkt</h1>
                    </header>
                    <br/>
                    <Route exact path="/" component={Pessoas}/>
                    <Route path="/imagens" component={Imagens}/>
                </div>
            </Router>
        );
    }
}

export default App;
